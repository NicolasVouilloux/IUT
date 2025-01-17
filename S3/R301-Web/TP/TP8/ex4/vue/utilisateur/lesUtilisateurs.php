<?php
    foreach ($tab_u as $u) {
        echo "<p>login ".$u->get('login')."</p><a href='routeur.php?controleur=controleurUtilisateur&action=lireUtilisateur&login=".$u->get('login')."' class='button'>details</a>";
    }
?>