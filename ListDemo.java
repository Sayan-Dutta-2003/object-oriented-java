// 44.	Write a Java program to demonstrate list.

import java.awt.*;
import java.awt.event.*;

public class ListDemo extends Frame {
    public ListDemo() {
        setTitle("List Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        Label label = new Label("Select an item:");

        List itemList = new List(5, false);  // 5 visible rows, single selection
        itemList.add("Apple");
        itemList.add("Banana");
        itemList.add("Cherry");
        itemList.add("Mango");
        itemList.add("Orange");

        Label resultLabel = new Label("Selected: None");

        itemList.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selected = itemList.getSelectedItem();
                resultLabel.setText("Selected: " + selected);
            }
        });

        add(label);
        add(itemList);
        add(resultLabel);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ListDemo();
    }
}
