package banquepack;

public class Employe extends Salarie {

	public Employe(double salaire, String nom) {
		super(salaire, nom);
	}

	public void verserSalaire() {
		System.out.print("Versement de salaire sur compte externe : "+salaire);
	}

}