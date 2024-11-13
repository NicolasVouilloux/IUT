import java.lang.Math; 

public class SquareSum {
    
    /* Le programme suivant doit renvoyer le nombre de carrés.
     * Vous pourrez ensuite l'améliorer pour afficher la liste des carrés choisis.
     */

    public static int nbCarres (int soldats){
        /* résultat stupide : on fait plein de carrés de 1. A améliorer !*/
    	if (soldats == 0) 
            return 0;
        int racine = (int) Math.sqrt(soldats);
        int megaGroupe= racine * racine;
        int res = 1+nbCarres(soldats-megaGroupe);
        return res;
    }

    public static void main(String... args){
        System.out.printf("Pour %d soldats, vous trouvez %d soldats (le minimum est %d)\n", 21, nbCarres(21), 3);
        System.out.printf("Pour %d soldats, vous trouvez %d soldats (le minimum est %d)\n", 27, nbCarres(27), 3); 
        System.out.printf("Pour %d soldats, vous trouvez %d soldats (le minimum est %d)\n", 33, nbCarres(33), 3);       
    }

}
