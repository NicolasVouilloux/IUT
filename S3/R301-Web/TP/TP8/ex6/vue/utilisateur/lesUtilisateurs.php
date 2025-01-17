<?php
    foreach ($tab_u as $u) {
        echo "<p>login ".$u->getLogin()."</p><a href='routeur.php?controleur=controleurUtilisateur&action=lireUtilisateur&login=".$u->getLogin()."' class='button'>details</a>";

    }
?>