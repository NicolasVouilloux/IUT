<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TP4 - ex2</title>
</head>
<body>
  <h2>construction de l'objet Voiture</h2>
	<?php
		// insertion de la classe Voiture
		require_once("voiture.php");
		// récupération des informations passées en "get"
		$i = $_GET["immatriculation"];
		$m = $_GET["marque"];
		$c = $_GET["couleur"];
		// création de l'objet Voiture
		$v = new Voiture($i, $m, $c);
		// affichage de la voiture créée
		$v->afficher();
	?>
	<a href="formulaireVoiture.html">retour au formulaire</a>
</body>
</html>
