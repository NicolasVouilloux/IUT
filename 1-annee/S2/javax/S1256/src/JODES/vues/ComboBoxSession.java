package JODES.vues;
import java.util.ArrayList;
import javax.swing.JComboBox;
import JODES.modeles.*;

public class ComboBoxSession extends JComboBox<String> {
    
    protected ArrayList<Session> listeSessions;

    public ComboBoxSession(ArrayList<Session> listeSessions) {
        this.listeSessions = listeSessions;
        addItems();
    }

    protected void addItems() {
        this.addItem("");
        this.addItem("Créer une nouvelle session");
        for (Session s : listeSessions)
        {
            this.addItem(s.getNom() + " " +
                s.getSaDiscipline().getNom() +
                s.getDate().toString());
        }
    }

    public ArrayList<Session> getItemList() {
        return listeSessions;
    }
    
}
