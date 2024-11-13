
<?php
	// titre de la page
	$titre = "toutes les voitures";

	// insertion du debut du html
	include("vue/debut.php");

	// insertion du menu
	include("vue/menu.html");

	// insertion des classes Voiture et connexion
require_once("modele/voiture.php");
	require_once("config/connexion.php");

// appel de la méthode de connexion
	Connexion::connect();

// récupération des voitures
	$tab_v = Voiture::getAllVoitures();

	// affichage du tableau
	//echo "<pre>"; print_r($tab_v); echo "</pre>";
// construction en boucle des voitures avec affichage
	include("vue/voiture/lesVoitures.php");
	// insertion de la fin 
	include("vue/fin.php");
?>
