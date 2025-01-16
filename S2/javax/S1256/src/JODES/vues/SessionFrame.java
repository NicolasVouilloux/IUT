package JODES.vues;
import javax.swing.*;
import JODES.controleurs.*;
import java.awt.*;

public class SessionFrame extends JFrame implements RetourVue{

    public SessionFrame() {
        // Create main frame
        super("JODES");
        setSize(800, 450);
        setLayout(new BorderLayout());

        // Create panels
        PanelTitle panelTitle = new PanelTitle("Sessions");
        PanelButton panelButton = new PanelButton();

        // Add panels to frame
        add(panelTitle, BorderLayout.NORTH);
        add(panelButton, BorderLayout.CENTER);
        
        //Emma ESCOFFIER
        ControleurBtnSupprSession ctrlSupprSes = new ControleurBtnSupprSession(this);
        ControleurBtnAjSession ctrlAjSes = new ControleurBtnAjSession(this);
        ControleurBtnModSession ctrlModSes = new ControleurBtnModSession(this);
        
        panelButton.boutonSupprimer.addActionListener(ctrlSupprSes);
        panelButton.boutonAjouter.addActionListener(ctrlAjSes);
        panelButton.boutonModifier.addActionListener(ctrlModSes);
        
        //Nicolas 
        JButton button = new JButton("Retour" + "\u21A9");
        ControleurBTNRetour BtnRetour = new ControleurBTNRetour(this);
        button.addActionListener(BtnRetour);
        add(button,BorderLayout.SOUTH);//TODO mettre le bouton au bon endroit
        //pas Nicolas
        
        // Make the frame visible
        setVisible(true);

        // Exit the application when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
    	//Create the mainSession frame
        SessionFrame Session = new SessionFrame();
    }
    //Nicolas
	@Override
	public void retour() {
		new HomePageFrame();
		this.dispose();
	}
}

