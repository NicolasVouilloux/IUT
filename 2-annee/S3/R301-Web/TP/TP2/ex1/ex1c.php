<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>TP2 - ex1c</title>
  </head>
  <body>
    <h2>Les vainqueurs de la coupe du monde de football depuis 1930</h2>
    <?php
      $Palmares = array(
        1930 => "Uruguay",
        1934 => "Italie",
        1938 => "Italie",
        1950 => "Uruguay",
        1954 => "Allemagne",
        1958 => "Brésil",
        1962 => "Brésil",
        1966 => "Angleterre",
        1970 => "Brésil",
        1974 => "Allemagne",
        1978 => "Argentine",
        1982 => "Italie",
        1986 => "Argentine",
        1990 => "Allemagne",
        1994 => "Brésil",
        1998 => "France",
        2002 => "Brésil",
        2006 => "Italie",
        2010 => "Espagne",
        2014 => "Allemagne",
        2018 => "France",
        2022 => "Argentine"
      );
      $vainqueurs = array();

      foreach ($Palmares as $val){
        if(!in_array($val,$vainqueurs)){
          $vainqueurs[] = $val;
        }
      };

      echo "<pre>";
      print_r($Palmares);
      echo "</pre>";
      echo "<pre>";
      print_r($vainqueurs);
      echo "</pre>";
    ?>

  </body>
</html>