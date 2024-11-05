//correct package - Emma
package JODES.vues;
import java.awt.*;
import javax.swing.*;
import JODES.controleurs.ControleurBTNRetour;
import JODES.controleurs.RetourVue;

public class SuppressionSession extends JFrame implements RetourVue{

    private static final long serialVersionUID = 1L;
    protected JTextField sessionDel;
    protected JButton valider;
    protected JPanel panelDel;
    protected JLabel indicationDelete;
    protected JPanel panelIndication;

    public SuppressionSession() {
        // Create main frame
    	// Création d'un nouveau panelTitle 
        super("JODES");
        setSize(800, 450);
        setLayout(new GridLayout (4,1));
        // Initialize elements
        PanelTitle panelTitle = new PanelTitle("Sessions");
        add(panelTitle); 
        valider = new JButton("✔");
        sessionDel = new JTextField("Id...",15);
        indicationDelete = new JLabel("Veuillez saisir l'Id de la session à supprimer");

        // Initialize the panels
        panelDel = new JPanel();
        panelDel.setLayout(new FlowLayout());
        panelIndication = new JPanel();
        panelIndication.setLayout(new FlowLayout());

        //Add elements to panelIndication
        panelIndication.add(indicationDelete);
        
        // Add elements to panelDel
        panelDel.add(sessionDel);
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

        
        // Pack the frame to fit its components
        pack();
    }

    public static void main(String[] args) {
        new SuppressionSession();
    }
    //Nicolas
	@Override
	public void retour() {
		new SessionFrame();
		this.dispose();
	}
}

