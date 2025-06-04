// 37.	Write a Java program to create different shapes.

import javax.swing.*;
import java.awt.*;

public class ShapeDrawing extends JFrame {

    public ShapeDrawing() {
        setTitle("Basic Shapes Drawing");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new ShapesPanel());
    }

    static class ShapesPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Set background
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Draw rectangle
            g2d.setColor(Color.RED);
            g2d.fillRect(50, 50, 100, 60);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Rectangle", 60, 40);

            // Draw square
            g2d.setColor(Color.BLUE);
            g2d.fillRect(200, 50, 80, 80);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Square", 210, 40);

            // Draw circle
            g2d.setColor(Color.GREEN);
            g2d.fillOval(350, 50, 80, 80);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Circle", 370, 40);

            // Draw triangle
            g2d.setColor(Color.ORANGE);
            int[] xTriangle = {100, 50, 150};
            int[] yTriangle = {200, 300, 300};
            g2d.fillPolygon(xTriangle, yTriangle, 3);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Triangle", 70, 190);

            // Draw pentagon
            g2d.setColor(Color.MAGENTA);
            int centerX = 300;
            int centerY = 250;
            int radius = 70;

            int[] xPentagon = new int[5];
            int[] yPentagon = new int[5];

            for (int i = 0; i < 5; i++) {
                double angle = Math.toRadians(-90 + i * 72);  // start at top (-90°), step 72° each
                xPentagon[i] = centerX + (int)(radius * Math.cos(angle));
                yPentagon[i] = centerY + (int)(radius * Math.sin(angle));
            }

            g2d.fillPolygon(xPentagon, yPentagon, 5);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Pentagon", 275, 175);

            // Draw hexagon
            g2d.setColor(Color.CYAN);
            int[] xHexagon = {450, 500, 500, 450, 400, 400};
            int[] yHexagon = {150, 200, 250, 300, 250, 200};
            g2d.fillPolygon(xHexagon, yHexagon, 6);
            g2d.setColor(Color.BLACK);
            g2d.drawString("Hexagon", 430, 145);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ShapeDrawing().setVisible(true);
        });
    }
}