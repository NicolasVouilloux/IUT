package librairieControle;

public interface Empruntable {
	
	public static final int DUREE_MAX_300 = 30;
	public static final int DUREE_MAX_150 = 15;
	public static final int DUREE_MAX = 7;
	public static final int DUREE_MAX_DVD = 10;
	
	void dureeEmprunt();
}
