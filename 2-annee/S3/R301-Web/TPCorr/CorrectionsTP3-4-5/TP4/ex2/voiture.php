<?php
class Voiture {

	private $immatriculation;
	private $marque;
	private $couleur;

	// getter
	public function getImmatriculation() {return $this->immatriculation;}
	public function getMarque() {return $this->marque;}
	public function getCouleur() {return $this->couleur;}

	// setter
	public function setImmatriculation($i) {$this->immatriculation = $i;}
	public function setMarque($m) {$this->marque = $m;}
	public function setCouleur($c) {$this->couleur = $c;}

	// un constructeur
	public function __construct($i, $m, $c)  {
		$this->immatriculation = $i;
		$this->marque = $m;
		$this->couleur = $c;
	}

	// une methode d'affichage.
	public function afficher() {
		echo "<p>voiture $this->immatriculation, de marque $this->marque, de couleur $this->couleur</p>";
	}
}
?>
