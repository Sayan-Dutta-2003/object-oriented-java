package Applet;

import java.applet.Applet;
import java.awt.Graphics;

public class BannerApplet extends Applet implements Runnable {
    String message = " Welcome to Java Applet Banner ";
    int x = 0;
    Thread t;
    boolean stopFlag;

    public void init() {
        setSize(400, 100); // Set the applet size
        setBackground(java.awt.Color.BLACK);
    }

    public void start() {
        t = new Thread(this);
        stopFlag = false;
        t.start();
    }

    public void run() {
        while (!stopFlag) {
            x -= 5;
            if (x < -message.length() * 10) {
                x = getWidth(); // Reset position to right edge
            }
            repaint();
            try {
                Thread.sleep(100); // Speed of scrolling
            } catch (InterruptedException e) {}
        }
    }

    public void paint(Graphics g) {
        g.setColor(java.awt.Color.GREEN);
        g.drawString(message, x, 50);
    }

    public void stop() {
        stopFlag = true;
        t = null;
    }
}
