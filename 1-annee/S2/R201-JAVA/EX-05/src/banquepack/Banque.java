package banquepack;

import java.util.ArrayList;

// QUESTION 6 : Créez une classe Banque dans laquelle 
// vous mettrez un main (). 
// Dans ce main(), déclarez et crééz quelques instances 
// des classes Client et CompteCourant. 
// Initialisez les attributs de ces comptes. 
public class Banque {	

	//--------------------------
	// CONSTANTES STATIC
	//--------------------------
	private static final int NB_MAX_CLIENTS = 100;

	//--------------------------
	// ATTRIBUTS DE CLASSE
	//--------------------------
	private static double tauxRemuneration = 0.01 ; 
	
	//--------------------------
	// ATTRIBUTS D'OJETS
	//--------------------------
	private String nom ; 
	private int nbClients ; 
	private Client [] clients ; 
	
	// On n'a plus qu'un seul tableau de Compte
	private ArrayList<Compte> comptes ; 
	
	//--------------------------
	// CONSTRUCTEUR
	//--------------------------
	Banque (String nom) {
		this.nom = nom ; 
		clients = new Client [NB_MAX_CLIENTS];
		comptes = new ArrayList<Compte>();		
	}

	//--------------------------
	// METHODES
	//--------------------------

	// On simplifie l'ajout qui devient plus général
	// grace au polymorphisme 
	// Cette méthode peut être appelée avec 
	// un paramètre de type CompteCourant
	// ou un paramètre de type CompteEpargne
	void ajouterCompte (Compte c) {
			comptes.add(c);
	}

	// QUESTION 8 : Idem : pouvoir ajouter un client à la banque
	void ajouterClient (Client c) {
		if (nbClients < NB_MAX_CLIENTS) {
			clients [nbClients] = c ; 
			nbClients ++ ; 
		}
	}
	
	// Ecrire une méthode qui parcourt tous les comptes 
	// d’une banque et affiche les informations sur chaque compte. 
	// Est-ce mieux d’écrire une méthode de classe (static) ou une méthode d’objet ?
	// => C'est mieux de définir une méthode d'objet car 
	// on reste dans la Programmation Orientée Objet 
	// (on va pouvoir manipuler plusieurs banques en parallèle)
	void afficherInfosComptes () {
		System.out.println ();
		System.out.println ("COMPTES DE LA BANQUE "+ nom);
		
		// Parcourir tous les comptes de cette banque
		
		for (Compte c : comptes) {			
			// Afficher les informations sur ce compte
			c.afficherInfos (); // Cette méthode est polymorphe !			
		}
	}
	
	// QUESTION 12 : 
	// Ecrire les méthodes qui permettent d’afficher 
	// les informations sur tous les comptes d’un client 
	// spécifié par son nom 
	// (on supposera pour simplifier qu’il n’y a pas d’homonymes) : 
	// numéro du compte et solde. 
	void afficherInfosComptesClient (String nomClient) {
		System.out.println ("Client : " + nomClient);
		
		// Parcourir tous les comptes de cette banque
		for (Compte c : comptes) {			
			// Si on a parcouru tous les comptes, sortir de la méthode
			if (c == null)
				return ; 
			
			// Si le propriétaire de ce compte est le client recherché
			if (	c.getProprietaire() != null && 
					(c.getProprietaire().getNom()).equals(nomClient))	
	
				// Afficher les informations sur ce compte
				c.afficherInfos();
		}
	}
	
	// QUESTION 13 : Ecrire une méthode qui, à partir d’un numéro de compte, 
	// affiche toutes les informations sur le propriétaire de ce compte.  
	void afficherInfosClientCompteNumero (int numeroCompte) {
		System.out.println ();
		System.out.println ("COMPTE "+ numeroCompte);

		// Parcourir tous les comptes de cette banque
		for (Compte c : comptes) {			
			// Si on a parcouru tous les comptes, sortir de la méthode
			if (c == null)
				return ; 		
			// Si ce compte est celui qu'on recherche
			if (c.getNumero() == numeroCompte) 
				if (c.getProprietaire() != null)
					c.getProprietaire().afficherInformations();
		}
	}
	
