<?php
    // insertion des classes Utilisateur 
    require_once("modele/utilisateur.php");

    // définition du contrôleur Utilisateur
    class ControleurUtilisateur{

        //La méthode de récupération et d'affichage de tous les utilisateurs
        public static function lireUtilisateurs(){
            if (isset($_GET["login"])){
                $i = $_GET["login"];
                $tab_u = utilisateur::getUtilisateurByLogin($i);
            }else {
                $tab_u = Utilisateur::getAllUtilisateurs();
            }
            // titre de la page
            $titre = "tous les utilisateurs";
        
            // insertion du debut du html
            include("vue/debut.php");
            
            // insertion du menu 
            include("vue/menu.html");
            
            if(!$tab_u){
                include("vue/utilisateur/erreur.php");    
            }
            else if (sizeof($tab_u)==1){
                include("vue/utilisateur/unUtilisateur.php");
            }
            else{
                include("vue/utilisateur/lesUtilisateurs.php");
            }   
            // insertion de la fin 
            include("vue/fin.html");
        }
    }
?>