// 45. Write a Java program to demonstrate handling a scroll bar.

import java.awt.*;
import java.awt.event.*;

public class ScrollBarDemo {
    public static void main(String[] args) {
        Frame f = new Frame("Scrollbar Example");

        Label l = new Label("ScrollBar");
        l.setBounds(130, 80, 200, 30);
        l.setFont(new Font("Arial", Font.BOLD, 20));
        l.setForeground(Color.GREEN);
        f.add(l);

        Scrollbar s1 = new Scrollbar();  // Vertical by default
        s1.setBounds(280, 140, 40, 175);
        f.add(s1);

        Label l1 = new Label("Vertical Scrollbar");
        l1.setBounds(260, 330, 200, 30);
        f.add(l1);

        Scrollbar s2 = new Scrollbar(Scrollbar.HORIZONTAL);
        s2.setBounds(50, 250, 175, 40);
        f.add(s2);

        Label l2 = new Label("Horizontal Scrollbar");
        l2.setBounds(85, 330, 200, 30);
        f.add(l2);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

        // Add window listener to handle window close
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
    }
}
