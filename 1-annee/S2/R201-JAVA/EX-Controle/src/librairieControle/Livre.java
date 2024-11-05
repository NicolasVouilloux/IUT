package librairieControle;

public abstract class Livre extends Documents{
	private String auteur;
	private boolean difficile = false;
	
	
	public abstract void estDifficile();

	public String getAuteur() {return auteur;}
	public void setAuteur(String auteur) {this.auteur = auteur;}
	public boolean isDifficile() {return difficile;}
	public void setDifficile(boolean difficile) {this.difficile = difficile;}
	
	public Livre(String titreDocument, String descriptif,String auteur) {
		super(titreDocument,descriptif);
		setAuteur(auteur);
	}
}
