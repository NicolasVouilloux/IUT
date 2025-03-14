<?php
class Voiture extends Modele{

	protected $immatriculation;
	protected $marque;
	protected $couleur;

	

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

	public static function getVoitureByImmat($i){
		$requeteVoitureImmat = "SELECT * FROM voiture WHERE immatriculation = :i;";
		$requetePreparee = Connexion::pdo()->prepare($requeteVoitureImmat);
		
		$value = array();
		$value["i"] = $i;
		try {
			$requetePreparee->execute($value);
		} catch(PDOException $e){
			echo $e->getMessage();
		}
			$requetePreparee->setFetchmode(PDO::FETCH_CLASS,'voiture');
			$voiture = $requetePreparee->fetchAll();
			return $voiture;
	}

}
?>
