package JODES.vues;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DatePicker extends JPanel {

    private final JTextField dayTextField;
    private final JTextField monthTextField;
    private final JTextField yearTextField;
    private LocalDate selectedDate;

    public DatePicker() {
        setLayout(new FlowLayout());

        // Create text fields for day, month, and year
        dayTextField = new JTextField(2);
        monthTextField = new JTextField(2);
        yearTextField = new JTextField(4);

        // Create labels
        JLabel dayLabel = new JLabel("Day:");
        JLabel monthLabel = new JLabel("Month:");
        JLabel yearLabel = new JLabel("Year:");

        // Add components to the panel
        add(dayLabel);
        add(dayTextField);
        add(monthLabel);
        add(monthTextField);
        add(yearLabel);
        add(yearTextField);

        // Create and add the submit button
        JButton submitButton = new JButton("Submit");
        add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int day = Integer.parseInt(dayTextField.getText());
                    int month = Integer.parseInt(monthTextField.getText());
                    int year = Integer.parseInt(yearTextField.getText());

                    // Validate and create the date
                    selectedDate = LocalDate.of(year, month, day);
                    JOptionPane.showMessageDialog(DatePicker.this,
                            "Selected Date: " + selectedDate);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DatePicker.this,
                            "Invalid date. Please enter a valid day, month, and year.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Text Date Picker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DatePicker());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
