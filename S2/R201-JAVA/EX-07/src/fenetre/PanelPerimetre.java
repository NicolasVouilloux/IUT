package fenetre;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelPerimetre extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelSaisie panelLongueur;
	private PanelSaisie panelLargeur;
	private JPanel panelResultat;
	private JPanel panelBoutons;
	
	
	
	public PanelPerimetre() {
		panelLongueur = new PanelSaisie("Longueur : ",10);
		panelLargeur = new PanelSaisie("Largueur : ",10);
		panelResultat = new JPanel();
		setLayout(new GridLayout (4,1));
		panelResultat.setLayout(new GridLayout(1,2));
		
		JLabel perimetre = new JLabel("Perimetre : ");
		JLabel resultat = new JLabel("0");
		
		panelResultat.add(perimetre);
		panelResultat.add(resultat);
		panelBoutons = new JPanel();
		panelBoutons.setLayout(new GridLayout(1,2));
		JButton BTNCalculer = new JButton("Calculer");
		JButton BTNNettoyer = new JButton("Nettoyer");
		
		BTNCalculer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					float largeur = Float.parseFloat(panelLongueur.text.getText());
					float longueur = Float.parseFloat(panelLargeur.text.getText());;
					resultat.setText(String.valueOf(largeur*longueur));
				}
				catch(NumberFormatException nfe) {
		            System.out.println("NumberFormat Exception: invalid input string");
		        }
			}
		
		});
		
		BTNNettoyer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				resultat.setText("0");
				(panelLongueur.text).setText("");
				(panelLargeur.text).setText("");
			}
		});
		panelBoutons.add(BTNCalculer);
		panelBoutons.add(BTNNettoyer);
		
		add(panelLongueur);
		add(panelLargeur);
		add(panelResultat);
		add(panelBoutons);
		
		
	}
	public static void main (String []args) {
		JFrame fenetre;
		fenetre = new JFrame ("Calcul Perimetre");
		fenetre.setSize(10,100);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(false);
		fenetre.setBounds (700,200,300,200);
		
		PanelPerimetre lecompletchef = new PanelPerimetre();
		
		fenetre.add(lecompletchef);
		fenetre.setVisible(true);
	}
}
