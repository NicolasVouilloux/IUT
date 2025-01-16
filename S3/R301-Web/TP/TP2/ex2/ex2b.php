<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>TP2 - ex2b</title>
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
    </style>    
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

      echo"<table>";
      echo"<tr>";
      echo"<th>année n</th>";
      echo"<th>capital en début d'année</th>";
      echo"</tr>";
      foreach($capital as $key => $value){
        echo"<tr>";
        echo"<td>$key</td>";
        echo"<td>$value</td>";
        echo"</tr>";
      }
    ?>
  </body>
</html>
