package JODES.vues;
import javax.swing.*;
import JODES.controleurs.ControleurBTNRetour;
import JODES.controleurs.RetourVue;
import JODES.controleurs.*;
import java.awt.*;

public class EpreuveFrame extends JFrame implements RetourVue {

	public EpreuveFrame() {
        // Create main frame
        super("JODES");
        setSize(800, 450);
        setLayout(new BorderLayout());

        // Create panels
        PanelTitle panelTitle = new PanelTitle("Epreuves");
        PanelButton panelButton = new PanelButton();
        
        // Add panels to frame
        add(panelTitle, BorderLayout.NORTH);
        add(panelButton, BorderLayout.CENTER);
        
        //Emma ESCOFFIER
        ControleurBtnSupprEpreuve ctrlSupprEpr = new ControleurBtnSupprEpreuve(this);
        ControleurBtnAjEpreuve ctrlAjEpr = new ControleurBtnAjEpreuve(this);
        ControleurBtnModEpreuve ctrlModEpr = new ControleurBtnModEpreuve(this);
        
        panelButton.boutonSupprimer.addActionListener(ctrlSupprEpr);
        panelButton.boutonAjouter.addActionListener(ctrlAjEpr);
        panelButton.boutonModifier.addActionListener(ctrlModEpr);
        
        //Nicolas 
        JButton button = new JButton("Retour" + "\u21A9");
        ControleurBTNRetour BtnRetour = new ControleurBTNRetour(this);
        button.addActionListener(BtnRetour);
        add(button, BorderLayout.SOUTH);
        //pas Nicolas
        
        // Make the frame visible
        setVisible(true);
        // Exit the application when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }

    public static void main(String[] args) {
    	//Create the mainEpreuve frame
        EpreuveFrame Epreuve = new EpreuveFrame();
    }
    //Nicolas
	@Override
	public void retour() {
		new HomePageFrame();
		(this).dispose();
	}
}
