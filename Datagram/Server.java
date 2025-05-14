package Datagram;

import java.io.IOException;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9876);
            System.out.println("Server started on port 9876...");

            byte[] receiveBuffer = new byte[1024];

            while (true) {
                // Receive packet from client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);

                // Process received Data
                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from Client: " + receivedData);

                // Prepare response
                InetAddress clientAddress = receivePacket.getAddress();

                int clientPort = receivePacket.getPort();
                String responseMessage = "Message received!";
                byte[] sendBuffer = responseMessage.getBytes();

                // Send response back to client
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress,clientPort);
                socket.send(sendPacket);
                System.out.println("Sent response to client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }

    }
}
