package JODES.modeles;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

import JODES.vues.AjouterSession;

/**
 * @author Visual Paradigm
 */
public class Session extends Entite {

	public static final String FINALE = "finale";
	public static final String DEMIE = "demie finale";
	public static final String QUART = "quart de finale";
	public static final String HUITIEME = "huitième de finale";
	public static final String QUALIF = "qualifications";
    public static final String AMICAL = "amical";
    protected String statut;
	protected Session session;
	protected Saison saSaison;
	protected LocalTime horaireDebut;
	protected LocalTime horaireFin;
	protected LocalDate date;
	protected Lieu sonLieu;
	protected Discipline saDiscipline;

	// ----------- Constructors -----------

	public Session(String nom, String statut, Session session, Saison saSaison, LocalTime horaireDebut,
			LocalTime horaireFin, LocalDate date, Lieu sonLieu, Discipline saDiscipline) {
		super(nom);
		this.setStatut(statut);
		this.session = session;
		this.saSaison = saSaison;
		this.horaireDebut = horaireDebut;
		this.horaireFin = horaireFin;
		this.date = date;
		this.sonLieu = sonLieu;
		this.saDiscipline = saDiscipline;
	}

	// ----------- Getters & setters -----------
	
	public String getStatut() {
		return statut;
	}

	/**
	 * @author Ash Merienne
	 */
    public void setStatut(String statut) {
        if (statut == QUALIF || statut == HUITIEME || statut == QUART
            || statut == DEMIE || statut == FINALE)
            this.statut = statut;
        else this.statut = AMICAL;
    }

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Saison getSaSaison() {
		return saSaison;
	}

	public void setSaSaison(Saison saSaison) {
		this.saSaison = saSaison;
	}

	public LocalTime getHoraireDebut() {
		return horaireDebut;
	}

	public void setHoraireDebut(LocalTime horaireDebut) {
		this.horaireDebut = horaireDebut;
	}

	public LocalTime getHoraireFin() {
		return horaireFin;
	}

	public void setHoraireFin(LocalTime horaireFin) {
		this.horaireFin = horaireFin;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Lieu getSonLieu() {
		return sonLieu;
	}

	public void setSonLieu(Lieu sonLieu) {
		this.sonLieu = sonLieu;
	}

	public Discipline getSaDiscipline() {
		return saDiscipline;
	}

	public void setSaDiscipline(Discipline saDiscipline) {
		this.saDiscipline = saDiscipline;
	}
	
	// ----------- Methods -----------

	public int getLongueurEnDemiHeure() {
		int minutesDeb, minutesFin;
		minutesDeb = horaireDebut.getHour()*60 + horaireDebut.getMinute();
		minutesFin = horaireFin.getHour()*60 + horaireFin.getMinute();
		return (minutesFin - minutesDeb)/30;
	}

	@Override
	public void menuModification() {
		new AjouterSession();
	}

	

}