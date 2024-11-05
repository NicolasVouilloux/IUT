<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>TP2 - ex3c</title>
    <style>
        th, td {
        min-width:12em;
        padding:3px 0px;
      }
      table, th, td {
        text-align: center;
        border: solid 1px black;
        border-collapse: collapse;
      }
      th {
        background-color: darkgrey;
        color:white;
      }
      table {
        margin:0px auto;
      }
      .rouge {
        background-color: red;
        font-weight: bold;
      }
    </style>    
  </head>
  <body>
    <h2>tableau des capitaux successifs</h2>
    <?php
    $seuil= 13000;
    $taux = 4;
    $capitalInitial = 10000;
    if(isset($_GET["seuil"]))
      $seuil= $_GET["seuil"];
    if(isset($_GET["taux"]))
      $taux= $_GET["taux"];
    if(isset($_GET["capital_initial"]))
      $capitalInitial= $_GET["capital_initial"]; 
    $capital = array(
      $capitalInitial
    );
    // increasing the capitale over the year
    $i = 0;
    while ($capital[($i)]<$seuil){
        $i++;
        $capital[$i] = floor((($capital[$i-1])+(($capital[$i-1])*($taux/100))));
    };
    echo"<ul>";
    echo"<il>taux = $taux</il>";
    echo"<il>seuil = $seuil</il>";
    echo"<il>capital initial = $capitalInitial</il>";
    echo"</ul>";
    echo"<table>";
    echo"<tr>";
    echo"<th>année n</th>";
    echo"<th>capital en début d'année</th>";
    echo"</tr>";
    foreach($capital as $key => $value){
        if ($key != array_key_last($capital)){
            echo"<tr>";
            echo"<td>$key</td>";
            echo"<td>$value</td>";
            echo"</tr>";
        }
         else{
            echo"<tr>";
            echo"<td>$key</td>";
            echo"<td class=rouge>$value</td>";
            echo"</tr>";
        }

    };
    ?>
    <p><a href="formulaire.html">Formulaire web</a></p>
  </body>
</html>