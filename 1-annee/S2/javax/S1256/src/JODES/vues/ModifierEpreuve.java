package JODES.vues;
import javax.swing.*;
import JODES.JO2024;
import JODES.controleurs.ControleurBTNRetour;
import JODES.controleurs.RetourVue;
import JODES.modeles.Epreuve;
import JODES.modeles.Equipe;

import java.awt.*;

public class ModifierEpreuve extends JFrame implements RetourVue{

	private static final long serialVersionUID = 1L;
	protected Epreuve epreuveModele;
	
	public ModifierEpreuve(Epreuve epreuve) {
        
        super("JODES");
        
        PanelTitle panelTitle = new PanelTitle("Ajouter epreuve");
        JButton button = new JButton("Retour" + "\u21A9");
        ControleurBTNRetour btnretour = new ControleurBTNRetour(this);

        add(button, BorderLayout.SOUTH);
        JButton buttonSave = new JButton("Sauvegarder & Quitter" + "🖉");
      
        add(panelTitle, BorderLayout.NORTH);
        button.addActionListener(btnretour);
        
        JPanel panelSaveRetour = new JPanel();
        panelSaveRetour.setLayout(new GridLayout(2,1));
        panelSaveRetour.add(buttonSave);
        panelSaveRetour.add(button);
        add(panelSaveRetour,BorderLayout.SOUTH);
        
        JPanel panelDuMilieu = new JPanel();
        panelDuMilieu.setLayout(new GridLayout(3,2));
        panelDuMilieu.add(new GridFormField(new JTextField(epreuveModele.getNom()),new JLabel("Nom Epreuve :")));
		panelDuMilieu.add(new GridFormField(new ComboBoxHoraires(),new JLabel("Horaire Debut :")));
		panelDuMilieu.add(new GridFormField(new ComboBoxHoraires(),new JLabel("Horaire Fin :")));
        panelDuMilieu.add(new GridFormField(new ComboBoxEpreuve(JO2024.getEpreuves()),new JLabel("Session :")));
		
		add(panelDuMilieu,BorderLayout.CENTER);
        
        
        // TODO fill fields

		add(panelDuMilieu,BorderLayout.CENTER);
      
        setSize(800, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
    	JO2024.initialize();
        ModifierEpreuve testAffichage = new ModifierEpreuve(new Epreuve("",new Equipe("", null)));
    }
    //Nicolas
	@Override
	public void retour() {
		new EpreuveFrame();
		(this).dispose();
	}
}