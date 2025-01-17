<?php
    foreach ($tab_v as $v) {
        echo "<p>immatriculation ".$v->getImmatriculation()."</p><a href='routeur.php?controleur=controleurVoiture&action=lireVoiture&immatriculation=".$v->getImmatriculation()."' class='button'>details</a>";
    }
?>
