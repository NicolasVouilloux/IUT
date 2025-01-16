<?php
    // insertion des classes Utilisateur 
    require_once("modele/utilisateur.php");

    // définition du contrôleur Utilisateur
    class ControleurUtilisateur{

        //La méthode de récupération et d'affichage de tous les utilisateurs
        public static function lireUtilisateurs(){
            
            // titre de la page
            $titre = "tous les utilisateurs";
        
            // récupération des voitures
            $tab_u = Utilisateur::getAllUtilisateurs();
            
            // insertion du debut du html
            include("vue/debut.php");
            
            // insertion du menu 
            include("vue/menu.html");
        
            // affichage du tableau
            include("vue/utilisateur/lesUtilisateurs.php");
            
            // insertion de la fin 
            include("vue/fin.html");
        }
    }
?>