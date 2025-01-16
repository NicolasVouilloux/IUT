package JODES.modeles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Ash Merienne
 */
public abstract class Entite implements Saveable {
	
	private static final long serialVersionUID = 1L;
	protected static int lastNum = 1;
	protected final int idEntite;
	protected String nom;

	// ----------- Constructors -----------
	
	public Entite(String nom) {
		this.idEntite = lastNum++;
		this.nom = nom;
	}

	// ----------- Getters & setters -----------
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdEntite() {
		return idEntite;
	}
	
	// ----------- Methods -----------
	
	protected Field[] getFields() {
		return this.getClass().getDeclaredFields();
	}
	
	public ArrayList<String> getFieldNames() {
		Field[] fields = this.getFields();
	    ArrayList<String> fieldNames = new ArrayList<>();
	    for (Field field : fields)
	      fieldNames.add(field.getName());
	    return fieldNames;
	}
	
	public abstract void menuModification();

	@Override
	public String toString() {
		return "Entite [idEntite=" + idEntite + ", nom=" + nom + "]";
	}
	
	public File createFile() {
		String nomentite = this.nom.toLowerCase().replaceAll("\\s","");
		String nomFichier = "entite-" + nomentite + ".dat";
		File f = new File(nomFichier);
		if (!f.exists()) {
			// Si le fichier favoris.dat n'existe pas 
			System.out.println ("Le fichier " + nomFichier + " n'existe pas !");
		}
		else {
			System.out.println ("Le fichier " + nomFichier + " existe. "
					+ "Génération d'un nom de fichier valide...");
			int i = 1;
			while (f.exists()) {
				nomFichier = "entite-" + nomentite+ i + ".dat";
				f = new File(nomFichier);
				i++;
			}
		}
		return f;
	}
	
	public int saveToDisk() {
		File f = this.createFile();
		FileOutputStream fichier;
		ObjectOutputStream flotObjet;
		try {
			fichier = new FileOutputStream(f.getName());
			flotObjet = new ObjectOutputStream(fichier);
			flotObjet.writeObject(this);
			flotObjet.close();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
		System.out.println ("Sauvegarde du fichier " + f.getName() + " réussie.");
		return 0;
	}

}