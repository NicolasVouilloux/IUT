<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TP4 - ex1</title>
</head>
<body>
  <h2>tests de construction d'objets Voiture</h2>
	<?php
		// insertion de la classe Voiture
		require_once("voiture.php");
		// création de quelques voitures
		$v1 = new Voiture("123AB45","Renault","bleu");
		$v2 = new Voiture("456CD78","Ferrari","rouge");
		$v3 = new Voiture("JB007","Aston Martin","gris");
		// affichage des voitures
		$v1->afficher();
		$v2->afficher();
		$v3->afficher();
	?>
</body>
</html>
