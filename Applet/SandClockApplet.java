package Applet;

import java.applet.Applet;
import java.awt.*;

public class SandClockApplet extends Applet {

    public void init() {
        setSize(300, 400);
        setBackground(Color.WHITE);
    }

    public void paint(Graphics g) {
        drawSandClock(g);
    }

    private void drawSandClock(Graphics g) {
        // Set outline color
        g.setColor(Color.BLACK);

        // Top triangle (inverted)
        int[] xTop = {50, 150, 250};
        int[] yTop = {50, 200, 50};
        g.drawPolygon(xTop, yTop, 3);

        // Bottom triangle (upright)
        int[] xBottom = {50, 150, 250};
        int[] yBottom = {350, 200, 350};
        g.drawPolygon(xBottom, yBottom, 3);

        // Fill sand in top and bottom
        g.setColor(Color.ORANGE);

        // Sand in the top (inverted triangle partially filled)
        int[] xSandTop = {80, 150, 220};
        int[] ySandTop = {90, 180, 90};
        g.fillPolygon(xSandTop, ySandTop, 3);

        // Sand falling (thin stream)
        g.setColor(Color.YELLOW);
        g.drawLine(150, 180, 150, 220);

        // Sand collected at bottom
        g.setColor(Color.ORANGE);
        int[] xSandBottom = {100, 150, 200};
        int[] ySandBottom = {310, 220, 310};
        g.fillPolygon(xSandBottom, ySandBottom, 3);
    }
}
