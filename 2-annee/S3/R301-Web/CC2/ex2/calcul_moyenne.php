<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <title>CC2-EX2-calc</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h2>Calcul de la moyenne pondérée
        </h2>
        <?php
            $somme = 0;
            for($i = 0;$i<$nbNote;$i++)
                echo "<p>Matière « $_GET[" . mat . "+$i] » : Note = $_GET[" . note . "+$i]</p>";
                for($i = 0;$i<$Coef;$i++){
                    $somme += $_GET["note"+$i];    
            }
            $moyPonderee = $somme/$nbNote;
            echo "<p>Moyenne pondérée : $moyPonderee</p>";

        ?>
        <a href="notes.html">Retour au formulaire</a>
    </body>
</html>