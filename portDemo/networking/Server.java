package portDemo.networking;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started on port: " + serverSocket.getLocalPort());

            Socket clientSocket = serverSocket.accept();
            System.out.println("\nClient Connected from:");
            System.out.println("Remote Port: " + clientSocket.getPort());
            System.out.println("Local Port: " + clientSocket.getLocalPort());

            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
