<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>TP3 - ex1</title>
  </head>
  <body>
    <h2>test password</h2>
    <?php
      if (isset($_GET["password"])) {
        echo "<p>l'entrée <b><i>password</i></b> existe :</p>";
        echo '<p>$_GET["password"] = '.$_GET["password"]."</p>";
      } else {
        echo "<p>l'entrée <b><i>password</i></b> n'existe pas !</p>";
      }
    ?>
  </body>
</html>
