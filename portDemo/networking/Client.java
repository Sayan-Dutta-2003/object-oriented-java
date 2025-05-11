package portDemo.networking;


import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localHost", 12345);
            System.out.println("Connected to Server:");
            System.out.println("Server Port: " + socket.getPort());
            System.out.println("Client Port: " + socket.getLocalPort());

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
