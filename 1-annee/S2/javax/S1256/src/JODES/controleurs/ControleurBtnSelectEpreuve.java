package JODES.controleurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import JODES.JO2024;
import JODES.modeles.Epreuve;
import JODES.vues.AjouterEpreuve;
import JODES.vues.ComboBoxEpreuve;
import JODES.vues.MessageBox;
import JODES.vues.ModifierEpreuve;

public class ControleurBtnSelectEpreuve implements ActionListener  {

    protected Epreuve epreuve;
    protected ComboBoxEpreuve CMB;
    protected int option;
    public static final int MODIF = 0;
    public static final int SUPPR = 1;

    public ControleurBtnSelectEpreuve(ComboBoxEpreuve comboEpreuve, int option) {
        this.CMB = comboEpreuve;
        if (option == MODIF || option == SUPPR) this.option = option;
        else this.option = MODIF;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.CMB.getSelectedItem() == "") {
            new MessageBox(
                "Vous devez sélectionner une Epreuve !",
                "Champ obligatoire",
                JOptionPane.YES_NO_CANCEL_OPTION);
        }
        else {
            String nomEpreuve = (String)CMB.getSelectedItem();
            this.epreuve = (Epreuve)JO2024.rechercheEntite(nomEpreuve);
            if (this.option == MODIF) new ModifierEpreuve(this.epreuve);
            else {
                JO2024.removeEntite(epreuve);
            };
        }
    }
    
}
