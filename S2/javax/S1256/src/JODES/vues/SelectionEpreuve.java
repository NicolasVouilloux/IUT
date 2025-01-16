//correct package - Emma
package JODES.vues;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import JODES.JO2024;
import JODES.controleurs.ControleurBTNRetour;
import JODES.controleurs.RetourVue;

//correct naming of class - Emma
public class SelectionEpreuve extends JFrame implements RetourVue {

    private static final long serialVersionUID = 1L;
    protected ComboBoxEpreuve epreuveSelect;
    protected JButton valider;
    protected JPanel panelDel;
    protected JLabel indicationDelete;
    protected JPanel panelIndication;

    public SelectionEpreuve(ActionListener ControleurBoutonValider) {
        // Create main frame
        super("Selection d'une épreuve");
        setSize(800, 450);
        setLayout(new GridLayout (4,1));

        // Initialize elements
        PanelTitle panelTitle = new PanelTitle("Epreuves");
        add(panelTitle); 
        valider = new JButton("✔");
        valider.addActionListener(ControleurBoutonValider);
        epreuveSelect = new ComboBoxEpreuve(JO2024.getEpreuves());
        indicationDelete = new JLabel("Veuillez saisir l'Id de l'épreuve à supprimer",JLabel.CENTER);

        // Initialize the panels
        panelDel = new JPanel();
        panelDel.setLayout(new FlowLayout());
        panelIndication = new JPanel();
        panelIndication.setLayout(new FlowLayout());

        //Add elements to panelIndication
        panelIndication.add(indicationDelete);
        
        // Add elements to panelDel
        panelDel.add(epreuveSelect);
        panelDel.add(valider);

        // Add panelDel and panelIndication to frame
        add(panelIndication);
        add(panelDel);

        //Nicolas 
        JButton button = new JButton("Retour" + "\u21A9");
        ControleurBTNRetour BtnRetour = new ControleurBTNRetour(this);
        button.addActionListener(BtnRetour);
        add(button);//TODO mettre le bouton au bon endroit
        //pas Nicolas
        // Make the frame visible
        setVisible(true);

        // Exit the application when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création d'un nouveau panelTitle 
        
        // Pack the frame to fit its components
        pack();
    }

    public static void main(String[] args) {
        new SelectionEpreuve();
    }

	@Override
	public void retour() {
		new EpreuveFrame();
		this.dispose();
	}
}


