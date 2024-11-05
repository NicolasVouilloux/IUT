//Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import JODES.vues.AjouterSession;

public class ControleurBtnAjSession extends Controleur implements ActionListener{

	public ControleurBtnAjSession(JFrame vue) {
		super(null, vue);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new AjouterSession();
		((JFrame) _vue).dispose();
	}
}
