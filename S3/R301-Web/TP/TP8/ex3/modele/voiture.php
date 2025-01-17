<?php
class Voiture extends Modele{

	protected $immatriculation;
	protected $marque;
	protected $couleur;
	protected static $objet = "voiture";


	// une methode d'affichage.
	public function afficher() {
		echo "<p>voiture $this->immatriculation, de marque $this->marque, de couleur $this->couleur</p>";
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
