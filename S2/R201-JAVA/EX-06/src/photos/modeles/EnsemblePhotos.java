package photos.modeles;
import java.util.ArrayList;

public interface EnsemblePhotos {
	//methode ajout de pjoto
	public void ajouterPhoto(Photo photo);
	//methode triage de photo
	public void triePhoto();
	//methode rechercher avec un mot clef dans les commentaires une photo 
	public ArrayList<Photo> recherche(String motCle);
	
}
