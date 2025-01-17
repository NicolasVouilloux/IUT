<?php
    // insertion des classes Voiture et connexion
	require_once("config/connexion.php");

	// appel de la méthode de connexion
	Connexion::connect();

    //initialisation des variables par defaut
    $controleur = "controleurVoiture";
    $action = "lireVoitures";

    // initialisation du tableau de verification des controleurs
    $tableauControleurs = ["controleurVoiture","controleurUtilisateur"];
    $actionParDefaut = array(
        "controleurVoiture" => "lireVoitures",
        "controleurUtilisateur" => "lireUtilisateurs"
    );

    //verification de l'url pour pouvoir mettre a jour les variables par défaut
    if(isset($_GET["controleur"])){
        if(in_array($_GET["controleur"],$tableauControleurs))
            $controleur= $_GET["controleur"];
    }
    
    require_once("controleur/$controleur.php");
    
    //creation des variables de nom de fonction par classe
    $classFunctions = get_class_methods($controleur);
    
    if(isset($_GET["action"])){
        if(in_array($_GET["action"],$classFunctions))
            $action= $_GET["action"];
        else
            $action= $classFunctions[0];
    }

    $controleur::$action();
?>