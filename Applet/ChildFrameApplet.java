package Applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ChildFrameApplet extends Applet implements ActionListener {
    Button openFrameButton;

    public void init() {
        openFrameButton = new Button("Open Child Frame");
        add(openFrameButton);
        openFrameButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        new ChildFrame("Child Frame Window");
    }
}

class ChildFrame extends Frame {
    ChildFrame(String title) {
        super(title);
        setSize(300, 150);
        setLayout(new FlowLayout());
        Label label = new Label("This is a child frame window.");
        add(label);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
}

