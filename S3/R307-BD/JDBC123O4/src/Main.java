import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://projets.iut-orsay.fr:3306/prj-nvouill", "prj-nvouill", "J/kPlgkU+A/10sqa");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Vin");
            System.out.println("Connected");
            while(rs.next()){
                System.out.println(rs.getString("MILLESIME"));
            }


            //on appelle les callable statement
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}