package Pile;

public class PileObject {

	int pile[];
	int nbValeurs = 0;
	int NB_MAX = 10;

	PileObject (){
		pile = new int [NB_MAX];
	}
	
	public void empiler (int i) {
		if (this.nbValeurs < NB_MAX) {
			this.pile[nbValeurs]= i;
			this.nbValeurs++;
		}
		if(this.nbValeurs <= NB_MAX)
			System.out.println("Valeur Empiler");
		else 
			System.out.println("Pile Pleine");
	}

	public void afficherSommet () {
		if (this.nbValeurs>0)
			System.out.println(this.pile[nbValeurs-1]);
	}
	
	public void empilerDeuxInt (int i, int j) {
		if (this.nbValeurs < NB_MAX) {
			this.pile[nbValeurs]= i;
			this.nbValeurs++;
			System.out.println("Valeur  n°1 Empiler");
		}
		else
			System.out.println("Pile Pleine");
		
		if (this.nbValeurs < NB_MAX) {
			this.pile[nbValeurs]= j;
			this.nbValeurs++;
			System.out.println("Valeur n°2 Empiler");
		}
		else 
			System.out.println("Pile Pleine");
		
	}
	
	public  void depiler() {
		if (this.nbValeurs>0)
			this.nbValeurs--;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("PileObject");
		PileObject p1= new PileObject();
		
		p1.empiler(1);
		p1.afficherSommet();
		
		p1.empilerDeuxInt(2,3);
		p1.empilerDeuxInt(4,5);
		p1.empilerDeuxInt(6,7);
		p1.empilerDeuxInt(8,9);
		p1.empilerDeuxInt(10,11);
		p1.afficherSommet();
		
		p1.depiler();
		p1.depiler();
		p1.afficherSommet();
	
	}
}
