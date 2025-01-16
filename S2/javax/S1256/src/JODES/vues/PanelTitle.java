package JODES.vues;
import javax.swing.*;
import java.awt.*;

public class PanelTitle extends JPanel{
	private static final long serialVersionUID = 1L;
	protected JLabel title;
	
	PanelTitle(String titleText){
		title = new JLabel(titleText);
		title.setFont(new Font("Arial", Font.BOLD, 24));
		title.setForeground(Color.white);
		setBackground(Color.DARK_GRAY);
		add(title);
	}
}
