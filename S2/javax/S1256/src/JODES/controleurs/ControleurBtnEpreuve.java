// Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import JODES.vues.EpreuveFrame;

public class ControleurBtnEpreuve implements ActionListener{
	protected JFrame _vue;
	
	public ControleurBtnEpreuve(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new EpreuveFrame();
		((JFrame) _vue).dispose();
	}
}
