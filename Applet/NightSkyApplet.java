package Applet;

import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class NightSkyApplet extends Applet {

    public void init() {
        setSize(400, 300);
        setBackground(Color.BLACK);
    }

    public void paint(Graphics g) {
        drawMoon(g);
        drawStars(g, 100);
    }

    // Draw a moon
    private void drawMoon(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillOval(300, 50, 50, 50); // Moon shape
    }

    // Draw stars randomly across the sky
    private void drawStars(Graphics g, int count) {
        g.setColor(Color.WHITE);
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int x = rand.nextInt(getWidth());
            int y = rand.nextInt(getHeight() - 100); // Avoid lower part
            g.fillOval(x, y, 2, 2); // Tiny star
        }
    }
}

