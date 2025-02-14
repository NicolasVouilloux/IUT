<?php

//CREATE TABLE reservations (
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    id_bureau INT,
//    id_utilisateur INT,
//    date_reservation DATE,
//    heure_debut TIME,
//    heure_fin TIME,
//    FOREIGN KEY (id_bureau) REFERENCES bureaux(id),
//    FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id)
//    );



class ReservationController {
    protected $id_bureau;
    protected $id_utilisateur;
    protected $date;
    protected $heure_debut;
    protected $heure_fin;

    public static function reserver() {
        require_once("core/Model.php");
        if(isset($_GET["id_bureau"]))
            $id_bureau = $_GET["id_bureau"];
        if(isset($_GET["id_utilisateur"]))
            $id_utilisateur= $_GET["id_utilisateur"];
        if(isset($_GET["date"]))
            $date=$_GET["date"];
        if(isset($_GET["heure_debut"]))
            $heure_debut= $_GET["heure_debut"];
        if(isset($_GET["heure_fin"]))
            $heure_fin= $_GET["heure_fin"];
        new reservations($id_bureau,$id_utilisateur,$date,$heure_debut,$heure_fin);
        require 'index.php?action=confirmation';
    }
}
?>