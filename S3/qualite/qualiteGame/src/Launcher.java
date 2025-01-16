import javax.swing.SwingUtilities;

public class Launcher implements Runnable{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Launcher());
	}

	@Override
	public void run() {
		
	}

}
