<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <title>CC2-EX1-calc</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h2>Calcul de la moyenne pondérée
        </h2>
        <?php
            if(isset($_GET["notePhp"]))
                $notePhp= $_GET["notePhp"];
            if(isset($_GET["noteBd"]))
                $noteBd= $_GET["noteBd"];
            if(isset($_GET["noteReseau"]))
                $noteReseau=$_GET["noteReseau"];
            if(isset($_GET["noteAnglais"]))
                $noteAnglais=$_GET["noteAnglais"];
            
            echo "<p>Matière « PHP » : Note = $notePhp</p>";
            echo "<p>Matière « Base de données » : Note = $noteBd</p>";
            echo "<p>Matière « Réseaux » : Note = $noteReseau</p>";
            echo "<p>Matière « Anglais » : Note = $noteAnglais</p>";

            $somme = $notePhp+$noteBd+$noteReseau+$noteAnglais;
            $moyPonderee = $somme/4;
            echo "<p>Moyenne pondérée : $moyPonderee</p>";

        ?>
        <a href="notes.html">Retour au formulaire</a>
    </body>
</html>