package JODES.vues;

import javax.swing.*;
import java.awt.*;

public class PanelButton extends JPanel {

    protected JButton boutonAfficher;
    protected JButton boutonModifier;
    protected JButton boutonAjouter;
    protected JButton boutonSupprimer;

    public PanelButton() {
        boutonAfficher = new JButton("Afficher");
        boutonModifier = new JButton("Modifier");
        boutonAjouter = new JButton("Ajouter");
        boutonSupprimer = new JButton("Supprimer");

        // Setting button colors
        setButtonColors(boutonAfficher);
        setButtonColors(boutonModifier);
        setButtonColors(boutonAjouter);
        setButtonColors(boutonSupprimer);

        setLayout(new GridLayout(4, 1, 10, 10)); // 4 rows, 1 column, gaps of 10px
        add(boutonAfficher);
        add(boutonModifier);
        add(boutonAjouter);
        add(boutonSupprimer);
    }

    protected void setButtonColors(JButton button) {
        button.setBackground(Color.lightGray);
        button.setForeground(Color.WHITE);
    }
}
