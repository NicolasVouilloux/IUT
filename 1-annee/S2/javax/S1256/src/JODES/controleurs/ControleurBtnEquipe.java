// Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import JODES.vues.EquipeFrame;

public class ControleurBtnEquipe extends Controleur implements ActionListener{
	public ControleurBtnEquipe(JFrame vue) {
		super(null, vue);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new EquipeFrame();
		((JFrame) _vue).dispose();
	}
}
