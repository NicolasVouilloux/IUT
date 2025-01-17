<?php
class Vue{
    foreach ($tab as $i) {
        echo "<p>".$cle." ".$i->get($cle)."</p><a href='routeur.php?controleur=controleur".$objet."&action=lire".$objet."&".$cle."=".$i->get($cle)."' class='button'>details</a>";
    }
}
?>