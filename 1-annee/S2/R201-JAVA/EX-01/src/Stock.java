
public class Stock {
	public static void main(String[] args) {	
			//---------------------------------------
			// Déclarer les constantes
			//---------------------------------------
			final int NB_ARTICLES = 3;
			
			//---------------------------------------
			// Déclarer les tableaux
			//---------------------------------------
			char CodeArticles[];
			double PrixArticles[];
			
			//---------------------------------------
			// Allouer les tableaux avec une taille max définie en constante
			//---------------------------------------
			CodeArticles = new char [NB_ARTICLES];
			PrixArticles = new double [NB_ARTICLES];
			//---------------------------------------
			// Mettre des valeurs dans les cases
			//---------------------------------------
			CodeArticles[0] = 'A';
			CodeArticles[1] = 'B';
			CodeArticles[2] = 'C';
			PrixArticles[0] = 10.5;
			PrixArticles[1] = 2.5;
			PrixArticles[2] = 21.5;
			//---------------------------------------
			// Parcours des deux tableaux avec deux boucles foreach
			//---------------------------------------
			System.out.println("----------------------Boucle For Each-----------------------------");
			for (char code : CodeArticles) {
				System.out.print(code + "\t");
			}
			System.out.println();
			for (double prix : PrixArticles) {
				System.out.print(prix + "\t");
			}
			System.out.println();
			//---------------------------------------
			// Parcours des deux tableaux en parallèle avec une boucle while et un booleen
			//---------------------------------------
			System.out.println("----------------------Boucle while booleen-----------------------------");
			boolean finished = false;
			int i = 0;
			while (!finished) {
				System.out.println(CodeArticles[i]+ "\t" + PrixArticles[i]+ "\t");
				i++;
				finished = (i == CodeArticles.length);
			}
			//---------------------------------------
			// Parcours des deux tableaux en parallèle avec une boucle for “classique” (pas une boucle for each)
			//---------------------------------------
			System.out.println("----------------------Boucle for classique-----------------------------");
			for (int ind = 0; ind < CodeArticles.length;ind++) {
				System.out.println(CodeArticles[ind]+ "\t" + PrixArticles[ind]+ "\t");
			}
	}
}
