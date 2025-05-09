import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BannerJavaWebStart extends JPanel implements Runnable {
    private int x, y;
    private final String bannerText = "Java Web Start Banner - Scroll Text! ";
    private boolean stopFlag;
    private final int WIDTH = 400;

    public BannerJavaWebStart() {
        int HEIGHT = 100;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setForeground(Color.CYAN);
        x = WIDTH;
        y = HEIGHT / 2;
        startAnimation();
    }

    private void startAnimation() {
        Thread animationThread = new Thread(this);
        stopFlag = false;
        animationThread.start();
    }

    public void stopAnimation() {
        stopFlag = true;
    }

    @Override
    public void run() {
        while (!stopFlag) {
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Animation interrupted");
            }
            x -= 2;
            if (x < -getFontMetrics(getFont()).stringWidth(bannerText)) {
                x = WIDTH;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Double buffering
        BufferedImage offImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D offg = offImage.createGraphics();

        // Clear background
        offg.setColor(getBackground());
        offg.fillRect(0, 0, getWidth(), getHeight());

        // Draw text
        offg.setColor(getForeground());
        offg.setFont(new Font("Arial", Font.BOLD, 24));
        offg.drawString(bannerText, x, y);

        // Draw the off-screen image to the panel
        g2d.drawImage(offImage, 0, 0, this);
        offg.dispose();
        g2d.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Banner Application");
            BannerJavaWebStart banner = new BannerJavaWebStart();
            frame.add(banner);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}