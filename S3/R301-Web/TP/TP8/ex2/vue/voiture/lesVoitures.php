<?php
    foreach ($tab_v as $v) {
        echo "<p>immatriculation ".$v->get('immatriculation')."</p><a href='routeur.php?controleur=controleurVoiture&action=lireVoiture&immatriculation=".$v->get('immatriculation')."' class='button'>details</a>";
    }
?>