	//--------------------------
	// MAIN
	//--------------------------
	public static void main (String args []) {
		System.out.println ("Nombre de comptes actuels : " 
				+ CompteCourant.getCptComptes());	

		// QUESTION 6 : déclarez et crééz quelques instances
		// des classes Client et CompteCourant. 
		// Initialisez les attributs de ces comptes. 
		Client cMartin = new Client ("Martin");
		Client cDupont = new Client ("Dupont");
		Client cSmith = new Client ("Smith");

		Compte c1 = new CompteCourant (0, 0, cMartin);
		Compte c2 = new CompteCourant (1000, 0, cMartin);
		Compte c3 = new CompteCourant (0, 500, cDupont);
		Compte c4 = new CompteCourant (0, 1500, cSmith);

		// QUESTION 7 : Essayez de modifier le solde de ces comptes en accédant directement à leurs attributs. 
		//Est-ce possible ? NON car c'est un attribut private de la classe CompteCourant
		// c1.solde = 3000 ; 
		// Si ce n’est pas possible : Est-ce une erreur de compilation ou d’exécution ? ERREUR DE COMPILATION
		// Quel est le message d’erreur ?  "The field CompteCourant.solde is not visible"

		// QUESTION 9 : 
		// Ecrire une méthode main () dans laquelle 
		// vous créez deux banques, des comptes que vous 
		// ajoutez à l’une ou l’autre banque. 
		// Idem pour les clients.
		Banque lbp = new Banque ("La Banque Postale"); 
		lbp.ajouterClient(cMartin);
		lbp.ajouterCompte(c1);
		lbp.ajouterCompte(c2);
		lbp.ajouterClient(cSmith);
		lbp.ajouterCompte(c4);
		c1.setSaBanque(lbp);
		c2.setSaBanque(lbp);
		c4.setSaBanque(lbp);
		lbp.afficherInfosComptes ();
		
		Banque cl = new Banque ("Crédit Lyonnais"); 
		cl.ajouterClient(cDupont);
		cl.ajouterCompte(c3);
		c3.setSaBanque(cl);
		cl.afficherInfosComptes ();
		
		System.out.println ("AFFICHAGE DES INFOS SUR LES COMPTES DE CERTAINS CLIENTS");
		lbp.afficherInfosComptesClient ("Martin");
		cl.afficherInfosComptesClient("Dupont");
		
		// Test question 13
		System.out.println ("AFFICHAGE DU PROPRIETAIRE D'UN COMPTE A PARTIR DU NO DE COMPTE");	
		cl.afficherInfosClientCompteNumero (3);
		
		// QUESTION 14
		System.out.println ("Nombre de comptes actuels : " 
				+ CompteCourant.getCptComptes());
		
		// QUESTION 15
		c1.afficherInfos();
		c1.crediter(100);
		c1.afficherInfos();
		Banque.setTauxRemuneration(0.02);
		c1.crediter(100);
		c1.afficherInfos();
		/* EXECUTION :
		 * Compte 1 : 
	 solde = 0.0
	 seuil découvert autorisé = 0.0
	 Proprietaire : Martin
Compte 1 : 
	 solde = 101.0
	 seuil découvert autorisé = 0.0
	 Proprietaire : Martin
Compte 1 : 
	 solde = 203.0
	 seuil découvert autorisé = 0.0
	 Proprietaire : Martin
		 */
		
		// QUESTION 16
		System.out.println ("Question 16 : comptes épargne");
		CompteEpargne ce = new CompteEpargne(0, 0.03, cSmith);
		lbp.ajouterCompte(ce);
		ce.crediter(100);
		ce.afficherInfos();
		
		// QUESTION 17
		System.out.println ("Question 17 : toString");
		//System.out.println (cSmith);
		// Par défaut cela appelle Object.toString() 
		// et affiche : banque.Client@279f2327
		// cf https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html#toString()
		System.out.println (cSmith);  // Affiche Client : Smith
		System.out.println (lbp);  
		
	}
	
	//--------------------------
	public String toString() {
		String s = "Banque [nom=" + nom + 
				", nbClients=" + nbClients + "\n";
		for (int i = 0; i < nbClients ; i++) 
			s += "\t" + clients[i] + "\n";
		return s ; 
	}

	//--------------------------
	// ACCESSEURS
	//--------------------------
	public static double getTauxRemuneration() {
		return tauxRemuneration;
	}

	public static void setTauxRemuneration(double tauxRemuneration) {
		// Equivalent du "this" mais pour les attributs static : 
		// on préfixe avec le nom de la classe
		Banque.tauxRemuneration = tauxRemuneration;
	}
}