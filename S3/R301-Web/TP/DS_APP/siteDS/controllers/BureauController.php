<?php
class BureauController {
    public static function lister() {
    $bureaux = Bureau::findAll();
    require 'views/bureaux.php';
    }
}
?>