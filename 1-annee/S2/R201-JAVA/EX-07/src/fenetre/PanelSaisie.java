package fenetre;
import java.awt.GridLayout;

import javax.swing.*;

public class PanelSaisie extends JPanel{

	private static final long serialVersionUID = 1L;
	JLabel label;
	JTextField text;
	
	public PanelSaisie (String labelContent,int nombreCharactere) {
		label = new JLabel(labelContent);
		text = new JTextField(nombreCharactere);
		setLayout(new GridLayout(1,2));
		add(label);
		add(text);
		}
}
