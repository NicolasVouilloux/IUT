//correct package - Emma
package JODES.vues;

import java.awt.*;
import javax.swing.*;

import JODES.JO2024;
import JODES.controleurs.ControleurBTNRetour;
import JODES.controleurs.ControleurBtnModSession;
import JODES.controleurs.RetourVue;

//correct naming of class - Emma
public class SuppressionEpreuve extends SelectionEpreuve {

    private static final long serialVersionUID = 1L;
    protected JTextField epreuveDel;
    protected JButton valider;
    protected JPanel panelDel;
    protected JLabel indicationDelete;
    protected JPanel panelIndication;

    public SuppressionEpreuve() {
        // Create main frame
        super(new ControleurBtnModSession());
    }

    public static void main(String[] args) {
        new SuppressionEpreuve();
    }

	@Override
	public void retour() {
		new EpreuveFrame();
		this.dispose();
	}
}


