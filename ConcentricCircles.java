// 36.	Write a Java program to create concentric circles in different colours.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class ConcentricCircles extends JFrame {

    public ConcentricCircles() {
        setTitle("Concentric Circles");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new CirclesPanel());
    }

    static class CirclesPanel extends JPanel {
        // Colors for the concentric circles
        private final Color[] colors = {
                Color.RED,
                Color.ORANGE,
                Color.YELLOW,
                Color.GREEN,
                Color.BLUE,
                new Color(75, 0, 130), // INDIGO
                new Color(238, 130, 238)  // VIOLET
        };

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Get center of the panel
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            // Initial radius (will decrease for each circle)
            int radius = Math.min(getWidth(), getHeight()) / 2 - 20;

            // Draw concentric circles
            for (int i = 0; i < colors.length; i++) {
                // Set circle color
                g2d.setColor(colors[i]);

                // Calculate diameter for this circle
                int diameter = radius * 2;

                // Draw filled circle
                g2d.fill(new Ellipse2D.Double(
                        centerX - radius,
                        centerY - radius,
                        diameter,
                        diameter));

                // Draw outline
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(2));
                g2d.draw(new Ellipse2D.Double(
                        centerX - radius,
                        centerY - radius,
                        diameter,
                        diameter));

                // Reduce radius for next circle
                radius -= 30;

                // Stop if radius becomes too small
                if (radius < 10) break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ConcentricCircles().setVisible(true);
        });
    }
}