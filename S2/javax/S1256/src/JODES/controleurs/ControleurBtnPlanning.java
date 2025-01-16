// Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import JODES.vues.PlanningFrame;

public class ControleurBtnPlanning implements ActionListener {
	protected JFrame _vue;
	public ControleurBtnPlanning(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new PlanningFrame();
		((JFrame) _vue).dispose();
	}
}
