<?php
    // insert classe Voiture
    require_once("modele/voiture.php");

    // définition du contrôleur Voiture
    class ControleurVoiture{

        // La méthode de récupération et d'affichage de toutes Les voitures
        public static function lireVoitures(){
            if (isset($_GET["immatriculation"]))
                $i = $_GET["immatriculation"];
        
            $tab_v = Voiture::getVoitureByImmat($i);

            // titre de la page
            $titre = "la voiture";
        
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