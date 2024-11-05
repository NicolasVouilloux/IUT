//Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import JODES.vues.AjouterEquipe;

public class ControleurBtnAjEquipe implements ActionListener{
	protected JFrame _vue;
	public ControleurBtnAjEquipe(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new AjouterEquipe();
		((JFrame) _vue).dispose();
	}

}
