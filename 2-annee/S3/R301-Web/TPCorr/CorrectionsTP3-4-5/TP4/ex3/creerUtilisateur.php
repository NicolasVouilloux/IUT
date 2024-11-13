<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TP4 - ex3</title>
</head>
<body>
  <h2>construction de l'objet Utilisateur</h2>
	<?php
		// insertion de la classe Utilisateur
		require_once("utilisateur.php");
		// récupération des informations passées en "get"
		$l = $_GET["login"];
		$m = $_GET["mdp"];
		$n = $_GET["nom"];
		$p = $_GET["prenom"];
		$e = $_GET["email"];
		// création de l'objet Utilisateur
		$u = new Utilisateur($l, $m, $n, $p, $e);
		// affichage de l'utilisateur créé
		$u->afficher();
	?>
	<a href="formulaireUtilisateur.html">retour au formulaire</a>
</body>
</html>
