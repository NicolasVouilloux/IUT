<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TP5 - ex3 - les voitures</title>
</head>
<body>
	<?php
		// insertion des classes Voiture et connexion
    require_once("voiture.php");
		require_once("connexion.php");

    // appel de la méthode de connexion
		Connexion::connect();

    // récupération des voitures
		$tableau = Voiture::getAllVoitures();
		
		// affichage du tableau
		echo "<pre>"; print_r($tableau); echo "</pre>";
    // construction en boucle des voitures avec affichage
		foreach ($tableau as $v) {
			$v->afficher();
		}
	?>
</body>
</html>
