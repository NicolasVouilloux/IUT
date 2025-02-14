<?php
	require_once("config/connexion.php");
	Connexion::connect();


    require_once 'controllers/BureauController.php';
    require_once 'controllers/ReservationController.php';
    
    //initialisation des variables par defaut
    $controller = "BureauController";
    $action = "lister";

    // initialisation du tableau de verification des controleurs
    $tableauControllers = ["BureauController","ReservationController"];
    $actionParDefaut = array(
        "BureauController" => "lister",
        "ReservationController" => "reserver"
    );

    if(isset($_GET["controller"])){
        if(in_array($_GET["controller"],$tableauControllers))
            $controller= $_GET["controller"];
    }
    
    require_once("controllers/$controller.php");
    
    //creation des variables de nom de fonction par classe
    $classFunctions = get_class_methods($controller);
    
    if(isset($_GET["action"])){
        if(in_array($_GET["action"],$classFunctions))
            $action= $_GET["action"];
        else
            $action= $classFunctions[0];
    }

    $controller::$action();
?>