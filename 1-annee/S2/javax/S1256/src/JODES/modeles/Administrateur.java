package JODES.modeles;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Nicolas Vouilloux
 */
public class Administrateur extends Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	ArrayList<Modification> sesModifications;
	
	// ----------- Constructors -----------
	
	public Administrateur(String login, String password, String prenom, String nom) {
		super(login, password, prenom, nom);
		this.sesModifications = new ArrayList<Modification>();
	}
	
	// ----------- Getters & setters -----------
	
	public ArrayList<Modification> getSesModifications() {
		return sesModifications;
	}

	public void setSesModifications(ArrayList<Modification> sesModifications) {
		this.sesModifications = sesModifications;
	}
	
	// ----------- Methods -----------
	
	protected void enregisterModifications() {
		// - Nicolas Vouilloux
		for (Modification modif : sesModifications){
			modif.envoyerModifServeur();
		}
	}

	protected void modifierEntite(Entite entite) {
		// - Nicolas Vouilloux
		Entite newEntite = entite;
		newEntite.menuModification();
		Modification Modif = new Modification(newEntite,this,Modification.UPDATE);
		sesModifications.add(Modif);
	}

	protected void annulerModification(Modification modification) {
		// - Nicolas Vouilloux
		for (Modification modif : sesModifications){
			if (modif == modification)
				sesModifications.remove(modif);
		}
	}

	protected void creerEntite(Entite entite) {
		// - Nicolas Vouilloux
		entite.menuModification();
		Modification modif = new Modification(entite,this,Modification.UPDATE);
		this.sesModifications.add(modif);
	}

	protected void supprimerEntite(int idEntite) {
		// - Nicolas Vouilloux
		Modification modif = new Modification(idEntite,this);
		this.sesModifications.add(modif);
	}
}