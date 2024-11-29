import java.sql.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
public class JDBCp2 {
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
	public static ResultSet requeteEx (String requete, Connection co, int type){
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
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entrez le nom de la table à décrire : ");
		String tableName = scanner.nextLine();
		String query = "SELECT * FROM ens2004." + tableName + " WHERE ROWNUM = 1"; 
        try {
            ResultSet rs = requeteEx(query, co, 1); 
            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCount = rsMeta.getColumnCount();

            System.out.println("Name\t\tNull?\t\tType");
            System.out.println("------------------------------");

            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsMeta.getColumnName(i);
                String columnType = rsMeta.getColumnTypeName(i);
                int columnSize = rsMeta.getColumnDisplaySize(i);
                String isNullable = rsMeta.isNullable(i) == ResultSetMetaData.columnNullable ? "" : "NOT NULL";

                System.out.printf("%-20s %-10s %s(%d)%n", columnName, isNullable, columnType, columnSize);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la description de la table : " + tableName);
            e.printStackTrace();
        }
        closeConnection(co);
//		Question N2---------------------------------------------------------------------
        System.out.println("--------Result Question 2 Prepare statement---------");
		co = openConnection(url);
		try {
			System.out.println("Entrez le nom d'un acteur :");
			String nom = scanner.nextLine();
			// Prepared statement to get all movies
			PreparedStatement psm = co.prepareStatement("SELECT *\r\n"
					+ "FROM ens2004.Film \r\n"
					+ "NATURAL JOIN ens2004.Acteur \r\n"
					+ "WHERE ens2004.Acteur.NumIndividu = ?");
			//result to get all the actor of the same name
			String requete="SELECT * \n"
					+ "FROM ens2004.individu \n"
					+ "WHERE nomindividu = '%s'";
			requete = String.format(requete, nom);
			
			ResultSet prenom = requeteEx(requete,co,0);
			prenom = requeteEx(requete,co,0);
			while (prenom.next()) {
				System.out.println(" ACTEUR : "+ prenom.getString("PRENOMINDIVIDU")+" "+prenom.getString("NOMINDIVIDU")+"\n");
				String numIndividu = prenom.getString("NUMINDIVIDU");
				psm.setString(1,numIndividu);
				ResultSet listeFilm = psm.executeQuery();
				while(listeFilm.next()) {
					System.out.println(listeFilm.getString("TITRE"));
				}
			}
		}catch (SQLException e) {
            System.out.println("Erreur");
        }
		closeConnection(co);   
		
		System.out.println("--------Result Question 3---------");
		co = openConnection(url);
		try {
			System.out.println("Entrez le nom d'un acteur :");
			String nom = scanner.nextLine();	
			
            String requeteQ3 = "SELECT * FROM ens2004.individu WHERE nomindividu = '" + nom + "'";
			CallableStatement cst = co.prepareCall("{? = call nbreFilms1(?)}");
			cst.registerOutParameter(1, java.sql.Types.DECIMAL);
			
			ResultSet res = requeteEx(requeteQ3,co,0);
			while (res.next()) {
				cst.setString(2,res.getString("NUMINDIVIDU"));
				cst.execute();
				int nbFilm = cst.getInt(1);
				System.out.println("Acteur : "+res.getString("NOMINDIVIDU") +" "+res.getString("PRENOMINDIVIDU")+ " a realiser "+nbFilm+" Films");
			}		
		}catch (SQLException e) {
            System.out.println("Erreur");
        }
		closeConnection(co); 
		
		System.out.println("--------Result Question 4---------");
		co = openConnection(url);
		try {
			System.out.println("Entrez le nom d'un real :");
			String nom = scanner.nextLine();	
			CallableStatement cst = co.prepareCall("{? = call nbreFilms2(?)}");
			cst.registerOutParameter(1, java.sql.Types.DECIMAL);
			cst.setString(2,nom);
			cst.execute();
			int nbFilm = cst.getInt(1);
			System.out.println("Realisateur : "+nom + " a realiser "+nbFilm+" Films");
		}catch (SQLException e) {
            System.out.println("Erreur");
        }
		closeConnection(co); 
		
	};
}