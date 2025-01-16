package JODES.modeles;
import java.util.*;

import JODES.vues.AjouterEquipe;

/**
 * @author Visual Paradigm
 */
public class Equipe extends Entite {

	protected ArrayList<Athlete> sesAthletes;
	protected Pays sonPays;
	
	// ----------- Constructors -----------
	
	public Equipe(String nom, Pays sonPays, ArrayList<Athlete> sesAthletes) {
		super(nom);
		this.sesAthletes = sesAthletes;
		this.sonPays = sonPays;
	}
	
	public Equipe(String nom, Pays sonPays) {
		this(nom, sonPays, new ArrayList<Athlete>());
	}
	
	// ----------- Getters & setters -----------
	
	public ArrayList<Athlete> getSesAthletes() {
		return sesAthletes;
	}

	public void setSesAthletes(ArrayList<Athlete> sesAthletes) {
		this.sesAthletes = sesAthletes;
	}

	public Pays getSonPays() {
		return sonPays;
	}

	public void setSonPays(Pays sonPays) {
		this.sonPays = sonPays;
	}
	
	// ----------- Methods -----------

	@Override
	public void menuModification() {
		new AjouterEquipe();
	}

}