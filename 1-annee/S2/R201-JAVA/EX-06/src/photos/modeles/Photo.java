package photos.modeles;
import java.io.File; 

public class Photo implements Comparable<Photo>{

	//Vous devez écrire un programme qui permet de gérer des photos de vacances. 
	//Une photo est caractérisée par le nom du pays dans lequel cette photo a été prise, 
	//une année de prise de vue, un commentaire, un nom de fichier et la taille du fichier. 
	
	
	//Parametre
	private String pays;
	private int annee;
	private String commentaire;
	private String nomFichier;
	private double tailleFichier;
	
	//Getters and setters
	public String getPays() {return pays;}
	public void setPays(String pays) {this.pays = pays;}
	public int getAnnee() {return annee;}
	public void setAnnee(int annee) {this.annee = annee;}
	public String getCommentaire() {return commentaire;}
	public void setCommentaire(String commentaire) {this.commentaire = commentaire;}
	public String getNomFichier() {return nomFichier;}
	public void setNomFichier(String nomFichier) {this.nomFichier = nomFichier;}
	public double getTailleFichier() {return tailleFichier;}
	public void setTailleFichier(double tailleFichier) {this.tailleFichier = tailleFichier;}
	
	public Photo(String pays, int annee,String commentaire,String nomFichier) {
			setPays(pays);
			setAnnee(annee);
			setCommentaire(commentaire);
			setNomFichier(nomFichier);
			File file = new File(this.nomFichier);
			if (file.exists()) {
				setTailleFichier(file.length());
			}
	}
	public String toString() {
		String resultat = "Photo[";
		resultat +="pays="+pays;
		resultat +=",annee="+annee;
		resultat +=",commentaire="+commentaire;
		resultat +=",nomFichier="+nomFichier;
		resultat +=",tailleFichier="+tailleFichier+"]";
		return resultat;
	}
	
	@Override
	public int compareTo(Photo photo) {
		if (this.tailleFichier < photo.tailleFichier) 
			return -1;
		else if (this.tailleFichier > photo.tailleFichier) 
			return 1;
		return 0;
	}
	
	
	//--------------------------------------Main-------------------------------------- 
	
	public static void main(String[]args) {
		Photo p1 = new Photo ("Summoner's rift",2010,"LegendaryMalphiteSkin","Malphite.jpg");
		Photo p2 = new Photo ("Summoner's rift",2010,"LegendaryGarenSkin","Garen.jpg");
		System.out.println(p1);
		System.out.println(p2);
		p1.compareTo(p2);
		p2.compareTo(p1);
		System.out.println(p1.compareTo(p2));
		System.out.println(p2.compareTo(p1));
	}
	
}