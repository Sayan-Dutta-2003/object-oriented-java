// 43.	Write a Java program to demonstrate checkbox group.

import java.awt.*;
import java.awt.event.*;

public class CheckboxGroupDemo extends Frame {
    public CheckboxGroupDemo() {
        setTitle("Checkbox Group Demo");
        setSize(400, 200);
        setLayout(new FlowLayout());

        Label label = new Label("Select your gender:");

        CheckboxGroup genderGroup = new CheckboxGroup();
        Checkbox male = new Checkbox("Male", genderGroup, false);
        Checkbox female = new Checkbox("Female", genderGroup, false);
        Checkbox other = new Checkbox("Other", genderGroup, false);

        Label resultLabel = new Label("Selected: None");

        male.addItemListener(e -> resultLabel.setText("Selected: Male"));
        female.addItemListener(e -> resultLabel.setText("Selected: Female"));
        other.addItemListener(e -> resultLabel.setText("Selected: Other"));

        add(label);
        add(male);
        add(female);
        add(other);
        add(resultLabel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckboxGroupDemo();
    }
}
