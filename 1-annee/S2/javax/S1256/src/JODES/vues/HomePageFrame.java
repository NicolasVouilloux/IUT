// ESCOFFIER Emma
package JODES.vues;
import javax.swing.*;
import JODES.controleurs.*;
import java.awt.*;

public class HomePageFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel p = new JPanel();
	
	PanelTitle title = new PanelTitle("JODES");
	
	JButton planning = new JButton("Planning");
	JButton equipes = new JButton("Equipes");
	JButton sessions = new JButton("Sessions");
	JButton epreuves = new JButton("Epreuves");

	public HomePageFrame(){
		setTitle("JODES");
		setSize (800, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		add(title, BorderLayout.NORTH);
		
		setButtonColors(planning);
		setButtonColors(equipes);
		setButtonColors(sessions);
		setButtonColors(epreuves);
		p.setLayout(new GridLayout(4, 1, 10, 10));

		p.add(planning);
		p.add(equipes);
		p.add(sessions);
		p.add(epreuves);
		
		add(p);

		ControleurBtnPlanning ctrlBtnPlann = new ControleurBtnPlanning(this);
		ControleurBtnEpreuve ctrlBtnEpr = new ControleurBtnEpreuve(this);
		ControleurBtnEquipe ctrlBtnEqu = new ControleurBtnEquipe(this);
		ControleurBtnSession ctrlBtnSes = new ControleurBtnSession(this);
		
		epreuves.addActionListener(ctrlBtnEpr);
		planning.addActionListener(ctrlBtnPlann);
		equipes.addActionListener(ctrlBtnEqu);
		sessions.addActionListener(ctrlBtnSes);
		
		setVisible(true);
	}
	
	protected void setButtonColors(JButton button) {
		button.setBackground(Color.lightGray);
		button.setForeground(Color.WHITE);
	}

	public static void main(String[] args) {
		HomePageFrame testAffichage = new HomePageFrame();
		}
}