<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <title>CC2-EX3-calc</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h2>Calcul de la moyenne pondérée
        </h2>
        <?php
            $somme = 0;
            for($i = 0;$i<$nbNote;$i++){
                echo "<p>Matière « $_GET[" . mat . "+$i] » : Note = $_GET[" . note . "+$i]</p>";
                for($i = 0;$i<$Coef;$i++)
                    $somme += $_GET["note"+$i];    
            }
            if(isset($_GET["typeMoy"]))
                $typeMoy= $_GET["typeMoy"];
            if($typeMoy = "ponderee"){
                $moyPonderee = $somme/$nbNote;
                echo "<p>Moyenne pondérée : $moyPonderee</p>";
            }
            else if($typeMoy = "ponderee"){
                $moySimple = $somme/$nbNote;
                echo "<p>Moyenne Simple : $moySimple</p>";
            }     
        
        ?>
        <a href="notes.html">Retour au formulaire</a>
    </body>
</html>