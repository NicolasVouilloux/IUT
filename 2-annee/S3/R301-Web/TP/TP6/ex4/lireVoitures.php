<?php
	// insertion des classes Voiture et connexion
	require_once("config/connexion.php");

	// appel de la méthode de connexion
	Connexion::connect();

	// appel du controlleur
	require_once("controleur/controleurVoiture.php");
?>
