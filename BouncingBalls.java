// 31.	Write a Java program to bounce more than one ball.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class BouncingBalls extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private ArrayList<Ball> balls = new ArrayList<>();
    private Random random = new Random();

    public BouncingBalls() {
        // Create 10 random balls
        for (int i = 0; i < 10; i++) {
            balls.add(createRandomBall());
        }

        // Animation timer
        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBalls();
                repaint();
            }
        });
        timer.start();

        // Add mouse listener to create new balls on click
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                balls.add(new Ball(e.getX(), e.getY(),
                        random.nextInt(30) + 10,
                        getRandomColor(),
                        random.nextInt(10) - 5,
                        random.nextInt(10) - 5));
            }
        });
    }

    private Ball createRandomBall() {
        int size = random.nextInt(30) + 20;
        return new Ball(
                random.nextInt(WIDTH - size),
                random.nextInt(HEIGHT - size),
                size,
                getRandomColor(),
                random.nextInt(10) - 5,
                random.nextInt(10) - 5);
    }

    private Color getRandomColor() {
        return new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
    }

    private void updateBalls() {
        for (Ball ball : balls) {
            ball.move();

            // Wall collision detection
            if (ball.x < 0 || ball.x > WIDTH - ball.size) {
                ball.dx = -ball.dx;
            }
            if (ball.y < 0 || ball.y > HEIGHT - ball.size) {
                ball.dy = -ball.dy;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            ball.draw(g);
        }
    }

    private class Ball {
        int x, y;       // Position
        int size;       // Diameter
        Color color;     // Color
        int dx, dy;     // Velocity

        public Ball(int x, int y, int size, Color color, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
            this.dx = dx;
            this.dy = dy;
        }

        public void move() {
            x += dx;
            y += dy;
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, size, size);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, size, size);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.add(new BouncingBalls());
        frame.setVisible(true);
    }
}