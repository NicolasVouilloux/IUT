<?php
    // insertion des classes Voiture et connexion
	require_once("config/connexion.php");

	// appel de la méthode de connexion
	Connexion::connect();

    $controleur = "controleurVoiture";

    if(isset($_GET["controleur"]))
                $controleur= $_GET["controleur"];

    require_once("controleur/$controleur.php");
?>