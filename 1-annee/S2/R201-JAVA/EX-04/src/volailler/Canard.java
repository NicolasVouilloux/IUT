package volailler;

public class Canard extends Volailles {

	protected static double prixKg = 1.5f;
	
	
	public Canard (double poids, int identifiant) {
		super(poids,identifiant);
	}
	//getters and setters

	public double getPrixKg() {return prixKg;}
	public static void setPrixKg(double prixKg) {Canard.prixKg = prixKg;}
	@Override
	public double prixDeVente() {
		return poids*prixKg;
	}
}