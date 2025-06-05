import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;

public class TextAtLocation extends JPanel {

    private final String message = "Hello, this is my custom text!";
    private final int x = 100; // x-coordinate
    private final int y = 150; // y-coordinate

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the main message
        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
        g.drawString(message, x, y);

        // Draw the coordinates just below the message
        g.setFont(new Font("SansSerif", Font.ITALIC, 12));
        g.drawString("x = " + x + ", y = " + y, x, y + 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Text at Specific Location");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(new TextAtLocation());
        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }
}
