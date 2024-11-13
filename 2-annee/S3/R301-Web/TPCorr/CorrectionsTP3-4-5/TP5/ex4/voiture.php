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

	// constructeur polyvalent d'un objet Voiture
	public function __construct($i = NULL, $m = NULL, $c = NULL) {
		if (!is_null($i)) {
			$this->immatriculation = $i;
			$this->marque = $m;
			$this->couleur = $c;
		}
	}

	// une methode d'affichage.
	public function afficher() {
		echo "<p>voiture $this->immatriculation, de marque $this->marque, de couleur $this->couleur</p>";
	}

	// méthode static qui retourne les voitures en un tableau d'objets
	public static function getAllVoitures() {
		// écriture de la requête
		$requete = "SELECT * FROM voiture;";
    // envoi de la requête et stockage de la réponse
		$resultat = connexion::pdo()->query($requete);
    // traitement de la réponse
    $resultat->setFetchmode(PDO::FETCH_CLASS,'Voiture');
    $tableau = $resultat->fetchAll();
		return $tableau;
	}
}
?>
