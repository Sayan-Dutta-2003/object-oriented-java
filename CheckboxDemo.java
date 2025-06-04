// 42.	Write a Java program to demonstrate checkbox.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckboxDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Radio Button Demo");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel label = new JLabel("Select your option:");

        JRadioButton radio1 = new JRadioButton("Option 1");
        JRadioButton radio2 = new JRadioButton("Option 2");
        JRadioButton radio3 = new JRadioButton("Option 3");

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);

        JLabel resultLabel = new JLabel("Selected: None");

        // Add action listeners
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radio1.isSelected()) {
                    resultLabel.setText("Selected: Option 1");
                } else if (radio2.isSelected()) {
                    resultLabel.setText("Selected: Option 2");
                } else if (radio3.isSelected()) {
                    resultLabel.setText("Selected: Option 3");
                }
            }
        };

        radio1.addActionListener(listener);
        radio2.addActionListener(listener);
        radio3.addActionListener(listener);

        panel.add(label);
        panel.add(radio1);
        panel.add(radio2);
        panel.add(radio3);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
