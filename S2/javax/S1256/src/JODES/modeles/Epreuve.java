package JODES.modeles;

import java.util.ArrayList;

/**
 * @author Ash Merienne
 */
public class Epreuve extends Entite {
    
	protected ArrayList<Equipe> sesEquipes;
    
    // ----------- Constructors -----------

    public Epreuve(String nom, Equipe equipe) {
        super(nom);
        this.sesEquipes = new ArrayList<Equipe>();
        this.sesEquipes.add(equipe);
    }

    public Epreuve(String nom, ArrayList<Equipe> equipes) {
        super(nom);
        this.sesEquipes = equipes;
    }

    // ----------- Getters & setters -----------

    public ArrayList<Equipe> getSesEquipes() {
        return sesEquipes;
    }

    public void setSesEquipes(ArrayList<Equipe> sesEquipes) {
        this.sesEquipes = sesEquipes;
    }

    // ----------- Methods ----------

    @Override
    public void menuModification() {
        return;
    }

    @Override
    public void menuModificationVisuel() {
        return;
    }
    
}
