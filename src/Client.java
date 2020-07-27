import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Socket server;

        try {
            // Connect to server
            server = new Socket("localhost", 8000);

            ObjectOutputStream serverOut = new ObjectOutputStream(server.getOutputStream());
            ObjectInputStream serverIn = new ObjectInputStream(server.getInputStream());

            while(true) {
                System.out.print("Enter something: ");
                String userInput = scanner.nextLine();

                // Send data to the server
                serverOut.writeObject(userInput);

                // Receive the response from the server
                String serverResponse = (String) serverIn.readObject();

                System.out.println("Server says: " + serverResponse);
            }
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
