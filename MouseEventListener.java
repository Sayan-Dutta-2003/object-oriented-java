// 27.	Write a Java program to implement mouse event listener (click, enter, exited, pressed, release).

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseEventListener extends JFrame implements MouseListener {
    private JLabel statusLabel;
    private JTextArea eventLog;
    private int clickCount = 0;

    public MouseEventListener() {
        // Set up the frame
        setTitle("Mouse Event Listener");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        statusLabel = new JLabel("Mouse status: Waiting for events...", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statusLabel.setOpaque(true);
        statusLabel.setBackground(Color.LIGHT_GRAY);

        eventLog = new JTextArea();
        eventLog.setEditable(false);
        eventLog.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(eventLog);

        // Add components to frame
        add(statusLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add mouse listener to the frame
        addMouseListener(this);

        // Add mouse listener to the text area as well
        eventLog.addMouseListener(this);

        // Display instructions
        eventLog.append("Mouse Event Listener Program\n");
        eventLog.append("----------------------------\n");
        eventLog.append("Interact with mouse in this window to see events.\n");
        eventLog.append("Supported events: click, enter, exit, press, release\n\n");
    }

    // Implement MouseListener methods
    @Override
    public void mouseClicked(MouseEvent e) {
        clickCount++;
        String message = "Mouse Clicked at (" + e.getX() + ", " + e.getY() + ")";
        statusLabel.setText(message + " - Total clicks: " + clickCount);
        eventLog.append(message + "\n");
        eventLog.append("Click count: " + e.getClickCount() + "\n");
        eventLog.append("Button: " + getMouseButtonText(e.getButton()) + "\n");
        eventLog.append("Modifiers: " + KeyEvent.getKeyModifiersText(e.getModifiersEx()) + "\n\n");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        statusLabel.setText("Mouse Entered component");
        statusLabel.setBackground(Color.GREEN);
        eventLog.append("Mouse Entered component at (" + e.getX() + ", " + e.getY() + ")\n\n");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        statusLabel.setText("Mouse Exited component");
        statusLabel.setBackground(Color.RED);
        eventLog.append("Mouse Exited component at (" + e.getX() + ", " + e.getY() + ")\n\n");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        statusLabel.setText("Mouse Pressed at (" + e.getX() + ", " + e.getY() + ")");
        eventLog.append("Mouse Pressed at (" + e.getX() + ", " + e.getY() + ")\n");
        eventLog.append("Button: " + getMouseButtonText(e.getButton()) + "\n\n");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        statusLabel.setText("Mouse Released at (" + e.getX() + ", " + e.getY() + ")");
        eventLog.append("Mouse Released at (" + e.getX() + ", " + e.getY() + ")\n");
        eventLog.append("Button: " + getMouseButtonText(e.getButton()) + "\n\n");
    }

    // Helper method to get mouse button text
    private String getMouseButtonText(int button) {
        switch (button) {
            case MouseEvent.BUTTON1: return "Left Button";
            case MouseEvent.BUTTON2: return "Middle Button";
            case MouseEvent.BUTTON3: return "Right Button";
            default: return "Unknown Button";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MouseEventListener listener = new MouseEventListener();
            listener.setVisible(true);
        });
    }
}