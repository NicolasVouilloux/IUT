package librairieControle;

public class LivreAudio extends Livre implements Comparable{

	private int notes;
	private String urlVideo;

	
	
	public int getNotes() {return notes;}
	public void setNotes(int notes) {
		if (notes >20 | notes <0)
			System.out.println("l'implementationd e la note :"+notes+" est impossible ");
		else
			this.notes = notes;
	}
	public String getUrlVideo() {return urlVideo;}
	public void setUrlVideo(String urlVideo) {this.urlVideo = urlVideo;}
	
	public void estDifficile() {
		// TODO vérification dans le String si Difficile existe
		
	}
	
	
	public LivreAudio(String titreDocument, String descriptif,String auteur,int notes,String urlVideo) {
		super(titreDocument,descriptif,auteur);
		setNotes(notes);
		setUrlVideo(urlVideo);
		estDifficile();
	}
	@Override
	public void comparer(LivreAudio livreAudio) {
		if (this.notes > livreAudio.notes)
			System.out.println("Le livre audio :"+this.getTitreDocument()+"est superieur à :"+livreAudio.getTitreDocument());
	}
}
