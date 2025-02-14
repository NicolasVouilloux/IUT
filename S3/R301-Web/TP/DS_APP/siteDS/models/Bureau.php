<?php
//    CREATE TABLE bureaux (
//        id INT AUTO_INCREMENT PRIMARY KEY,
//        nom VARCHAR(255),
//        description TEXT,
//        capacite INT,
//        mot_clé VARCHAR(255) – Exemples : "wifi,calme,lumineux"
//        );

class Bureau extends Model {
    
    protected $id;
    protected $nom;
    protected $description;
    protected $capacite;
    protected $mot_cle;
    protected static $table = 'bureaux';

    public static function rechercher($capa,$motcle) {
        if (is_null($motcle)){
            $requete = "SELECT * FROM $table WHERE capacite = $capa;";
        }else if (is_null($capa)){
            $requete = "SELECT * FROM $table WHERE mot_cle = $motcle;";
        }else {
            $requete = "SELECT * FROM $table WHERE capacite = $capa AND mot_cle = $motcle;";
        }
        $resultat = connexion::pdo()->query($requete);
        $resultat->setFetchmode(PDO::FETCH_CLASS,$table);
        $tableau = $resultat->fetchAll();
        return $tableau;    
    }
}
?>
