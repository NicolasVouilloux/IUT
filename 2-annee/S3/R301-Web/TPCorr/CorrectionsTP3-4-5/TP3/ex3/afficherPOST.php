<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>affichage de $_POST</title>
  </head>
  <body>
    <h2>affichage de $_POST</h2>
    <?php
      echo "<pre>";
      print_r($_POST);
      echo "</pre>";
    ?>
    <a href="formulairePOST.html">retour au formulaire</a>
  </body>
</html>
