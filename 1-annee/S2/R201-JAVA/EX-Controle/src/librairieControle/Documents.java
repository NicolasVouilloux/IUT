package librairieControle;

/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
*/

public abstract class Documents {
	private static int ID_DOCUMENT = 1;
	protected String titreDocument;
	protected String descriptif;
	
	
	
	public static int getID_DOCUMENT() {return ID_DOCUMENT;}
	public static void setID_DOCUMENT(int iD_DOCUMENT) {ID_DOCUMENT = iD_DOCUMENT;}
	public String getTitreDocument() {return titreDocument;}
	public void setTitreDocument(String titreDocument) {this.titreDocument = titreDocument;}
	public String getDescriptif() {return descriptif;}
	public void setDescriptif(String descriptif) {this.descriptif = descriptif;}
	
	public Documents(String titreDocument, String descriptif) {
		setID_DOCUMENT(ID_DOCUMENT);
		ID_DOCUMENT++;
		setTitreDocument(titreDocument);
		setDescriptif(descriptif);
	}
	
}
