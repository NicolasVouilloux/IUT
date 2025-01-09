<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <title>CC2-EX2-notes</title>
  </head>
  <body>
    <form action="calcul_moyenne.php" method="post">
      <?php
        if(isset($_GET["nb"]))
          $nbNote= $_GET["nb"];
        if((isset($_GET["pondere"])) && ($_GET["pondere"]=="True")){
          for($i = 0;$i<$nbNote;$i++){
            echo"<div>";
            echo"<label for =" . mat$i . "> Matiere $i</label>";
            echo"<input type=" . text . " name=" . mat$i . " placeholder=" . Nom de la matiere . ">";
            echo"<br>";
            echo"<label for =". note$i ."> Matiere $i</label>";
            echo"<input type=" . text . " name=" . note$i . " placeholder=" . Note de la matiere . ">";
            echo"<br>";
            echo"<label for =". coef$i ."> Coef $i</label>";
            echo"<input type=" . text . " name=" . Coef$i . " placeholder=" . Coef de la matiere . ">";
            echo"</div>";
          } 
        } 
      ?>
      <button type="submit">enregistrer</button>
    </form>
  </body>
</html>