package JODES.modeles;

/**
 * @author Visual Paradigm
 */
public class Medaille extends Entite {

	private static final long serialVersionUID = 1L;
	
	protected Athlete sonAthlete;
	protected String valeur;
	public static final String OR = "Or";
	public static final String ARGENT = "Argent";
	public static final String BRONZE = "Bronze";
	public static final String PARTICIPATION = "Participation";
	
	// ----------- Constructors -----------
	
	public Medaille(String nom, String valeur, Athlete sonAthlete) {
		super(nom);
		this.valeur = valeur;
		this.sonAthlete = sonAthlete;
	}
	
	// ----------- Getters & setters -----------
	
	public Athlete getSonAthlete() {
		return sonAthlete;
	}

	public void setSonAthlete(Athlete sonAthlete) {
		this.sonAthlete = sonAthlete;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	// ----------- Methods -----------

	@Override
	public void menuModification() {
		return;
	}

	
}