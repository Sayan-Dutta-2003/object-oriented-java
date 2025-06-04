// 38.	Write a Java program to display the fonts of a text.

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class FontDisplay extends JFrame {

    public FontDisplay() {
        setTitle("Font Display Demo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new FontPanel());
    }

    static class FontPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            // Set background
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            int y = 50;

            // Display available font families
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            g2d.drawString("Available Font Families:", 20, y);
            y += 30;

            String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
            for (int i = 0; i < Math.min(10, fontNames.length); i++) {
                g2d.drawString((i+1) + ". " + fontNames[i], 40, y);
                y += 20;
            }
            y += 30;

            // Display different font styles
            displayFont(g2d, "Arial", Font.PLAIN, 20, "Plain Arial 20", y);
            y += 30;
            displayFont(g2d, "Arial", Font.BOLD, 20, "Bold Arial 20", y);
            y += 30;
            displayFont(g2d, "Arial", Font.ITALIC, 20, "Italic Arial 20", y);
            y += 30;
            displayFont(g2d, "Arial", Font.BOLD + Font.ITALIC, 20, "Bold+Italic Arial 20", y);
            y += 40;

            // Display different font sizes
            displayFont(g2d, "Times New Roman", Font.PLAIN, 12, "Times New Roman 12", y);
            y += 30;
            displayFont(g2d, "Times New Roman", Font.PLAIN, 18, "Times New Roman 18", y);
            y += 30;
            displayFont(g2d, "Times New Roman", Font.PLAIN, 24, "Times New Roman 24", y);
            y += 40;

            // Display with different colors
            g2d.setFont(new Font("Courier New", Font.PLAIN, 16));
            g2d.setColor(Color.RED);
            g2d.drawString("Red Courier New 16", 20, y);
            y += 30;
            g2d.setColor(Color.BLUE);
            g2d.drawString("Blue Courier New 16", 20, y);
            y += 30;
            g2d.setColor(new Color(0, 128, 0)); // Dark green
            g2d.drawString("Green Courier New 16", 20, y);
            y += 40;

            // Display with text attributes (underline, strikethrough)
            Map<TextAttribute, Object> attributes = new HashMap<>();
            attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            Font underlinedFont = new Font("Verdana", Font.PLAIN, 16).deriveFont(attributes);
            g2d.setFont(underlinedFont);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Underlined Verdana 16", 20, y);
            y += 30;

            attributes.clear();
            attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
            Font strikethroughFont = new Font("Verdana", Font.PLAIN, 16).deriveFont(attributes);
            g2d.setFont(strikethroughFont);
            g2d.drawString("Strikethrough Verdana 16", 20, y);
        }

        private void displayFont(Graphics2D g2d, String fontName, int style, int size, String text, int y) {
            Font font = new Font(fontName, style, size);
            g2d.setFont(font);
            g2d.setColor(Color.BLACK);
            g2d.drawString(text, 20, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FontDisplay().setVisible(true);
        });
    }
}