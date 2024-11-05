package volailler;

public class Poulet extends Volailles {

	protected static double prixKg= 1;
	
	
	public Poulet (double poids, int identifiant) {
		super(poids, identifiant);
	}
	//getters and setters
	
	public double getPrixKg() {return prixKg;}
	public static void setPrixKg(double prixKg) {Poulet.prixKg = prixKg;}
	@Override
	public double prixDeVente() {
		return poids*prixKg;
	}
}