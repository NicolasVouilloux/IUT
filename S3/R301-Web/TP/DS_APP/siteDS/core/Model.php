<?php
class Model {
    protected static $cle;
    protected static $objet;
    
    public function get($attribut){
        return $this->$attribut;    
    }
    
    public function set($attribut,$valeur) {
        $this->$attribut = $valeur;
    }

    public function __constructor($donnees){
        if (!is_null($donnees)){
            foreach($donnees as $attribut => $valeur)
                $this->set($attribut,$valeur);
        }
    }
    public static function getAll() {
        $table = static::$objet;
        $requete = "SELECT * FROM $table;";

        $resultat = connexion::pdo()->query($requete);

        $resultat->setFetchmode(PDO::FETCH_CLASS,ucfirst(strtolower($table)));
        $tableau = $resultat->fetchAll();
        return $tableau;
    }

    public static function getCle() { return static::$cle; }
    public static function getObjet() { return static::$objet; }

}
?>