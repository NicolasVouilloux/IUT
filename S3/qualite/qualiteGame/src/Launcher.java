import boundary.MainWindow;
import control.Jeu2048;

import javax.swing.SwingUtilities;

public class Launcher implements Runnable{

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Launcher());
	}

	@Override
	public void run() {
		new MainWindow(new Jeu2048());
	}

}
