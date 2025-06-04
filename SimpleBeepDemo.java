// 49.	Write a Java program to demonstrate sound effect.

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import java.awt.*;


public class SimpleBeepDemo extends JFrame {

    public SimpleBeepDemo() {
        setTitle("Simple Beep Demo");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton beepButton = new JButton("Play Beep");
        beepButton.addActionListener(e -> Toolkit.getDefaultToolkit().beep());
        add(beepButton);

        JButton customBeepButton = new JButton("Custom Beep");
        customBeepButton.addActionListener(e -> playCustomBeep());
        add(customBeepButton);
    }

    private void playCustomBeep() {
        try {
            // Generate a simple tone
            int duration = 1000; // milliseconds
            int freq = 440; // Hz (A4 note)

            byte[] buf = new byte[1];
            AudioFormat af = new AudioFormat(8000f, 8, 1, true, false);
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();

            for (int i = 0; i < duration * 8; i++) {
                double angle = i / (8000f / freq) * 2.0 * Math.PI;
                buf[0] = (byte)(Math.sin(angle) * 127.0);
                sdl.write(buf, 0, 1);
            }

            sdl.drain();
            sdl.stop();
            sdl.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleBeepDemo demo = new SimpleBeepDemo();
            demo.setVisible(true);
        });
    }
}