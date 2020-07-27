import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8000);

            // Wait for the client to connect
            Socket client = socket.accept();

            ObjectOutputStream clientOut = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream clientIn = new ObjectInputStream(client.getInputStream());

            while(true) {
                String clientInput = (String) clientIn.readObject();
                String converted = clientInput.toUpperCase();

                System.out.println("Client says: " + clientInput);
                clientOut.writeObject(converted);
            }
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
