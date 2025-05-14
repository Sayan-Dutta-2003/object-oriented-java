package Datagram;

import java.io.IOException;
import java.net.*;


public class Client {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");

            // Prepare message to send
            String message = "Hello Server!";
            byte[] sendBuffer = message.getBytes();

            // Send packet to server
            DatagramPacket sendPacket = new DatagramPacket(
                    sendBuffer,
                    sendBuffer.length,
                    serverAddress,
                    9876
            );
            socket.send(sendPacket);
            System.out.println("Sent message to server: " + message);

            // Receive response from server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            // Process the response
            String receivedResponse = new String(
                    receivePacket.getData(),
                    0,
                    receivePacket.getLength()
            );
            System.out.println("Received from server: " + receivedResponse);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
