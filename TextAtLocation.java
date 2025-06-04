// 39.	Write a Java program to display a text in a specific location on window.

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class TextAtLocation extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        String message = "Hello, this is my custom text!";
        int x = 100;  // x-coordinate
        int y = 150;  // y-coordinate
        g.drawString(message, x, y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Text Example");
        TextAtLocation panel = new TextAtLocation();

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setVisible(true);
    }
}
