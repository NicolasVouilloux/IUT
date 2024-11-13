<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>affichage de la voiture</title>
  </head>
  <body>
    <h2>affichage de la voiture</h2>
    <?php
      echo "<pre>";
      print_r($_GET);
      echo "</pre>";
      $i = $_GET["immatriculation"];
      $m = $_GET["marque"];
      $c = $_GET["couleur"];
      echo "<p>voiture $i de marque $m et de couleur $c</p>";
    ?>
    <a href="formulaireVoiture.html">retour au formulaire</a>
  </body>
</html>
