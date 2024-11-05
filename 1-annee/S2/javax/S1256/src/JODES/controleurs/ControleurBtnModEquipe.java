//Emma ESCOFFIER
package JODES.controleurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import JODES.modeles.Entite;
import JODES.modeles.Equipe;
import JODES.vues.ModifierEquipe;

public class ControleurBtnModEquipe implements ActionListener{
	protected JFrame _vue;
	public ControleurBtnModEquipe(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ModifierEquipe((Equipe) this._modele);
		((JFrame) _vue).dispose();
	}
// TODO this needs to go to selectionnerEquipe Vue , which then goes to modif equipe specific vue.
}
