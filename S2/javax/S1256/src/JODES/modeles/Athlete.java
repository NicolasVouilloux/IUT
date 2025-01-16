package JODES.modeles;
import java.util.*;

/**
 * @author Visual Paradigm
 */
public class Athlete extends Entite {

	protected ArrayList<Medaille> sesMedailles;
	protected ArrayList<Equipe> sesEquipes;
	protected ArrayList<Discipline> sesDisciplines;
	protected String biographie;
	protected String prenom;
	protected String nom;
	protected CompteAthlete sonCompte;
	protected Pays sonPays;
	
	// ----------- Constructors -----------
	/**
	 * @author Ash Merienne
	 */
	public Athlete (String prenom, String nom, Pays sonPays, String biographie,
			ArrayList<Medaille> sesMedailles, ArrayList<Equipe> sesEquipes,
			ArrayList<Discipline> sesDisciplines) {
		super(prenom + " " + nom);
		this.nom = nom;
		this.sonPays = sonPays;
		this.biographie = biographie;
		this.sesMedailles = sesMedailles;
		this.sesDisciplines = sesDisciplines;
		this.sesEquipes = sesEquipes;
		this.prenom = prenom;
	}
	
	public Athlete (String prenom, String nom, Pays sonPays, String biographie) {
		this(prenom, nom, sonPays, biographie, new ArrayList<Medaille>(),
				new ArrayList<Equipe>(), new ArrayList<Discipline>());
	}
	
	public Athlete (String prenom, String nom, Pays sonPays) {
		this(prenom, nom, sonPays, "", new ArrayList<Medaille>(),
				new ArrayList<Equipe>(), new ArrayList<Discipline>());
	}

	
	// ----------- Getters & setters -----------
	
	public ArrayList<Medaille> getSesMedailles() {
		return sesMedailles;
	}
	

	public void setSesMedailles(ArrayList<Medaille> sesMedailles) {
		this.sesMedailles = sesMedailles;
	}
	

	public ArrayList<Equipe> getSesEquipes() {
		return sesEquipes;
	}
	

	public void setSesEquipes(ArrayList<Equipe> sesEquipes) {
		this.sesEquipes = sesEquipes;
	}
	

	public ArrayList<Discipline> getSesDisciplines() {
		return sesDisciplines;
	}
	

	public void setSesDisciplines(ArrayList<Discipline> sesDisciplines) {
		this.sesDisciplines = sesDisciplines;
	}
	
	public String getBiographie() {
		return biographie;
	}
	

	public void setBiographie(String biographie) {
		this.biographie = biographie;
	}
	

	public String getPrenom() {
		return prenom;
	}
	

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	

	public String getNom() {
		return nom;
	}
	

	public void setNom(String nom) {this.nom = nom;
	}
	

	public CompteAthlete getSonCompte() {
		return sonCompte;
	}
	

	public void setSonCompte(CompteAthlete sonCompte) {
		this.sonCompte = sonCompte;
	}
	

	public Pays getSonPays() {
		return sonPays;
	}
	

	public void setSonPays(Pays sonPays) {
		this.sonPays = sonPays;
	}
	
	// ----------- Methods -----------
	
	// Ash M
	public void addMedaille(Medaille medaille) {
		this.sesMedailles.add(medaille);
	}
	
	@Override
	public String toString() {
		return "Athlete [sesMedailles=" + sesMedailles + ", sesEquipes=" + sesEquipes + ", sesDisciplines="
				+ sesDisciplines + ", biographie=" + biographie + ", prenom=" + prenom + ", nom=" + nom + ", sonCompte="
				+ sonCompte + ", sonPays=" + sonPays + "]";
	}

	/**
	 * @author Ash Merienne
	 */
	public void addEquipe(Equipe equipe) {
		this.sesEquipes.add(equipe);
	}
	
	/**
	 * @author Ash Merienne
	 */
	public void addDiscipline(Discipline discipline) {
		this.sesDisciplines.add(discipline);
	}

	@Override
	public void menuModification() {
		return;
	}

	
	
}