package banquepack;

public class ClientInterne extends Salarie {

	
	private Compte compte;
	
	public Compte getCompte() {return compte;}
	public void setCompte(Compte compte) {this.compte = compte;}
	

	public ClientInterne(double salaire, String nom,Compte compte) {
		super(salaire, nom);
		setCompte(compte);
	}

	
	public void verserSalaire() {
		compte.crediter(salaire);
	}

}