// 35.	Write a Java program to create Ashok Chakra.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class AshokChakra extends JFrame {

    public AshokChakra() {
        setTitle("Ashok Chakra");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new ChakraPanel());
    }

    static class ChakraPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Set background to white (like the flag's middle stripe)
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Draw the Ashok Chakra
            drawAshokChakra(g2d, getWidth()/2, getHeight()/2, Math.min(getWidth(), getHeight())/2 - 20);
        }

        private void drawAshokChakra(Graphics2D g2d, int centerX, int centerY, int radius) {
            // Draw the navy blue outer circle
            g2d.setColor(new Color(0, 0, 128)); // Navy blue
            g2d.setStroke(new BasicStroke(3));
            g2d.draw(new Ellipse2D.Double(centerX - radius, centerY - radius,
                    radius * 2, radius * 2));

            // Draw the 24 spokes (all connected at the center)
            int spokes = 24;
            double angleIncrement = 2 * Math.PI / spokes; // Angle between spokes in radians

            for (int i = 0; i < spokes; i++) {
                double angle = i * angleIncrement;

                // Calculate endpoint on outer circle
                int x = centerX + (int)(radius * Math.cos(angle));
                int y = centerY + (int)(radius * Math.sin(angle));

                // Draw line from center to outer circle
                g2d.drawLine(centerX, centerY, x, y);
            }

            // Draw the small navy blue circle at center
            g2d.fill(new Ellipse2D.Double(centerX - 5, centerY - 5, 10, 10));

            // Add label
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            String label = "Ashok Chakra (24 Spokes)";
            int labelWidth = g2d.getFontMetrics().stringWidth(label);
            g2d.drawString(label, centerX - labelWidth/2, centerY + radius + 30);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AshokChakra().setVisible(true);
        });
    }
}