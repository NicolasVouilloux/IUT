// Emma ESCOFFIER
package JODES.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import JODES.vues.SessionFrame;

public class ControleurBtnSession implements ActionListener{
	protected JFrame _vue;
	
	public ControleurBtnSession(JFrame vue) {
		this._vue = vue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new SessionFrame();
		((JFrame) _vue).dispose();
	}
}