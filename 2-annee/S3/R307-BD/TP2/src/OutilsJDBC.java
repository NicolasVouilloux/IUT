import java.sql.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
public class OutilsJDBC {
	public static Connection openConnection (String url) {
		Connection co=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			co= DriverManager.getConnection(url);
		}
		catch (ClassNotFoundException e){
			System.out.println("il manque le driver oracle");
			System.exit(1);
		}
		catch (SQLException e) {
			System.out.println("impossible de se connecter à l'url : "+url);
			System.exit(1);
		}
		return co;
	}
	public static ResultSet exec1Requete (String requete, Connection co, int type){
		ResultSet res=null;
		try {
			Statement st;
			if (type==0){
				st=co.createStatement();}
			else {
				st=co.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			};
			res= st.executeQuery(requete);
		}
		catch (SQLException e){
			System.out.println("Problème lors de l'exécution de la requete : "+requete);
		};
		return res;
	}
	public static void closeConnection(Connection co){
		try {
			co.close();
			System.out.println("Connexion fermée!");
		}
		catch (SQLException e) {
			System.out.println("Impossible de fermer la connexion");
		}
	}
	public static void main(String[] args) throws SQLException{
		String url="jdbc:oracle:thin:nvouill/20040609@oracle.iut-orsay.fr:1521:etudom";
		Connection co = openConnection(url);
		
//		Question N1---------------------------------------------------------------------
		System.out.println("--------Result Question 1---------");
		String requete ="SELECT * "
				+ "FROM ens2004.Film F";
		ResultSet res = exec1Requete(requete,co,0);
		int i=0;
		while (res.next() && i<10){
			System.out.println(res.getString("TITRE"));
			i++;
		}
		closeConnection(co);
//		Question N2---------------------------------------------------------------------
		System.out.println("--------Result Question 2---------");
		co = openConnection(url);
		requete="SELECT *"
				+ "FROM ens2004.individu I\r\n";
		res = exec1Requete(requete,co,0);
		while (res.next()) {
			if ((res.getString("NOMINDIVIDU")).equals("FONDA")){
				System.out.println("Num : "+res.getString("NUMINDIVIDU")+"\n"+"Nom : "+res.getString("NOMINDIVIDU")+"\n"+"Prenom : "+res.getString("PRENOMINDIVIDU"));
				System.out.println("-------------");
			}
		}
		closeConnection(co);
//		Question N3---------------------------------------------------------------------
		System.out.println("--------Result Question 3---------");
		co = openConnection(url);
		requete="SELECT *"
				+ "FROM location I\r\n";
		res = exec1Requete(requete,co,0);
		while (res.next()) {
			if ((res.getString("DATEEMPRUNT")).equals("2024-09-25 00:00:00")){
				System.out.println("Date Emprunt : "+res.getString("DATEEMPRUNT"));
				System.out.println("-------------");
			}
		}
		closeConnection(co);
//		Question N4---------------------------------------------------------------------
		System.out.println("--------Result Question 4---------");
		co = openConnection(url);
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Entrez le nom d'un acteur :");
			String nom = scanner.nextLine();
			System.out.println("Choisissez parmis les acteurs suivants :");
			requete="SELECT *"
					+ "FROM ens2004.individu I\r\n";
			res = exec1Requete(requete,co,0);
			int numChoice = 1;
			ArrayList<Integer> idNumInd = new ArrayList<Integer>();
			while (res.next()) {
				if ((res.getString("NOMINDIVIDU")).equals(nom)){
					idNumInd.add(res.getInt("NUMINDIVIDU"));
					System.out.println(numChoice+")"+" "+res.getString("PRENOMINDIVIDU")+" "+res.getString("NOMINDIVIDU"));
					System.out.println("-------------");
					numChoice++;
				}
			}
			System.out.println("Votre choix :");
			int nbFilm= scanner.nextInt();
			requete = "SELECT * "
					+ "FROM ens2004.Film f "
					+ "NATURAL JOIN ens2004.Acteur a "
					+ "WHERE a.NUMINDIVIDU ="+nbFilm;
			res = exec1Requete(requete,co,0);
			numChoice=1;
			ArrayList<Integer> idNumFilm= new ArrayList<Integer>();
			while (res.next()) {
				idNumFilm.add(res.getInt("NUMFILM"));
				System.out.println(numChoice+")"+" "+res.getString("TITRE"));
				System.out.println("-------------");
				numChoice++;
			}
			System.out.println("Votre choix :");
			int statFilm= scanner.nextInt();
			requete = "SELECT * "
					+ "FROM ens2004.Exemplaire e "
					+ "WHERE e.NumFilm ="+statFilm;
			res = exec1Requete(requete,co,0);
			while (res.next()) {
				System.out.println(res.getInt("NUMEXEMPLAIRE"));
				System.out.println("-------------");
			}
		}finally {
			scanner.close();
		}
		closeConnection(co);
	};
}