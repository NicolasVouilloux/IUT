//Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import JODES.modeles.Session;

import JODES.vues.ModifierSession;

public class ControleurBtnModSession implements ActionListener {
	protected JFrame _vue;
	
	public ControleurBtnModSession(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ModifierSession((Session)super.get_modele()); // will need to modif after ash and nico modif
		((JFrame) _vue).dispose();
	}
}
