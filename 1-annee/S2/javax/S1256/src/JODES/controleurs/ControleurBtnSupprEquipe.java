// Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import JODES.vues.SuppressionEquipe;

public class ControleurBtnSupprEquipe implements ActionListener {
	protected JFrame _vue;
	public ControleurBtnSupprEquipe(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new SuppressionEquipe();
		((JFrame) _vue).dispose();
	}
}
