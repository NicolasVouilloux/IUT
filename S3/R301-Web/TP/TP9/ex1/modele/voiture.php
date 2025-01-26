<?php
class Voiture extends Modele{

	protected $immatriculation;
	protected $marque;
	protected $couleur;
	protected static $objet = "voiture";
	protected static $cle = 'immatriculation';
	// une methode d'affichage.
	public function afficher() {
		echo "<p>voiture $this->immatriculation, de marque $this->marque, de couleur $this->couleur</p>";
	}
}
?>
