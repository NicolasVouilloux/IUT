package librairieControle;

public class LivreEcrit extends Livre implements Empruntable{


	private int nbPage;
	private int maxDureeEmprunt;
	private int dureeEmprunt;

	public int getNbPage() {return nbPage;}
	public void setNbPage(int nbPage) {this.nbPage = nbPage;}
	public int getMaxDureeEmprunt() {return maxDureeEmprunt;}
	public void setMaxDureeEmprunt(int maxDureeEmprunt) {this.maxDureeEmprunt = maxDureeEmprunt;}
	public int getDureeEmprunt() {return dureeEmprunt;}
	public void setDureeEmprunt(int dureeEmprunt) {
		if (dureeEmprunt < maxDureeEmprunt)
			this.dureeEmprunt = dureeEmprunt;
		else
			System.out.println("Duree Trop Grande");
	}
	

	public void estDifficile() {
		if ( nbPage > 300 )
			setDifficile(true);
	}

	public LivreEcrit(String titreDocument, String descriptif,String auteur,int nbPages) {
		super(titreDocument,descriptif,auteur);
		setNbPage(nbPages);
		estDifficile();
	}
	@Override
	public void dureeEmprunt() {
		// TODO Auto-generated method stub
		if (nbPage>300)
			setMaxDureeEmprunt(DUREE_MAX_300);
		else if (nbPage>150)
			setMaxDureeEmprunt(DUREE_MAX_150);
		else 
			setMaxDureeEmprunt(DUREE_MAX);
	}
	

}
