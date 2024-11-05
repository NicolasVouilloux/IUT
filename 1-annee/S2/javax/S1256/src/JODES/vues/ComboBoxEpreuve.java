package JODES.vues;
import java.util.ArrayList;
import javax.swing.JComboBox;
import JODES.modeles.*;

public class ComboBoxEpreuve extends JComboBox<String> {
    
    protected ArrayList<Epreuve> listeEpreuves;

    public ComboBoxEpreuve(ArrayList<Epreuve> listeEpreuves) {
        this.listeEpreuves = listeEpreuves;
        addItems();
    }

    protected void addItems() {
        this.addItem("");
        for (Epreuve p : listeEpreuves)
        {
            this.addItem(p.getNom());
        }
    }

    public ArrayList<Epreuve> getItemList() {
        return listeEpreuves;
    }
    
}
