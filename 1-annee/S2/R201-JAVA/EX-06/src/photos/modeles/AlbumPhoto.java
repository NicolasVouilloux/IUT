package photos.modeles;

import java.util.ArrayList;

public class AlbumPhoto {

	private String nom;
	private ArrayList<Photo> photos;
	
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public ArrayList<Photo> getPhotos() {return photos;}
	public void setPhotos(ArrayList<Photo> photos) {this.photos = photos;}
	
	public AlbumPhoto(String nom) {
		setNom(nom);
		this.photos = new ArrayList<>();
	}

	
}
