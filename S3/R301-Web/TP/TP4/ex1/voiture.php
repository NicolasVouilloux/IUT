<?php
class voiture{
    //attributs
    private string $marque;
    private string $couleur;
    private string $immatriculation;

    public function get($attribut){return $this->$attribut;}
    public function set($attribut,$valeur){$this->$attribut = $valeur;}

    public function __construct(string $m,string $c,string $i){
        $this->marque = $m;
        $this->couleur = $c;
        $this->immatriculation = $i;
    }
    public function afficher(){
        $txt = "voiture $this->immatriculation, de marque $this->marque, de couleur $this->couleur";
        echo "<p>$txt</p>";
    }
}
?>