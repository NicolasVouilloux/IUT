<?php
    // insert classe Voiture
    require_once("modele/voiture.php");

    // définition du contrôleur Voiture
    class ControleurVoiture{

        // La méthode de récupération et d'affichage de toutes Les voitures
        public static function lireVoitures(){

            // titre de la page
            $titre = "toutes les voitures";
           
            // récupération des voitures
            $tab_v = Voiture::getAllVoitures();
        
            // insertion du debut du html
            include("vue/debut.php");
        
            // insertion du menu
            include("vue/menu.html");
        
            // affichage du tableau
            include("vue/voiture/lesVoitures.php");
            
            // insertion de la fin 
            include("vue/fin.html");
        }
    }
?>