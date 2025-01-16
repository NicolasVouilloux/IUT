package librairieControle;

public class DVD extends Documents implements Empruntable{
	
	private String categorie;
	private int maxDureeEmprunt;
	private int dureeEmprunt;

	public int getMaxDureeEmprunt() {return maxDureeEmprunt;}
	public void setMaxDureeEmprunt(int maxDureeEmprunt) {this.maxDureeEmprunt = maxDureeEmprunt;}
	public String getCategorie() {return categorie;}
	public void setCategorie(String categorie) {this.categorie = categorie;}
	public int getDureeEmprunt() {return dureeEmprunt;}
	public void setDureeEmprunt(int dureeEmprunt) {
		if (dureeEmprunt < maxDureeEmprunt)
			this.dureeEmprunt = dureeEmprunt;
		else
			System.out.println("Duree Trop Grande");
	}
	
	@Override
	public void dureeEmprunt() {
		setMaxDureeEmprunt(DUREE_MAX_DVD);
	}
	
	public DVD(String titreDocument, String descriptif,String categorie, int dureeEmprunt) {
		super(titreDocument,descriptif);
		setCategorie(categorie);
		setDureeEmprunt(dureeEmprunt);
		
	}
	
}
