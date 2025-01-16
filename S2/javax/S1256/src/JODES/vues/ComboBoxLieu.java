package JODES.vues;
import java.util.ArrayList;
import javax.swing.JComboBox;
import JODES.modeles.*;

public class ComboBoxLieu extends JComboBox<String> {
    
    protected ArrayList<Lieu> listeLieu;

    public ComboBoxLieu(ArrayList<Lieu> listeLieu) {
        this.listeLieu = listeLieu;
        addItems();
    }

    protected void addItems() {
        this.addItem("");
        for (Lieu p : listeLieu)
        {
            this.addItem(p.getNom());
        }
    }

    public ArrayList<Lieu> getItemList() {
        return listeLieu;
    }
    
}