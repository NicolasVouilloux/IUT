<?php
require_once("modele/modele.php");
require_once("modele/utilisateur.php");
require_once("modele/voiture.php");

class Controleur{
    //La méthode de récupération et d'affichage de tous les utilisateurs
    public static function lireObjet(){
        // initialisation des vals
        $objetsTitre = static::$objet;
        $table = ucfirst($objetsTitre);
        $cle = $table::getCle();
        $objet = $table::getObjet();
        
        // titre de la page
        $titre = "les $objetsTitre";
        
        if (isset($_GET[$cle])){
            $i = $_GET[$cle];
            $tab = $table::getObjetById($i);
        }else {
            $tab = $table::getAll();
        }

        // insertion du debut du html
        include("vue/debut.php");
        // insertion du menu 
        include("vue/menu.html");
        
        if(!$tab){ 
            include("vue/erreur.php");}
        else if (sizeof($tab)==1){ 
            include("vue/unObjet.php");}
        else{ 
            include("vue/lesObjets.php");}   
        // insertion de la fin 
        include("vue/fin.html");
    }
}
?>