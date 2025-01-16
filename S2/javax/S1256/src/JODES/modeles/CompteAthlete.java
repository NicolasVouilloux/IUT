package JODES.modeles;

/**
 * @author Visual Paradigm
 */
public class CompteAthlete extends Utilisateur {
	
	protected Athlete sonAthlete;
	
	// ----------- Constructors -----------
	
	public CompteAthlete(String login, String password, String prenom, String nom, Athlete sonAthlete) {
		super(login, password, prenom, nom);
		this.sonAthlete = sonAthlete;
	}
	
	// ----------- Getters & setters -----------
	
	public Athlete getSonAthlete() {
		return sonAthlete;
	}

	public void setSonAthlete(Athlete sonAthlete) {
		this.sonAthlete = sonAthlete;
	}
	
	// ----------- Methods -----------
	
	protected void afficherPlanning() {
		// TODO - implement CompteAthlète.afficherPlanning
		throw new UnsupportedOperationException();
	}
}