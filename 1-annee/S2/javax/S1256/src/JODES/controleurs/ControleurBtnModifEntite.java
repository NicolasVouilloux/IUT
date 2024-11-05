package JODES.controleurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import JODES.modeles.*;

public class ControleurBtnModifEntite extends Controleur implements ActionListener {
	
	public ControleurBtnModifEntite(Object modele, JFrame vue) {
		super(modele, vue);
	}

	// ----------- Methods -----------

	@Override
	public void actionPerformed(ActionEvent e) {
		((Entite) this._modele).menuModification();
	}

}
