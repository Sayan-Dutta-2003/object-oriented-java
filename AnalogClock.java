// 33.	Write a Java program to create an analog clock.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AnalogClock extends JPanel {
    private int centerX, centerY;
    private int clockRadius;
    private LocalTime currentTime;
    private Timer timer;
    private boolean showDigitalTime = true;
    private boolean showDate = true;

    public AnalogClock() {
        // Set up the panel
        setPreferredSize(new Dimension(400, 450));
        setBackground(Color.WHITE);

        // Timer to update clock every second
        timer = new Timer(1000, e -> {
            currentTime = LocalTime.now();
            repaint();
        });
        timer.start();

        // Add mouse listener to toggle digital display
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showDigitalTime = !showDigitalTime;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Calculate clock dimensions
        centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        clockRadius = Math.min(centerX, centerY) - 20;

        // Draw clock face
        drawClockFace(g2d);

        // Draw clock hands
        if (currentTime != null) {
            drawClockHands(g2d);
        }

        // Draw digital time and date
        if (showDigitalTime) {
            drawDigitalTime(g2d);
        }
    }

    private void drawClockFace(Graphics2D g2d) {
        // Draw clock border
        g2d.setColor(Color.BLACK);
        g2d.fillOval(centerX - clockRadius, centerY - clockRadius,
                clockRadius * 2, clockRadius * 2);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(centerX - clockRadius + 5, centerY - clockRadius + 5,
                clockRadius * 2 - 10, clockRadius * 2 - 10);

        // Draw hour markers
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians(90 - i * 30);
            int x = centerX + (int) (0.85 * clockRadius * Math.cos(angle));
            int y = centerY - (int) (0.85 * clockRadius * Math.sin(angle));
            g2d.drawString(Integer.toString(i), x - 5, y + 5);
        }

        // Draw minute markers
        g2d.setStroke(new BasicStroke(1f));
        for (int i = 0; i < 60; i++) {
            if (i % 5 != 0) { // Skip hour markers
                double angle = Math.toRadians(90 - i * 6);
                int x1 = centerX + (int) (0.90 * clockRadius * Math.cos(angle));
                int y1 = centerY - (int) (0.90 * clockRadius * Math.sin(angle));
                int x2 = centerX + (int) (0.95 * clockRadius * Math.cos(angle));
                int y2 = centerY - (int) (0.95 * clockRadius * Math.sin(angle));
                g2d.drawLine(x1, y1, x2, y2);
            }
        }
    }

    private void drawClockHands(Graphics2D g2d) {
        int hours = currentTime.getHour() % 12;
        int minutes = currentTime.getMinute();
        int seconds = currentTime.getSecond();

        // Draw hour hand
        double hourAngle = Math.toRadians(90 - (hours * 30 + minutes * 0.5));
        int hourHandLength = (int) (0.5 * clockRadius);
        int hourX = centerX + (int) (hourHandLength * Math.cos(hourAngle));
        int hourY = centerY - (int) (hourHandLength * Math.sin(hourAngle));
        g2d.setStroke(new BasicStroke(6f));
        g2d.setColor(Color.BLUE);
        g2d.drawLine(centerX, centerY, hourX, hourY);

        // Draw minute hand
        double minuteAngle = Math.toRadians(90 - minutes * 6);
        int minuteHandLength = (int) (0.7 * clockRadius);
        int minuteX = centerX + (int) (minuteHandLength * Math.cos(minuteAngle));
        int minuteY = centerY - (int) (minuteHandLength * Math.sin(minuteAngle));
        g2d.setStroke(new BasicStroke(4f));
        g2d.setColor(Color.GREEN);
        g2d.drawLine(centerX, centerY, minuteX, minuteY);

        // Draw second hand
        double secondAngle = Math.toRadians(90 - seconds * 6);
        int secondHandLength = (int) (0.8 * clockRadius);
        int secondX = centerX + (int) (secondHandLength * Math.cos(secondAngle));
        int secondY = centerY - (int) (secondHandLength * Math.sin(secondAngle));
        g2d.setStroke(new BasicStroke(1f));
        g2d.setColor(Color.RED);
        g2d.drawLine(centerX, centerY, secondX, secondY);

        // Draw center cap
        g2d.setColor(Color.BLACK);
        g2d.fillOval(centerX - 8, centerY - 8, 16, 16);
    }

    private void drawDigitalTime(Graphics2D g2d) {
        // Draw digital time
        String time = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        g2d.setFont(new Font("Digital-7", Font.BOLD, 30));
        FontMetrics fm = g2d.getFontMetrics();
        int timeWidth = fm.stringWidth(time);
        g2d.setColor(Color.BLACK);
        g2d.drawString(time, centerX - timeWidth/2, centerY + clockRadius + 40);

        // Draw date if enabled
        if (showDate) {
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy"));
            g2d.setFont(new Font("Arial", Font.PLAIN, 16));
            fm = g2d.getFontMetrics();
            int dateWidth = fm.stringWidth(date);
            g2d.drawString(date, centerX - dateWidth/2, centerY + clockRadius + 70);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Analog Clock");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new AnalogClock());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}