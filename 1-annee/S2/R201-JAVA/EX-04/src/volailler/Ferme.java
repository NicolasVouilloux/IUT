package volailler;

public class Ferme {

	//----------------------------------------------------
	public static void main(String[] args){
		// Creer et ajouter quelques animaux
		Elevage lesVolailles = new Elevage();

		for    (int i=0; i<15; i++){
			// Parametre du constructeur de Poulet : poids et identifiant 
			lesVolailles.ajouter(new Poulet(0.250,150+i));
		}

		for(int i=0; i<15; i++){
			lesVolailles.ajouter(new Canard(0.250,380+i));
		}

		for (int i=0; i<10; i++){
			lesVolailles.ajouter(new Poulet(0.250,700+i));
		}   	 
		lesVolailles.ajouter(new Canard(0.750,825));

		// Changer le poids de quelques animaux
		// 1er paramètre de changePoids : identifiant
		// 2ème paramètre : nouveau poids
		for (int i=0; i<8; i++){
			lesVolailles.changePoids(155+i,1.3);
			lesVolailles.changePoids(382+i,1.55);
		}

		// Afficher l'etat du volailler
		lesVolailles.ecrire();
		
		System.out.println("liste des animaux a abattre: ");
		System.out.println(lesVolailles.afficherBetesAAbattre());
		
		System.out.println("Valeur des animaux a abattre: ");
		System.out.println(lesVolailles.evaluerBetesAAbattre()); 

		lesVolailles.envoyerALAbattoir(); // Retourne aussi un tableau avec les betes abattues
		lesVolailles.ecrire();

		System.out.println("Valeur des animaux a abattre: ");
		System.out.println(lesVolailles.evaluerBetesAAbattre());
	}
}
