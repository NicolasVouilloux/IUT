package banquepack;

public class CompteEpargne extends Compte {
	
	//--------------------------
	// ATTRIBUTS
	//--------------------------
	private double tauxInteret ; // Nombre positif
	
	//--------------------------
	// CONSTRUCTEUR
	//--------------------------
	// Définir un constructeur public CompteCourant  
	// avec paramètres (un des paramètres aura le même nom qu’un des attributs)
	CompteEpargne (double s, double ti, Client cl) {
		
		// Appeler le constructeur de la classe mère : Compte
		super (s, cl);
		
		// Initialiser les attributs déclarés au niveau de cette sous-classe
		tauxInteret = ti ; 
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
				
				// QUESTION 16
				solde += montant * tauxInteret;
			}
			else 
				System.out.println ("ATTENTION tentative d’ajout suspecte d’un nouveau montant : compte no " + numero);
		}
	}

	//méthode débiter qui vérifie que le solde 
	// (- le montant) est supérieur 
	// au seuil de découvert autorisé avant de débiter
	public void debiter (double montant) {
		if (montant > 0 && (solde - montant) > 0) {
			solde = solde - montant ;
		}
	}
	
	// QUESTION 11 : affiche les informations sur chaque compte.
	public void afficherInfos() {
		// On appelle la méthode de même nom dans la classe Mere
		// pour afficher les attributs qui y sont déclarés
		super.afficherInfos();

		// Ajouter l'affichage des attributs spécifiques à cette sous classe
		System.out.println ("\t taux interet = " + tauxInteret);		
	}
	
	//--------------------------
	// ACCESSEURS
	//--------------------------
	public double getTauxInteret() {
		return tauxInteret;
	}

	public void setTauxInteret(double tauxInteret) {
		this.tauxInteret = tauxInteret;
	}
}