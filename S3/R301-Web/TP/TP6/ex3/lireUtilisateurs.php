<?php
	// titre de la page
	$titre = "tous les utilisateurs";

	// insertion du debut du html
	include("vue/debut.php");

	// insertion du menu 
	include("vue/menu.html");

	// insertion des classes Utilisateur et connexion
require_once("modele/utilisateur.php");
	require_once("config/connexion.php");

// appel de la méthode de connexion
	Connexion::connect();

// récupération des voitures
	$tab_u = Utilisateur::getAllUtilisateurs();

	// affichage du tableau
	//echo "<pre>"; print_r($tab_u); echo "</pre>";
	include("vue/utilisateur/lesUtilisateurs.php");
	// insertion de la fin 
	include("vue/fin.php");
?>

