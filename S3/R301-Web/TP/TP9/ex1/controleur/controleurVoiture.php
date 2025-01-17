<?php
    // insert classe Voiture
    require_once("modele/modele.php");
    require_once("modele/voiture.php");

    // définition du contrôleur Voiture
    class ControleurVoiture{

        // La méthode de récupération et d'affichage de toutes Les voitures
        public static function lireVoitures(){
            if (isset($_GET["immatriculation"])){
                $i = $_GET["immatriculation"];
                $tab = Voiture::getObjetById($i);
            }else {
                $tab = Voiture::getAll();
            }
            // titre de la page
            $titre = "la voiture";
        
            // insertion du debut du html
            include("vue/debut.php");
        
            // insertion du menu
            include("vue/menu.html");
            
            if(!$tab){
                include("vue/voiture/erreur.php");    
            }
            else if (sizeof($tab)==1){
                include("vue/voiture/uneVoiture.php");
            }
            else{
                include("vue/lesObjets.php");
            }       
            // insertion de la fin 
            include("vue/fin.html");
        }
    }
?>