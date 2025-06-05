import javax.swing.*;
import java.awt.*;

public class FontDisplay extends JFrame {
    public FontDisplay() {
        setTitle("Font Display");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
                int y = 40;

                for (int i = 0; i < 5; i++) {
                    g2d.setFont(new Font(fonts[i], Font.PLAIN, 18));
                    g2d.drawString("Sample in " + fonts[i], 20, y);
                    y += 30;
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FontDisplay().setVisible(true));
    }
}
