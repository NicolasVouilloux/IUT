package Table;

public class Magasin {
	
	final int NB_MAX ;
	String nomMagasin ;
	Table tableauDeTables[];
	int nbTables;
	
	//constructeur d'un magasin avec nom de magasin et nombre max de table du magasin en parametre
	Magasin(String nomMagasin,int nbMax){
		this.NB_MAX = nbMax;
		this.nomMagasin = nomMagasin;
		this.nbTables = 0;
		this.tableauDeTables = new Table[NB_MAX];
	}
	
	//fonction qui permet de rajouter une table passer en parametre
	public void add(Table t) {
		if (this.nbTables<this.NB_MAX )
			this.tableauDeTables[nbTables] = t;
			this.nbTables++;
	}
	
	// fonction qui retourne la valeur du stock du magasin
	public float getValeurStock() {
		float valeurStock = 0f;
		for ( int i=0; i<nbTables;i++) {
			valeurStock += this.tableauDeTables[i].prix ;
		}
		return valeurStock;
	}
	

	//fonction afficher magasin qui permet de donner les informations du magasin 
	// le nom , le nb max , le nombre de table , la valeur de stock, les tables presente
	public void afficherMagasin() {
		System.out.println("Le nom de votre magasin est : "+ this.nomMagasin+ " ;");
		System.out.println("Le nombre de table max de votre magasin est : "+ this.NB_MAX+ " ;");
		System.out.println("Le nombre de table présente dans le magasin est : "+ this.nbTables+ " ;");
		System.out.println("La valeur de stock est de : "+ this.getValeurStock() +  " ;");
		System.out.println("les tables présentes sont :");
		for ( int i=0; i<this.nbTables;i++) {
			this.tableauDeTables[i].afficherTable();
		}
	}
	
	//fonction main----------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		//Creation des table a rajouter dans le magasin 
		Table t1 = new Table (4,"Marron",53.89f);
		Table t2 = new Table (3,"Blanc",28.79f);
		Table t3 = new Table (2,"Vert",85.19f);
		Table t4 = new Table (6,"Rouge",64.69f);
		Table t5 = new Table (8,"Noir",95.09f);
		Table t6 = new Table (1,"Gris",34.19f);
		Table t7 = new Table (3,"Bleue",37.39f);
		Table t8 = new Table (7,"DoubleMix",27.19f);
		Table t9 = new Table (3,"ChevreFeuille",65.19f);
		Table t10 = new Table (4,"Rgb",30.99f);
		
		//Creation des magasin
		Magasin m1 = new Magasin ("ikeaEvry",10);
		Magasin m2 = new Magasin ("ikea",5);
		
		//affichage des magasin avant ajout des tables
		
		System.out.println("-------------------------Affichage magasin avant remplissage--------------------------------");
		System.out.println ();
		m1.afficherMagasin();
		System.out.println ();
		m2.afficherMagasin();
		System.out.println ();
		
		//rajout des tables dans le magasin
		m1.add(t1);
		m1.add(t2);
		m1.add(t3);
		m1.add(t4);
		m1.add(t5);
		m1.add(t6);
		m1.add(t7);
		m1.add(t8);
		m1.add(t9);
		m1.add(t10);

		m2.add(t1);
		m2.add(t2);
		m2.add(t3);
		m2.add(t4);
		m2.add(t4);
		
		
		//affichage des magasin apres ajout des tables
		System.out.println("-------------------------Affichage magasin apres remplissage--------------------------------");
		System.out.println ();
		m1.afficherMagasin();
		System.out.println ();
		m2.afficherMagasin();
		System.out.println ();
	}

}