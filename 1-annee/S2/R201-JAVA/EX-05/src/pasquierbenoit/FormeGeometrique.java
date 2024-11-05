package pasquierbenoit;

public abstract class FormeGeometrique {

	private double x;
	private double y;

	public double getX() {return x;}
	public void setX(double x) {this.x = x;}
	public double getY() {return y;}
	public void setY(double y) {this.y = y;}
	
	public FormeGeometrique(double x, double y) {
		setX(x);
		setY(y);
	}

	public void afficher() {
		String s = this.getClass().getName();
		s += ", x = " + getX();
		s += ", y = " + getY();
		s += ", Surface = " + surface();
		s += ", Perimetre = " + perimetre();
		System.out.println(s);
	}

	public void deplacer(double y,double x) {
		setX(x);
		setY(y);
	}


	public abstract double perimetre();

	public abstract double surface();

}