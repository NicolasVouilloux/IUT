<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <title>TP4 - ex3</title>
    </head>
    <body>
        <h2>tests de construction d'objets Utilisateur
        </h2>
        <?php
            require_once("utilisateur.php");
            if(isset($_GET["login"]))
                $login= $_GET["login"];
            if(isset($_GET["nom"]))
                $nom= $_GET["nom"];
            if(isset($_GET["prenom"]))
                $prenom=$_GET["prenom"];
            if(isset($_GET["mdp"]))
                $mdp= $_GET["mdp"];
            if(isset($_GET["email"]))
                $email= $_GET["email"];
            (new utilisateur($login,$mdp,$nom,$prenom,$email))->afficher();
        ?>
        <a href="formulaireUtilisateur.html">retour au formulaire</a>
    </body>
</html>