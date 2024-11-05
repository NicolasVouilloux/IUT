package banquepack;

//QUESTION 5 : Définir aussi une classe Client. 
//Ajouter dans la classe CompteCourant un attribut 
//de nom proprietaire de type Client. 
//Pour simplifier, on ne représentera pas en Java dans la classe Client de lien vers tous les comptes de ce client. 

public class Client {
	private String nom ;
	
	public Client(String nom) {
		this.nom = nom;
	}

	public String toString () {
		return "Client : " + nom ;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// QUESTION 13
	public void afficherInformations() {
		System.out.println ("Client : "+nom);
	} 	
}