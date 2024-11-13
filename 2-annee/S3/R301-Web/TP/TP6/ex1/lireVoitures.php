<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>toutes les voitures</title>
	<link rel="stylesheet" href="styleMenu.css">
</head>
<body>
	<?php
		// insertion du menu
		include("menu.html");

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
		foreach ($tab_v as $v) {
			$v->afficher();
		}
	?>
</body>
</html>
