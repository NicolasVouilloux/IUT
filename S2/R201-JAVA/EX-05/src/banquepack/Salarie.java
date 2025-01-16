package banquepack;

public abstract class Salarie {

	protected double salaire;
	protected String nom;

	public abstract void verserSalaire();

	public double getSalaire() {return salaire;}
	public void setSalaire(double salaire) {this.salaire = salaire;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}

	public Salarie(double salaire,String nom) {
		setSalaire(salaire);
		setNom(nom);
	}
	
}