import java.applet.*;
import java.awt.*;


public class BannerApplet extends Applet implements Runnable {
    private Thread animationThread;
    private int x, y;
    private String bannerText = "Java Applet Banner - Scroll Text! ";
    private boolean stopFlag;

    // Initialize the applet
    public void init() {
        setBackground(Color.black);
        setForeground(Color.cyan);
        x = getWidth();
        y = getHeight()/2;
    }

    // Start the animation thread
    public void start() {
        animationThread = new Thread(this);
        stopFlag = false;
        animationThread.start();
    }

    // Stop the animation thread
    public void stop() {
        stopFlag = true;
        animationThread = null;
    }

    // Main animation loop
    public void run() {
        while (!stopFlag) {
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Animation interrupted");
            }
            x -= 2;
            if (x < -getFontMetrics(getFont()).stringWidth(bannerText)) {
                x = getWidth();
            }
        }
    }

    // Update the display (double buffering)
    public void update(Graphics g) {
        paint(g);
    }

    // Draw the banner
    public void paint(Graphics g) {
        Image offImage;
        Graphics offg;

        // Double buffering
        offImage = createImage(getWidth(), getHeight());
        offg = offImage.getGraphics();

        // Clear background
        offg.setColor(getBackground());
        offg.fillRect(0, 0, getWidth(), getHeight());

        // Draw text
        offg.setColor(getForeground());
        offg.setFont(new Font("Arial", Font.BOLD, 24));
        offg.drawString(bannerText, x, y);

        // Draw the off-screen image to the applet
        g.drawImage(offImage, 0, 0, this);
    }
}