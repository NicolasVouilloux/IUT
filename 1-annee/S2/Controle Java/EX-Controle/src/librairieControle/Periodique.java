package librairieControle;

public class Periodique extends Documents{
	private int nbParutionAnnuel;
	private String caracteristique;
	
	public int getNbParutionAnnuel() {return nbParutionAnnuel;}
	public void setNbParutionAnnuel(int nbParutionAnnuel) {this.nbParutionAnnuel = nbParutionAnnuel;}
	public String getCaracteristique() {return caracteristique;}
	public void setCaracteristique(String caracteristique) {this.caracteristique = caracteristique;}
	
	public Periodique(String titreDocument, String descriptif,int nbParutionAnnuel){
		super(titreDocument,descriptif);
		if (nbParutionAnnuel < 12)
			setCaracteristique("mensuel");
		else if (nbParutionAnnuel < 52)
			setCaracteristique("hebdomadaire");
		else 
			setCaracteristique("quotidien");
	}
}
