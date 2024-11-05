// Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import JODES.vues.SuppressionSession;

public class ControleurBtnSupprSession implements ActionListener {
	protected JFrame _vue;
	
	public ControleurBtnSupprSession(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new SuppressionSession();
		((JFrame) _vue).dispose();
	}
}
