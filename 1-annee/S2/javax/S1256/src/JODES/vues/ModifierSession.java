package JODES.vues;
import javax.swing.*;
import JODES.JO2024;
import JODES.controleurs.ControleurBTNRetour;
import JODES.controleurs.RetourVue;
import JODES.modeles.Session;

import java.awt.*;

public class ModifierSession extends JFrame implements RetourVue{

    protected Session sessionModele;

	public ModifierSession(Session sessionModele) {
        super("JODES");
        this.sessionModele = sessionModele;
        
        PanelTitle panelTitle = new PanelTitle("Session Création");
        JButton button = new JButton("Retour" + "\u21A9");
        ControleurBTNRetour btnretour = new ControleurBTNRetour(this);
        add(button, BorderLayout.SOUTH);
        JButton buttonSave = new JButton("Sauvegarder et quitter");
      
        add(panelTitle, BorderLayout.NORTH);
        button.addActionListener(btnretour);
        
        JPanel panelSaveRetour = new JPanel();
        panelSaveRetour.setLayout(new GridLayout(2,1));
        panelSaveRetour.add(buttonSave);
        panelSaveRetour.add(button);
        add(panelSaveRetour,BorderLayout.SOUTH);
        
        
        JPanel panelDuMilieu = new JPanel();
        panelDuMilieu.setLayout(new GridLayout(3,2));
		panelDuMilieu.add(new GridFormField(new JTextField(""),new JLabel("Nom Equipe :")));
		panelDuMilieu.add(new GridFormField(new ComboBoxPays(JO2024.getPays()),new JLabel("Pays :")));
		panelDuMilieu.add(new GridFormField(new JTextField(""),new JLabel("Date :")));
		add(panelDuMilieu,BorderLayout.CENTER);
      
        setSize(800, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public static void main(String[] args) {
        JO2024.initialize();
		new ModifierSession(new Session());
    }

    //Nicolas
	@Override
	public void retour() {
		new SessionFrame();
		(this).dispose();
	}
}