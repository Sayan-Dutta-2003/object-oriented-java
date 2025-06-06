import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageDisplay extends JFrame {

    public ImageDisplay(String imagePath) {
        setTitle("400x300 Image Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Fixed window size

        try {
            // Load the original image
            BufferedImage originalImage = ImageIO.read(new File(imagePath));

            // Resize the image to 400x400
            Image resizedImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);

            // Create a white background BufferedImage
            BufferedImage bufferedResizedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedResizedImage.createGraphics();

            // Fill the background with white
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, 300, 300);

            // Draw the resized image on top
            g2d.drawImage(resizedImage, 0, 0, null);
            g2d.dispose();

            // Display the resized image
            JLabel label = new JLabel(new ImageIcon(bufferedResizedImage));
            add(label);
            setLocationRelativeTo(null); // Center the window

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading image: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public static void main(String[] args) {

        String imagePath = "src//pexels-photo-751378.jpeg";
        SwingUtilities.invokeLater(() -> {
            ImageDisplay display = new ImageDisplay(imagePath);
            display.setVisible(true);
        });
    }
}
