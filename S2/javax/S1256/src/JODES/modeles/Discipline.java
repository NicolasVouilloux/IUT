package JODES.modeles;

/**
 * @author Visual Paradigm
 */
public class Discipline extends Entite {

	protected String description;
	
	// ----------- Constructors -----------
	
	public Discipline(String nom, String description) {
		super(nom);
		this.description = description;
	}
	
	public Discipline(String nom) {
		this(nom, "");
	}
	
	// ----------- Getters & setters -----------
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// ----------- Methods -----------

	@Override
	public void menuModification() {
		return;
	}
	
}