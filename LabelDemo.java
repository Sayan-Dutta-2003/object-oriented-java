// 40.	Write a Java program to demonstrate labels.

import java.awt.*;
import java.awt.event.*;

public class LabelDemo extends Frame implements ActionListener {
    // Frame Label and Button Initialised
    private Frame frame;
    private Label label;
    private Button button;
    public int count = 0;

    public LabelDemo()
    {
        // Memory Allocated to frame
        frame = new Frame("AWT Label");

        // Memory Allocated to label
        label = new Label("Check if a Number is Even or Odd");

        // Memory Allocated to button
        button = new Button("Calculate");

        // Register ActionListener
        button.addActionListener(this);

        // Add components to the frame
        frame.add(label, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        // Dimensions of Frame
        frame.setSize(600, 600);
        frame.setVisible(true);

        // Using WindowListener for closing the window
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    // Action Listener checks when
    // Button is Pressed
    @Override public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == button) {
            String str;
            if (count % 2 == 0)
                str = count + " is Even";
            else
                str = count + " is odd";

            label.setText(str);
            count++;
        }
    }
    public static void main(String[] args)
    {
        LabelDemo example = new LabelDemo();
    }
}
