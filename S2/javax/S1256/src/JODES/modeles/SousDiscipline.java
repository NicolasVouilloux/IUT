package JODES.modeles;

/**
 * @author Visual Paradigm
 */
public class SousDiscipline extends Discipline {

	protected String description;
	
	// ----------- Constructors -----------
	
	public SousDiscipline(String nom, String description, String description2) {
		super(nom, description);
		description = description2;
	}
	
	// ----------- Getters & setters -----------
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	// ----------- Methods -----------

}