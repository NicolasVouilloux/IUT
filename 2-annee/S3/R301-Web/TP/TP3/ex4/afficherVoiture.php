<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>TP3 - ex3</title>
     
  </head>
  <body>
    <h2>Affichage de la voiture
    </h2>
    <?php
      if(isset($_GET["immatriculation"]))
        $imma= $_GET["immatriculation"];
      if(isset($_GET["marque"]))
        $marque= $_GET["marque"];
      if(isset($_GET["couleur"]))
        $couleur=$_GET["couleur"];

      echo "<pre>";
      print_r($_GET);
      echo "</pre>";
      echo "<p>voiture $imma de marque $marque et de couleur $couleur</p>"
    ?>
    <a href="formulairePOST.html">retour au formulaire</a>
  </body>
</html>