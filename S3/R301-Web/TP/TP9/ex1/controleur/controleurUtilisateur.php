<?php
    // insertion des classes Utilisateur 
    require_once("modele/modele.php");
    require_once("modele/utilisateur.php");

    // définition du contrôleur Utilisateur
    class ControleurUtilisateur{

        //La méthode de récupération et d'affichage de tous les utilisateurs
        public static function lireUtilisateurs(){
            if (isset($_GET["login"])){
                $i = $_GET["login"];
                $tab = Utilisateur::getObjetById($i);
            }else {
                $tab = Utilisateur::getAll();
            }
            // titre de la page
            $titre = "tous les utilisateurs";
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