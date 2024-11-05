import java.util.Scanner;
public class AfficherSaisir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bonjour");
		System.out.printf("%.3f\n",Math.PI);
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez un entier n : ");
		int n = sc.nextInt();
		System.out.println("Vous avez saisi : " + n);
		sc.close();
		int rand = (int) (n * Math.random());
		System.out.println("Le nombre aléatoire entre O et " + n + " est : "+ rand);
	}
}
