<?php
class Utilisateur {

	private $login;
	private $mdp;
	private $nom;
	private $prenom;
	private $email;

	// getter
	public function getLogin() {return $this->login;}
	public function getMdp() {return $this->mdp;}
	public function getNom() {return $this->nom;}
	public function getPrenom() {return $this->prenom;}
	public function getEmail() {return $this->email;}

	// setter
	public function setLogin($l) {$this->login = $l;}
	public function setMdp($m) {$this->mdp = $m;}
	public function setNom($n) {$this->nom = $n;}
	public function setPrenom($p) {$this->prenom = $p;}
	public function setEmail($e) {$this->email = $e;}

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
}
?>
