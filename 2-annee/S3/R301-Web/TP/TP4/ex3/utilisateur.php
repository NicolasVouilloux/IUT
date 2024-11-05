
<?php
class utilisateur{
    //attributs
    private string $login;
    private string $mdp;
    private string $nom;
    private string $prenom;
    private string $email;

    public function get($attribut){return $this->$attribut;}
    public function set($attribut,$valeur){$this->$attribut = $valeur;}

    public function __construct(string $login,string $mdp,string $nom,string $prenom,string $email){
        $this->login = $login;
        $this->mdp = $mdp;
        $this->nom = $nom;
        $this->prenom = $prenom;
        $this->email = $email;
    }
    public function afficher(){
        $txt = "utilisateur $this->login($this->prenom $this->nom), email = $this->email";
        echo "<p>$txt</p>";
    }
}
?>