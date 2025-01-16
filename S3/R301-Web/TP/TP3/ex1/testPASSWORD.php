<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>TP3 - ex1</title>
     
  </head>
  <body>
    <h2>test password</h2>
    <?php
    if (isset($_GET["password"])){
        echo"<p>l'entée password existe :</p>";
        echo ($_GET["password"]);
    }
    else
        echo"<p>l'entrée password n'existe pas !</p>";
    ?>
  </body>
</html>