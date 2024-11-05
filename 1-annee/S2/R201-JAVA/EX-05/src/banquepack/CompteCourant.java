package banquepack;

public class CompteCourant extends Compte {
	
	//--------------------------
	// ATTRIBUTS
	//--------------------------
	private double seuilDecouvert ; // Nombre positif
	
	//--------------------------
	// CONSTRUCTEUR
	//--------------------------
	// Définir un constructeur public CompteCourant  
	// avec paramètres (un des paramètres aura le même nom qu’un des attributs)
	CompteCourant (double s, double sd, Client cl) {
		
		// Appeler le constructeur de la classe mère : Compte
		super (s, cl);
		
		// Initialiser les attributs déclarés au niveau de cette sous-classe
		seuilDecouvert = sd ; 
	}

	//--------------------------
	// METHODES
	//--------------------------
	// QUESTION 4 : Ajouter un test dans la méthode créditer : 
	// si on essaye d’ajouter un montant qui est supérieur 
	// à une constante static final SEUIL_SECURITE 
	// (que vous fixerez à 10000), 
	// afficher un message « ATTENTION tentative d’ajout suspecte d’un nouveau montant : compte no … » et ne modifiez alors pas le solde. 
	// Ce test doit aussi être fait lors de l’initialisation d’un compte.
	public void crediter (double montant) {
		if (montant > 0) {
			if (montant < SEUIL_SECURITE) {
				solde += montant ;
				
				// QUESTION 15
				solde += montant * Banque.getTauxRemuneration();
			}
			else 
				System.out.println ("ATTENTION tentative d’ajout suspecte d’un nouveau montant : compte no " + numero);
		}
	}

	//méthode débiter qui vérifie que le solde 
	// (- le montant) est supérieur 
	// au seuil de découvert autorisé avant de débiter
	public void debiter (double montant) {
		if (montant > 0 && (solde - montant) > -seuilDecouvert) {
			solde = solde - montant ;
		}
	}
	
	// QUESTION 11 : affiche les informations sur chaque compte.
	public void afficherInfos() {
		// On appelle la méthode de même nom dans la classe Mere : Compte
		// pour afficher les attributs qui y sont déclarés
		super.afficherInfos();

		// Ajouter l'affichage des attributs spécifiques à cette sous classe
		System.out.println ("\t seuil découvert autorisé = " + seuilDecouvert);	
	}
	
	//--------------------------
	// ACCESSEURS
	//--------------------------
	public double getSeuilDecouvert() {
		return seuilDecouvert;
	}
	public void setSeuilDecouvert(double seuilDecouvert) {
		this.seuilDecouvert = seuilDecouvert;
	} 
}