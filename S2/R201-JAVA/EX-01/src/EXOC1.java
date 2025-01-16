// le type de passage en paramètre permis en Java est le passage par valeur et non par référence 
public class EXOC1 {
	
	//fonction echange avec le passage en parametre des fonction a echanger
	static void echange (char a,char b) {
		
		//echange des valeurs
		char valeurstemp = 'b';
		b = a;
		a = valeurstemp;
		
		//affichage des valeurs pendant echange
		System.out.println("Pendant \t Valeurs 1 : "+a +" Valeurs 2 : "+ b);		
	}
	//fonction insertion d'une valeur dans la case 0 d'un tableau 
	static void insertion (float d,float [] tabfloat) {
		
		//insertion de la valeurs dans la case 0 du tableau
		tabfloat[0] = d;
		
		//affichage de la case 0 du tableau 
		System.out.println("Pendant \t valeurs du tableau 0 : " +tabfloat[0]);
	}
	
	//fonction insertion d'une valeur dans la case 0 d'un tableau 
	static void modification (float [] tab) {
		
		//insertion de la valeurs dans la case 0 du tableau
		tab = null;
		
		//affichage de la case 0 du tableau 
		System.out.println("Pendant \t valeurs du tableau 0 : " +tab);
	}
	
	//fonction main avec differente question répondue et appelle des differentes fonction
	public static void main(String[] args) {
		
		//Création des valeurs a échanger
		char c1 = 'a';
		char c2 = 'b';
		
		//affichage des valeurs avant l'échange
		System.out.println("------------------------------------");
		System.out.println("Avant \t Valeurs 1 : "+c1 +" Valeurs 2 : "+ c2);
		
		//utilisation fonction échange
		echange(c1,c2);
		
		//affichage des valeurs apres échange
		System.out.println("Apres \t Valeurs 1 : "+c1 +" Valeurs 2 : "+ c2);
		//on a éssayer d'echanger des valeurs passer en parametre mais la fonction de fonctionne pas var le passage est pas valeur et pas par reference
		
		
		//création de 150.7f et du tableau
		System.out.println("------------------------------------");
		float d1 = 150.7f;
		float [] tabfloat = new float [1];
		System.out.println("Avant \t valeurs du tableau 0 : " +tabfloat[0]);
		
		//utilisation fonction insertion
		insertion(d1,tabfloat);
		
		//affichage tabkeau après
		System.out.println("Après \t valeurs du tableau 0 : " +tabfloat[0]);
	
		//création du tableau a rendre avec une adresse null et du tableau
		System.out.println("------------------------------------");
		float [] tableauNull = new float [1];
		System.out.println("Avant \t valeurs du tableau 0 : " +tableauNull);
		
		//appelle de la fonction pour rendre l'adresse null
		modification(tableauNull);
		
		//affichage du tableau apres la modification 
		System.out.println("Après \t valeurs du tableau 0 : " +tableauNull);
	}
}

