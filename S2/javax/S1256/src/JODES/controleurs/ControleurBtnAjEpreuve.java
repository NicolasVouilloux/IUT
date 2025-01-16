//Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import JODES.vues.AjouterEpreuve;

public class ControleurBtnAjEpreuve implements ActionListener {
	protected JFrame _vue;
	
	public ControleurBtnAjEpreuve(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new AjouterEpreuve();
		((JFrame) _vue).dispose();
	}

}
