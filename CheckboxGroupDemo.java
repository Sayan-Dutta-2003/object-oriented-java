import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckboxGroupDemo extends JFrame implements ActionListener {

    JCheckBox option1, option2, option3;
    JButton submitButton;
    JLabel resultLabel;

    public CheckboxGroupDemo() {
        setTitle("Checkbox Group Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create checkboxes
        option1 = new JCheckBox("Option 1");
        option2 = new JCheckBox("Option 2");
        option3 = new JCheckBox("Option 3");

        // Add checkboxes to frame
        add(option1);
        add(option2);
        add(option3);

        // Submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        add(submitButton);

        // Label to display selected checkboxes
        resultLabel = new JLabel("Selected: None");
        add(resultLabel);

        setLocationRelativeTo(null); // Center window
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder selectedOptions = new StringBuilder("Selected: ");

        boolean anySelected = false;
        if (option1.isSelected()) {
            selectedOptions.append("Option 1 ");
            anySelected = true;
        }
        if (option2.isSelected()) {
            selectedOptions.append("Option 2 ");
            anySelected = true;
        }
        if (option3.isSelected()) {
            selectedOptions.append("Option 3 ");
            anySelected = true;
        }

        if (!anySelected) {
            selectedOptions.append("None");
        }

        resultLabel.setText(selectedOptions.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CheckboxGroupDemo().setVisible(true);
        });
    }
}
