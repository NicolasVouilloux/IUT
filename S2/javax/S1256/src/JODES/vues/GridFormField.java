package JODES.vues;
import javax.swing.*;
import java.awt.*;

public class GridFormField extends JPanel {

    protected JComponent input;
    protected JLabel label;
    protected GridLayout grid;

    // ----------- Constructors -----------

    public GridFormField(JComponent input, JLabel label) {
        this.input = input;
        this.label = label;
        this.grid = new GridLayout(1,2);
        this.add(label).setPreferredSize(new Dimension(200, 25));
        this.add(input).setPreferredSize(new Dimension(200, 25));
    }

    // ----------- Getters & setters -----------

    public JComponent getInput() {
        return input;
    }

    public void setInput(JComponent input) {
        this.input = input;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    // ----------- Methods -----------

}
