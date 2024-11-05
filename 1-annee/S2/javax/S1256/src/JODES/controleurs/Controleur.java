package JODES.controleurs;
import javax.swing.JFrame;
import JODES.modeles.Entite;

/**
 * @author Ash Merienne
 */
public abstract class Controleur  {
	protected Entite _modele;
	protected JFrame _vue;

	// ----------- Constructors -----------
	
	public Controleur(Entite modele, JFrame vue) {
		this._modele = modele;
		this._vue = vue;
	
	}

	public Entite get_modele() {
		return _modele;
	}

	public void set_modele(Entite _modele) {
		this._modele = _modele;
	}

	public JFrame get_vue() {
		return _vue;
	}

	public void set_vue(JFrame _vue) {
		this._vue = _vue;
	}
}
