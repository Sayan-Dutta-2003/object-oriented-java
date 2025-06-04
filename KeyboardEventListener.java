// 26.	Write a Java program to implement keyboard event listener.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardEventListener extends JFrame implements KeyListener {
    private JLabel label;
    private JTextArea textArea;

    public KeyboardEventListener() {
        // Set up the frame
        setTitle("Keyboard Event Listener");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create components
        label = new JLabel("Press any key...", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add components to frame
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add key listener to the text area
        textArea.addKeyListener(this);

        // Make sure the text area can receive focus
        textArea.setFocusable(true);
        textArea.requestFocusInWindow();
    }

    // Implement KeyListener methods
    @Override
    public void keyPressed(KeyEvent e) {
        String message = "Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode());
        label.setText(message);
        textArea.append(message + "\n");
        textArea.append("Key Code: " + e.getKeyCode() + "\n");
        textArea.append("Modifiers: " + KeyEvent.getKeyModifiersText(e.getModifiersEx()) + "\n\n");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String message = "Key Released: " + KeyEvent.getKeyText(e.getKeyCode());
        label.setText(message);
        textArea.append(message + "\n\n");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        String message = "Key Typed: '" + e.getKeyChar() + "'";
        label.setText(message);
        textArea.append(message + "\n");
        textArea.append("Character: " + e.getKeyChar() + "\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeyboardEventListener listener = new KeyboardEventListener();
            listener.setVisible(true);
        });
    }
}