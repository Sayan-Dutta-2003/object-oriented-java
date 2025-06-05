// 34.	Write a Java program to create India’s flag.

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class IndianFlag extends JFrame {

    public IndianFlag() {
        setTitle("Indian National Flag");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new FlagPanel());
    }

    static class FlagPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw background (sky)
            GradientPaint skyGradient = new GradientPaint(0, 0, new Color(135, 206, 235),
                    0, getHeight(), new Color(176, 226, 255));
            g2d.setPaint(skyGradient);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            // Draw flag pole
            drawFlagPole(g2d);

            // Draw the flag
            drawIndianFlag(g2d);
        }

        private void drawFlagPole(Graphics2D g2d) {
            // Draw pole
            g2d.setColor(new Color(101, 67, 33));
            g2d.fillRect(100, 50, 10, 300);

            // Draw pole top
            g2d.setColor(new Color(218, 165, 32));
            g2d.fillOval(95, 45, 20, 20);

            // Draw pole base
            g2d.setColor(new Color(139, 69, 19));
            g2d.fillRect(90, 350, 30, 20);
        }

        private void drawIndianFlag(Graphics2D g2d) {
            int flagX = 110;
            int flagY = 70;
            int flagWidth = 300;
            int flagHeight = 200;

            // Draw flag border
            g2d.setColor(Color.BLACK);
            g2d.drawRect(flagX, flagY, flagWidth, flagHeight);

            // Draw saffron stripe (top)
            g2d.setColor(new Color(255, 128, 0));
            g2d.fillRect(flagX, flagY, flagWidth, flagHeight / 3);

            // Draw white stripe (middle)
            g2d.setColor(Color.WHITE);
            g2d.fillRect(flagX, flagY + flagHeight / 3, flagWidth, flagHeight / 3);

            // Draw green stripe (bottom)
            g2d.setColor(new Color(0, 128, 0));
            g2d.fillRect(flagX, flagY + 2 * flagHeight / 3, flagWidth, flagHeight / 3);

            // Calculate center of the Ashoka Chakra
            int whiteBandHeight = flagHeight / 3;
            int centerY = flagY + flagHeight / 3 + whiteBandHeight / 2;

            // Draw Ashoka Chakra (wheel)
            drawAshokaChakra(g2d, flagX + flagWidth / 2, centerY, whiteBandHeight);
        }

        private void drawAshokaChakra(Graphics2D g2d, int centerX, int centerY, int whiteBandHeight) {
            int chakraDiameter = (int) (whiteBandHeight * 0.9); // Diameter of the wheel
            int outerRadius = chakraDiameter / 2;

            // Draw blue circle
            g2d.setColor(new Color(0, 0, 128));
            g2d.setStroke(new BasicStroke(2));
            g2d.draw(new Ellipse2D.Double(centerX - outerRadius, centerY - outerRadius,
                    chakraDiameter, chakraDiameter));

            // Draw 24 spokes (all connected at the center)
            int spokes = 24;
            double angleIncrement = 360.0 / spokes;

            for (int i = 0; i < spokes; i++) {
                double angle = Math.toRadians(i * angleIncrement - 90); // -90 to start at top

                // Calculate spoke endpoint on outer circle
                int x2 = centerX + (int) (outerRadius * Math.cos(angle));
                int y2 = centerY + (int) (outerRadius * Math.sin(angle));

                // Draw line from center to outer circle
                g2d.drawLine(centerX, centerY, x2, y2);
            }

            // Draw the small inner circle
            g2d.fill(new Ellipse2D.Double(centerX - 4, centerY - 4, 8, 8));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new IndianFlag().setVisible(true);
        });
    }
}