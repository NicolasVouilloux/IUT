<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TP6 - ex3 - Le répertoire vue et quelques fichiers « vue »</title>
	<link rel="stylesheet" href="css/styleMenu.css">
</head>
<body>
	<?php
		// insertion du menu 
		include("menu.html");

		// insertion des classes Utilisateur et connexion
    require_once("modele/utilisateur.php");
		require_once("config/connexion.php");

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
