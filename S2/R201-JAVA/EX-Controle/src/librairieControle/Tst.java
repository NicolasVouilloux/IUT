package librairieControle;

public class Tst {
	public void main(String args[]) {
		LivreAudio LA1 = new LivreAudio("a","b","c",8,"aaa");
		LivreAudio LA2 = new LivreAudio("b","a","e",7,"aaa");
		LA1.comparer(LA2);
		
	}
}
