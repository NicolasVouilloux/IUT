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
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entrez le nom de la table à décrire : ");
		String tableName = scanner.nextLine();
		String query = "SELECT * FROM ens2004." + tableName + " WHERE ROWNUM = 1"; 
        try {
            ResultSet rs = exec1Requete(query, co, 1); 
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
			System.out.println("Choisissez parmis les acteurs suivants :");
			PreparedStatement psm = co.prepareStatement("SELECT *\r\n"
					+ "FROM ens2004.Film \r\n"
					+ "NATURAL JOIN ens2004.Acteur \r\n"
					+ "NATURAL JOIN ens2004.Individu\r\n"
					+ "WHERE ens2004.Individu.NomIndividu = ?");
			psm.setString(1,nom);
			ResultSet res = psm.executeQuery();
			while (res.next()) {
				System.out.println(res.getString("TITRE"));
			}
		}finally {
			scanner.close();
		}
		closeConnection(co);   
//		Question N3---------------------------------------------------------------------
		/*
		 * CREATE OR REPLACE FUNCTION nbreFilms1(numActeur NUMBER)RETURN NUMBER  AS
			    nbFilm NUMBER;
			BEGIN
			    SELECT COUNT(*)into nbFilm
			    FROM ens2004.ACTEUR a
			    NATURAL JOIN ens2004.FILM f
			    WHERE a.numindividu = numActeur;
			    RETURN nbFilm;
			END;
			/
		 */
		System.out.println("--------Result Question 3---------");
		co = openConnection(url);
		try {
			System.out.println("Entrez le nom d'un acteur :");
			String nom = scanner.nextLine();
			CallableStatement cst = co.prepareCall("{? =nbreFilms1(?)}");
			String query2= ("SELECT *"
					+ "FROM ens2004.individu i"
					+ "WHERE i.nomindividu ="+nom);
			ResultSet res = exec1Requete(query2,co,0);
			while (res.next()) {
				cst.setString(2,res.getString("NUMINDIVIDU"));
				
			}		
		}finally {
			scanner.close();
		}
		
	};
}