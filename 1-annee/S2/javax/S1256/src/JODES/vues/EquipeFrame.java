package JODES.vues;
import javax.swing.*;
import JODES.controleurs.*;
import java.awt.*;

public class EquipeFrame extends JFrame implements RetourVue{

    public EquipeFrame() {
        // Create main frame
        super("JODES");
        setSize(800, 450);
        setLayout(new BorderLayout());

        // Create panels
        PanelTitle panelTitle = new PanelTitle("Equipes");
        PanelButton panelButton = new PanelButton();
        
        //Emma ESCOFFIER
        ControleurBtnSupprEquipe ctrlSupprEqu = new ControleurBtnSupprEquipe(this);
        ControleurBtnAjEquipe ctrlAjEqu = new ControleurBtnAjEquipe(this);
        ControleurBtnModEquipe ctrlModEq = new ControleurBtnModEquipe(this);
        
        panelButton.boutonSupprimer.addActionListener(ctrlSupprEqu);
        panelButton.boutonAjouter.addActionListener(ctrlAjEqu);
        panelButton.boutonModifier.addActionListener(ctrlModEq);
        
        //Nicolas 
        JButton button = new JButton("Retour" + "\u21A9");
        ControleurBTNRetour BtnRetour = new ControleurBTNRetour(this);
        button.addActionListener(BtnRetour);
        add(button,BorderLayout.SOUTH);//TODO mettre le bouton au bon endroit
        //pas Nicolas
        
        // Add panels to frame
        add(panelTitle, BorderLayout.NORTH);
        add(panelButton, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
        
        // Exit the application when the frame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
    	EquipeFrame Equipe = new EquipeFrame();    }
    
    //Nicolas
	@Override
	public void retour() {
		new HomePageFrame();
		this.dispose();
	}
}
