<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>TP2 - ex1c</title>
  </head>
  <body>
    <h2>tableau des capitaux successifs</h2>
    <?php
    
      $capital = array(
        10000
      );
      // increasing the capitale over the year
      for ($i = 1;$i < 10;$i++){
        $capital[$i] = floor((($capital[$i-1])+(($capital[$i-1])*(5/100))));
      };


      //writting in html
      echo "<p>Augmentation du capitale</p>";
      echo "<pre>";
      print_r($capital);
      echo "</pre>";
    ?>

  </body>
</html>
