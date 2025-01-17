<?php
class Utilisateur extends Modele{

	protected $login;
	protected $mdp;
	protected $nom;
	protected $prenom;
	protected $email;

	

	// constructeur polyvalent d'un objet Utilisateur
	public function __construct($l = NULL, $m = NULL, $n = NULL, $p = NULL, $e = NULL) {
		if (!is_null($l)) {
			$this->login = $l;
			$this->mdp = $m;
			$this->nom = $n;
			$this->prenom = $p;
			$this->email = $e;
		}
	}

	// une methode d'affichage.
	public function afficher() {
		echo "<p>utilisateur $this->login ($this->prenom $this->nom), email = $this->email</p>";
	}
	
	// méthode static qui retourne les voitures en un tableau d'objets
	public static function getAllUtilisateurs() {
		// écriture de la requête
		$requete = "SELECT * FROM utilisateur;";
    // envoi de la requête et stockage de la réponse
		$resultat = connexion::pdo()->query($requete);
    // traitement de la réponse
		$resultat->setFetchmode(PDO::FETCH_CLASS,'Utilisateur');
		$tableau = $resultat->fetchAll();
		return $tableau;
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
