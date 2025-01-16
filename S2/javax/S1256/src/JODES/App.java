package JODES;
import javax.swing.*;
import JODES.vues.*;

/**
 * @author Ash Merienne
 */
public class App {
	
	public static void main(String args[])
	{
		JO2024.initialize();

		JFrame app = new HomePageFrame();
		app.setSize(800, 450);
        app.setVisible(true);
	}
	
}
