<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>TP4 - ex1</title>
     
  </head>
  <body>
    <h2>tests de construction d'objets Voiture
    </h2>
    <?php
        require_once("voiture.php");
        $voiture1 = new voiture("dacia","rouge","A123 EHE 92");
        $voiture2 = new voiture("reunault","vert","AAAAAAAAAA");
        $voiture3 = new voiture("skoda","blouge","LELE991EEE");

        $voiture1->afficher();
        $voiture2->afficher();
        $voiture3->afficher();
    ?>
  </body>
</html>