<?php
class Utilisateur {

	private $login;
	private $mdp;
	private $nom;
	private $prenom;
	private $email;

	// un getter
	public function getLogin() {return $this->login;}
	public function getMdp() {return $this->mdp;}
	public function getNom() {return $this->nom;}
	public function getPrenom() {return $this->prenom;}
	public function getEmail() {return $this->email;}

	// un setter
	public function setLogin($l) {$this->login = $l;}
	public function setMdp($m) {$this->mdp = $m;}
	public function setNom($n) {$this->nom = $n;}
	public function setPrenom($p) {$this->prenom = $p;}
	public function setEmail($e) {$this->email = $e;}

	// un constructeur
	public function __construct($l, $m, $n, $p, $e)  {
		$this->login = $l;
		$this->mdp = $m;
		$this->nom = $n;
		$this->prenom = $p;
		$this->email = $e;
	}

	// une methode d'affichage.
	public function afficher() {
		echo "<p>utilisateur $this->login ($this->prenom $this->nom), email = $this->email</p>";
	}
}
?>
