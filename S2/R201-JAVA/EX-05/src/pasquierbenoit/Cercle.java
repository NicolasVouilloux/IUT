package pasquierbenoit;

public class Cercle extends FormeGeometrique {

	private double rayon;

	public double getRayon() {return rayon;}
	public void setRayon(double rayon) {this.rayon = rayon;}

	public Cercle(double x, double y, double rayon) {
		super(x,y);
		setRayon(rayon);
	}


	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double surface() {
		// TODO Auto-generated method stub
		return 0;
	}

}