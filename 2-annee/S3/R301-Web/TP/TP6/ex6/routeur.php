<?php
    // insertion des classes Voiture et connexion
	require_once("config/connexion.php");

	// appel de la méthode de connexion
	Connexion::connect();

    //initialisation des variables par defaut
    $controleur = "controleurVoiture";
    $action = "lireVoitures";

    //verification de l'url pour pouvoir mettre a jour les variables par défaut
    if(isset($_GET["controleur"]))
                $controleur= $_GET["controleur"];

    if(isset($_GET["action"]))
                $action= $_GET["action"];

    require_once("controleur/$controleur.php");

    $controleur::$action();
?>