package volailler;


public abstract class Volailles {

	Elevage sonElevage;
	protected double poids;
	protected int identifiant;
	protected boolean beteAAbatre;
	
	// Constructeur de Volailles------------------------------------------------------------ 
	public Volailles(double poids, int identifiant) {
		setPoids(poids);
		setIdentifiant(identifiant);
	}

	// Getters et Setters de Volailles -----------------------------------------------------
	public boolean isBeteAAbatre() {return beteAAbatre;}
	public void setBeteAAbatre(boolean beteAAbatre) {this.beteAAbatre = beteAAbatre;}
	public Elevage getSonElevage() {return sonElevage;}
	public void setSonElevage(Elevage sonElevage) {this.sonElevage = sonElevage;}
	public double getPoids() {return poids;}
	public void setPoids(double poids) {this.poids = poids;}
	public int getIdentifiant() {return identifiant;}
	public void setIdentifiant(int identifiant) {this.identifiant = identifiant;}
	
	// to string et prix de vente -----------------------------------------------------------
	public abstract double prixDeVente();
	public String toString() {
		return 	"Identifiant = " + identifiant+
				", poids = " + poids+
				", prix = "+ prixDeVente();
	}
}