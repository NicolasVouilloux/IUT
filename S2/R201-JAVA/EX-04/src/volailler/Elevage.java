package volailler;

import java.util.ArrayList;

public class Elevage {
	
	private ArrayList<Volailles>sesVolailles;
	
	public Elevage() {
		this.sesVolailles = new ArrayList<Volailles>();
	}

	public ArrayList<Volailles> getSesVollailles() {return sesVolailles;}
	public void setSesVollailles(ArrayList<Volailles> sesVollailles) {this.sesVolailles = sesVollailles;}

	public void ajouter(Volailles volailles) {
		sesVolailles.add(volailles);
		volailles.setSonElevage(this);
	}
	public void changePoids(int identifiant,double poids) {
		for (Volailles volailles : sesVolailles) {
			if (volailles.getIdentifiant()==identifiant)
				volailles.setPoids(poids);
		}
	}
	public void ecrire() {
		for (Volailles volailles : sesVolailles) {
			System.out.println(volailles);
		}
	}
	public String afficherBetesAAbattre() {
		miseAJourVolailles();
		String resultat = "";
		for (Volailles volailles : sesVolailles) {
			if (volailles.isBeteAAbatre())
				resultat += volailles +"\n";
		}
		return resultat;
	}
	public String evaluerBetesAAbattre() {
		miseAJourVolailles();
		double valeurMarchande = 0;
		for (Volailles volailles : sesVolailles) {
			if (volailles.isBeteAAbatre())
				valeurMarchande += volailles.prixDeVente() ;
		}
		return ""+valeurMarchande;
	}
	public void miseAJourVolailles() {
		for (Volailles volailles : sesVolailles) {
			if (volailles.getPoids()>0.75)
				volailles.setBeteAAbatre(true);
		}
	}
	public ArrayList <Volailles> envoyerALAbattoir() {
		ArrayList<Volailles> volaillesAAbattre = new ArrayList<>();
		for (Volailles v: sesVolailles) {
			if (v.isBeteAAbatre())
				volaillesAAbattre.add(v);
		}
		for (Volailles v :volaillesAAbattre)
			sesVolailles.remove(v);
		return volaillesAAbattre;
	}
}
