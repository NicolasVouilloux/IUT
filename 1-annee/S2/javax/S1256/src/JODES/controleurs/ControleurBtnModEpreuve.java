//Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import JODES.vues.ModifierEpreuve;

public class ControleurBtnModEpreuve implements ActionListener{
	protected JFrame _vue;
	public ControleurBtnModEpreuve(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ModifierEpreuve(); // TODO will have to update according to Nico and Ash modif
		((JFrame) _vue).dispose();
	}

}
