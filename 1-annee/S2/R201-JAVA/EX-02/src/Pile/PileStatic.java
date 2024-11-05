package Pile;

public class PileStatic {

	static int pile[];
	static int nbValeurs = 0;
	static int NB_MAX = 10;

	public static void empiler (int i) {
		if (nbValeurs < NB_MAX) {
			pile[nbValeurs]= i;
			nbValeurs++;
		}
		if(nbValeurs <= NB_MAX)
			System.out.println("Valeur Empiler");
		else 
			System.out.println("Pile Pleine");
	}

	public static void afficherSommet () {
		if (nbValeurs>0)
			System.out.println(pile[nbValeurs-1]);
	}
	
	public static void empilerDeuxInt (int i, int j) {
		if (nbValeurs < NB_MAX) {
			pile[nbValeurs]= i;
			nbValeurs++;
			System.out.println("Valeur  n°1 Empiler");
		}
		else
			System.out.println("Pile Pleine");
		
		if (nbValeurs < NB_MAX) {
			pile[nbValeurs]= j;
			nbValeurs++;
			System.out.println("Valeur n°2 Empiler");
		}
		else 
			System.out.println("Pile Pleine");
		
	}
	
	public static void depiler() {
		if (nbValeurs>0)
			nbValeurs--;
	}
	
	public static void main(String[] args) {
		pile = new int[NB_MAX];
		
		empiler(1);
		afficherSommet();
		
		empilerDeuxInt(2,3);
		empilerDeuxInt(4,5);
		empilerDeuxInt(6,7);
		empilerDeuxInt(8,9);
		empilerDeuxInt(10,11);
		afficherSommet();
		
		depiler();
		depiler();
		afficherSommet();
	
	}
}
