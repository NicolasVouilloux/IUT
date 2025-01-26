<?php
class Utilisateur extends Modele{

	protected $login;
	protected $mdp;
	protected $nom;
	protected $prenom;
	protected $email;
	protected static $objet = "utilisateur";
	protected static $cle = 'login'; 

	// une methode d'affichage.
	public function afficher() {
		echo "<p>utilisateur $this->login ($this->prenom $this->nom), email = $this->email</p>";
	}

	public static function getUtilisateurByLogin($i){
		$requeteUtilisateurLogin = "SELECT * FROM utilisateur WHERE login = :i;";
		$requetePreparee = Connexion::pdo()->prepare($requeteUtilisateurLogin);
		
		$value = array();
		$value["i"] = $i;
		try {
			$requetePreparee->execute($value);
		} catch(PDOException $e){
			echo $e->getMessage();
		}
			$requetePreparee->setFetchmode(PDO::FETCH_CLASS,'utilisateur');
			$utilisateur = $requetePreparee->fetchAll();
			return $utilisateur;
	}
}
?>
