// 32.	Write a Java program to create a digital clock.

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;
    private JLabel dateLabel;
    private String timeFormat = "HH:mm:ss";
    private boolean is24HourFormat = true;

    public DigitalClock() {
        // Set up the frame
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // Create time label
        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Digital-7", Font.BOLD, 60));
        timeLabel.setForeground(Color.BLACK);
        timeLabel.setBackground(Color.WHITE);
        timeLabel.setOpaque(true);

        // Create date label
        dateLabel = new JLabel("", JLabel.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dateLabel.setForeground(Color.BLACK);
        dateLabel.setBackground(Color.WHITE);
        dateLabel.setOpaque(true);

        // Add components to frame
        add(timeLabel, BorderLayout.CENTER);
        add(dateLabel, BorderLayout.SOUTH);

        // Add menu bar for format switching
        JMenuBar menuBar = new JMenuBar();
        JMenu formatMenu = new JMenu("Format");
        JMenuItem toggleFormat = new JMenuItem("Toggle 12/24 Hour");
        toggleFormat.addActionListener(e -> toggleTimeFormat());
        formatMenu.add(toggleFormat);
        menuBar.add(formatMenu);
        setJMenuBar(menuBar);

        // Timer to update clock every second
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start();

        // Initial time update
        updateTime();
    }

    private void updateTime() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timeFormat);
        String time = now.format(timeFormatter);
        timeLabel.setText(time);

        // Update date
        String date = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy"));
        dateLabel.setText(date);
    }

    private void toggleTimeFormat() {
        is24HourFormat = !is24HourFormat;
        timeFormat = is24HourFormat ? "HH:mm:ss" : "h:mm:ss a";
        updateTime();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DigitalClock clock = new DigitalClock();
            clock.setVisible(true);
        });
    }
}