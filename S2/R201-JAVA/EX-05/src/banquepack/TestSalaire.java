package banquepack;

public class TestSalaire {

	public static void main (String args []) {
		
		Client bob = new Client ("bob");
		Client karim = new Client ("karim");
		Client fob = new Client ("fob");
		Client shlob = new Client ("shlob");
		
		Compte c1 = new CompteCourant (0, 0, bob);
		Compte c2 = new CompteCourant (1000, 0, karim);
		
		ClientInterne CI1 = new ClientInterne (1000,"bob",c1);
		Employe E1 = new Employe (1000,"karim");
		ClientInterne CI2 = new ClientInterne (1000,"fob",c2);
		Employe E2 = new Employe (1000,"shlob");
		
		E1.verserSalaire();
		E2.verserSalaire();
		CI1.verserSalaire();
		CI2.verserSalaire();
		
		(CI1.getCompte()).afficherInfos();
	}
	
}
