import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    private JTextField display;
    private double firstNumber = 0;
    private String operation = "";
    private boolean startNewNumber = true;
    private String secondInput = "";

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        display = new JTextField("0");
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (Character.isDigit(cmd.charAt(0))) {
            if (operation.isEmpty()) {
                // Entering first number
                if (startNewNumber) {
                    display.setText("");
                    startNewNumber = false;
                }
                display.setText(display.getText() + cmd);
            } else {
                // Entering second number
                secondInput += cmd;
                display.setText(firstNumber + " " + operation + " " + secondInput);
            }

        } else if (cmd.equals("C")) {
            display.setText("0");
            firstNumber = 0;
            operation = "";
            secondInput = "";
            startNewNumber = true;

        } else if (cmd.equals("=")) {
            if (!operation.isEmpty() && !secondInput.isEmpty()) {
                double secondNumber = Double.parseDouble(secondInput);
                double result = calculate(firstNumber, secondNumber, operation);
                String fullExpr = display.getText();

                // Show expression first
                display.setText(fullExpr);

                // After 1 second, show result
                Timer timer = new Timer(1000, ev -> display.setText(String.valueOf(result)));
                timer.setRepeats(false);
                timer.start();

                // Reset for next operation
                firstNumber = result;
                operation = "";
                secondInput = "";
                startNewNumber = true;
            }

        } else { // Operators: + - * /
            if (!display.getText().isEmpty()) {
                try {
                    firstNumber = Double.parseDouble(display.getText());
                    operation = cmd;
                    startNewNumber = false;
                } catch (NumberFormatException ignored) {
                }
            }
        }
    }

    private double calculate(double a, double b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> b != 0 ? a / b : 0;
            default -> b;
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SimpleCalculator().setVisible(true));
    }
}
