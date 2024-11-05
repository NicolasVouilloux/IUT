// Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import JODES.vues.SuppressionEpreuve;

public class ControleurBtnSupprEpreuve implements ActionListener {
	protected JFrame _vue;
	public ControleurBtnSupprEpreuve(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new SuppressionEpreuve();
		((JFrame) _vue).dispose();
	}

}
