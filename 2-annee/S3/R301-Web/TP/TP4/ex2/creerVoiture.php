<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <title>TP4 - ex2</title>
    </head>
    <body>
        <h2>tests de construction d'objets Voiture
        </h2>
        <?php
            require_once("voiture.php");
            if(isset($_GET["immatriculation"]))
                $imma= $_GET["immatriculation"];
            if(isset($_GET["marque"]))
                $marque= $_GET["marque"];
            if(isset($_GET["couleur"]))
                $couleur=$_GET["couleur"];
            (new voiture($marque,$couleur,$imma))->afficher();
        ?>
        <a href="formulaireVoiture.html">retour au formulaire</a>
    </body>
</html>