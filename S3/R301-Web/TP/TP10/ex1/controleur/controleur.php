<?php
    require_once("modele/modele.php");
    require_once("modele/utilisateur.php");
    require_once("modele/voiture.php");

    class Controleur{
        //La méthode de récupération et d'affichage de tous les utilisateurs
        public static function lireObjets(){
            if (isset($_GET["login"])){
                $i = $_GET["login"];
                $tab = Utilisateur::getObjetById($i);
            }else {
                $tab = Utilisateur::getAll();
            }
            $objetsTitre = static::$objet;
            // titre de la page
            $titre = "les $objetsTitre";
            $cle = Utilisateur::getCle();
            $objet = Utilisateur::getObjet();
        
            // insertion du debut du html
            include("vue/debut.php");
            
            // insertion du menu 
            include("vue/menu.html");
            
            if(!$tab){
                include("vue/erreur.php");    
            }
            else if (sizeof($tab)==1){
                include("vue/unObjet.php");
            }
            else{
                include("vue/lesObjets.php");
            }   
            // insertion de la fin 
            include("vue/fin.html");
        }
    }

?>