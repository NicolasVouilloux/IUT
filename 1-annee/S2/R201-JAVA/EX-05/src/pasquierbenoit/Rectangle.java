package pasquierbenoit;

public class Rectangle extends FormeGeometrique {

	private double longueur;
	private double largeur;
	
	public double getLongueur() {return longueur;}
	public void setLongueur(double longueur) {this.longueur = longueur;}
	public double getLargeur() {return largeur;}
	public void setLargeur(double largeur) {this.largeur = largeur;}
	
	
	
	public Rectangle(double x, double y, double largeur, double longueur) {
		super(x,y);
		setLongueur(longueur);
		setLargeur(largeur);
	}
	
	public double perimetre() {
		double perimetre= 0;
		perimetre += largeur*2;
		perimetre += longueur*2;
		return perimetre;
	}
	
	public double surface() {
		return longueur*largeur;
	}
}