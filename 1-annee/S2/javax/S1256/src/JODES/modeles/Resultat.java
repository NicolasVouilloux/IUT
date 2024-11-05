package JODES.modeles;
import java.time.Duration;
import java.util.*;

/**
 * @author Visual Paradigm
 */
public class Resultat extends Entite {

	ArrayList<Session> sesResultats;
	protected float score;
	protected Duration temps;

	// ----------- Constructors -----------
	
	public Resultat(String nom, ArrayList<Session> sesResultats, float score, Duration temps) {
		super(nom);
		this.sesResultats = sesResultats;
		this.score = score;
		this.temps = temps;
	}
	
	// ----------- Getters & setters -----------
	
	public ArrayList<Session> getSesResultats() {
		return sesResultats;
	}

	public void setSesResultats(ArrayList<Session> sesResultats) {
		this.sesResultats = sesResultats;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public Duration getTemps() {
		return temps;
	}

	public void setTemps(Duration temps) {
		this.temps = temps;
	}
	
	// ----------- Methods -----------

	@Override
	public void menuModification() {
		return;
	}

	
	
}