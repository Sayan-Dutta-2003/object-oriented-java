// 47.	Write a Java program to demonstrate menu bar.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBarDemo extends JFrame {

    public MenuBarDemo() {
        setTitle("Menu Bar Demonstration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create File menu
        JMenu fileMenu = new JMenu("File");

        // Create menu items for File menu
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add action listeners
        exitItem.addActionListener(e -> System.exit(0));

        // Add items to File menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Adds a separator line
        fileMenu.add(exitItem);

        // Create Edit menu
        JMenu editMenu = new JMenu("Edit");

        // Create menu items for Edit menu
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        // Add items to Edit menu
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Create Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);

        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        // Set the menu bar for this frame
        setJMenuBar(menuBar);

        // Create a label to display menu selections
        JLabel messageLabel = new JLabel("Select a menu item", JLabel.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(messageLabel, BorderLayout.CENTER);

        // Create a common action listener for menu items
        ActionListener menuAction = e -> {
            JMenuItem source = (JMenuItem) e.getSource();
            messageLabel.setText("Selected: " + source.getText());
        };

        // Add action listener to all menu items
        newItem.addActionListener(menuAction);
        openItem.addActionListener(menuAction);
        saveItem.addActionListener(menuAction);
        cutItem.addActionListener(menuAction);
        copyItem.addActionListener(menuAction);
        pasteItem.addActionListener(menuAction);
        aboutItem.addActionListener(menuAction);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuBarDemo demo = new MenuBarDemo();
            demo.setVisible(true);
        });
    }
}