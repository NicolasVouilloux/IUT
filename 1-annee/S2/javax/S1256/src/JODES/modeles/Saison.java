package JODES.modeles;
import java.time.LocalDate;

/**
 * @author Visual Paradigm
 */
public class Saison extends Entite {

	protected LocalDate dateDebut;
	protected LocalDate dateFin;

	// ----------- Constructors -----------
	
	public Saison(String nom, LocalDate dateDebut, LocalDate dateFin) {
		super(nom);
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	// ----------- Getters & setters -----------
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public void menuModification() {
		return;
	}

	
	
	// ----------- Methods -----------
}