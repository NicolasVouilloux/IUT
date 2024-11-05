package JODES.modeles;
/**
 * @author Ash Merienne
 */
public class DataParser {
    
    /** 
     * @param s
     * @return boolean
     */
    public static boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
        
    public static boolean isSession(Entite e) {
        return e instanceof Session;
    }

    public static boolean isAthlete(Entite e) {
        return e instanceof Athlete;
    }

    public static boolean isPays(Entite e) {
        return e instanceof Pays;
    }

    public static boolean isVille(Entite e) {
        return e instanceof Ville;
    }

    public static boolean isLieu(Entite e) {
        return e instanceof Lieu;
    }

    public static boolean isDiscipline(Entite e) {
        return e instanceof Discipline;
    }

    public static boolean isEpreuve(Entite e) {
        return e instanceof Session;
    }
}
