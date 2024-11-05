package fenetre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.GridLayout;

public class fenetre {
	public static float perimetre(float a,float b) {
		return a*b;
	}
	
	public static void main (String[]args) {
		JFrame fenetre;
		fenetre = new JFrame ("Calcul Perimetre");
		fenetre.setSize(10,100);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.setResizable(false);
		fenetre.setBounds (300,300,400,400);
		
		
		
		JPanel p = new JPanel();
		JLabel lblLongueur = new JLabel("longueur : ");
		JTextField txtLongueur = new JTextField (20);
		JLabel lblLargeur = new JLabel("longueur : ");
		JTextField txtLargeur = new JTextField (20);
		
		p.add(lblLongueur);
		p.add(txtLongueur);
		p.add(lblLargeur);
		p.add(txtLargeur);
		
		JLabel lblResultat = new JLabel("Resultat : ");
		JLabel lblCalculable = new JLabel("0");
		p.add(lblResultat);
		p.add(lblCalculable);
	
		JButton btnCalc = new JButton("Calculer");
		btnCalc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					float largeur = Float.parseFloat(txtLargeur.getText());
					float longueur = Float.parseFloat(txtLongueur.getText());;
					lblCalculable.setText(String.valueOf(perimetre(longueur,largeur)));
				}
				catch(NumberFormatException nfe) {
		            System.out.println("NumberFormat Exception: invalid input string");
		        }		
			}
		});
		
		JButton btnFlush = new JButton("Nettoyer");
		btnFlush.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblCalculable.setText("0");
				txtLongueur.setText("");
				txtLargeur.setText("");
			}
		});
		
		p.add(btnCalc);
		p.add(btnFlush);
		
		fenetre.add(p);
		
		fenetre.setVisible(true);
	}
}
