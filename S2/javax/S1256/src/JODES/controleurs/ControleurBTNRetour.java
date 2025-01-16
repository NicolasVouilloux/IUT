package JODES.controleurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * @author Nicolas Vouilloux
 */
public class ControleurBTNRetour extends Controleur implements ActionListener {
	
	protected RetourVue _vue;
	
	public ControleurBTNRetour(JFrame vue) {
		super(null, vue);
		//Nicolas
		this._vue = (RetourVue) vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		_vue.retour();
	}
}
