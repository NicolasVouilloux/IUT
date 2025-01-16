package JODES.modeles;

/**
 * @author Visual Paradigm
 */
public class Lieu extends Entite {

	protected Ville saVille;
	protected int codePostal;
	
	// ----------- Constructors -----------
	
	public Lieu(String nom, int codePostal, Ville saVille) {
		super(nom);
		this.codePostal = codePostal;
		this.saVille = saVille;
	}
	
	public Lieu(String nom, Ville saVille) {
		this(nom, saVille.getCodePostal(), saVille);
	}
	
	// ----------- Getters & setters -----------
	
	public Ville getSaVille() {
		return saVille;
	}

	public void setSaVille(Ville saVille) {
		this.saVille = saVille;
	}
	
	// ----------- Methods -----------

	@Override
	public void menuModification() {
		return;
	}

	
}