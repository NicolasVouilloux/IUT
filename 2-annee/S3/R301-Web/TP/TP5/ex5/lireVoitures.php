<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>TP5 - ex3 - les voitures</title>
</head>
<body>
</body>
<?php
    require_once("voiture.php");
    require_once("connexion.php");
    connexion::connect();
    $monGarage = voiture::getAllVoitures();
    echo "<pre>";
    print_r($monGarage);
    echo "</pre>";
    echo "<ul>";
    foreach($monGarage as $value) {
        $marque = $value->get('marque');
        $couleur = $value->get('couleur');
        $immatriculation = $value->get('immatriculation');
        echo "<li>Voiture $immatriculation, de marque $marque, de couleur $couleur</li>";
    }
    echo "</ul>";
?>
</html>