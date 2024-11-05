package JODES.modeles;

/**
 * @author Visual Paradigm
 */
public class Ville extends Entite {

	protected int codePostal;
	
	// ----------- Constructors -----------
	
	public Ville(String nom, int codePostal) {
		super(nom);
		this.codePostal = codePostal;
	}
	
	// ----------- Getters & setters -----------
	
	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	
	// ----------- Methods -----------
	
	@Override
	public void menuModification() {
		return;
	}

	

}