// 48.	Write a Java program to display an image.

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageDisplay extends JFrame {

    public ImageDisplay(String imagePath) {
        setTitle("400x400 Image Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600); // Set fixed window size

        try {
            // Load the original image
            BufferedImage originalImage = ImageIO.read(new File(imagePath));

            // Resize the image to 400x400
            Image resizedImage = originalImage.getScaledInstance(400, 400, Image.SCALE_SMOOTH);

            // Create a BufferedImage from the resized Image
            BufferedImage bufferedResizedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bufferedResizedImage.createGraphics();
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
        if (args.length == 0) {
            System.out.println("Usage: java ResizedImageDisplay <image-file-path>");
            System.exit(0);
        }

        SwingUtilities.invokeLater(() -> {
            ImageDisplay display = new ImageDisplay(args[0]);
            display.setVisible(true);
        });
    }
}