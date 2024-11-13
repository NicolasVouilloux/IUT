<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TP5 - ex4 - les utilisateurs</title>
	<link rel="stylesheet" href="styleMenu.css">
</head>
<body>
	<nav>
		<a href="lireVoitures.php">liste des voitures</a>
		<a href="lireUtilisateurs.php">liste des utilisateurs</a>
	</nav>
	<?php
		// insertion des classes Utilisateur et connexion
    require_once("utilisateur.php");
		require_once("connexion.php");

    // appel de la méthode de connexion
		Connexion::connect();

    // récupération des voitures
		$tab_u = Utilisateur::getAllUtilisateurs();

		// affichage du tableau
		//echo "<pre>"; print_r($tab_u); echo "</pre>";
    // construction en boucle des utilisateurs avec affichage
		foreach ($tab_u as $u) {
			$u->afficher();
		}
	?>
</body>
</html>
