<?php
class voiture{
    //attributs
    private string $marque;
    private string $couleur;
    private string $immatriculation;

    public function get($attribut){return $this->$attribut;}
    public function set($attribut,$valeur){$this->$attribut = $valeur;}

    
    public static function getAllVoitures(){
        $requete = "SELECT * FROM voiture;";
        $resultat = connexion::pdo()->query($requete);
        $resultat->setFetchmode(PDO::FETCH_CLASS,"voiture");
        $monGarage = $resultat->fetchAll();
        return $monGarage;
    }
    public function __construct(string $m = NULL,string $c = NULL,string $i = NULL){
        if (!is_null($i)){
            $this->marque = $m;
            $this->couleur = $c;
            $this->immatriculation = $i;
        }
    }
    public function afficher(){
        $txt = "voiture $this->immatriculation, de marque $this->marque, de couleur $this->couleur";
        echo "<p>$txt</p>";
    }
}
?>