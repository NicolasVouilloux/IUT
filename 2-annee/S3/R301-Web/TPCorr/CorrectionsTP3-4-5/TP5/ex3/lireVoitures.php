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

    // écriture de la requête
		$requete = "SELECT * FROM voiture;";
    // envoi de la requête et stockage de la réponse
		$resultat = connexion::pdo()->query($requete);
    // traitement de la réponse
    $resultat->setFetchmode(PDO::FETCH_CLASS,'Voiture');
    $tableau = $resultat->fetchAll();
		// affichage du tableau
		echo "<pre>"; print_r($tableau); echo "</pre>";
    // construction en boucle des voitures avec affichage
		echo "<ul>";
		foreach ($tableau as $v) {
			echo "<li>";
			$v->afficher();
			echo "</li>";
		}
		echo "</ul>";
	?>
</body>
</html>
