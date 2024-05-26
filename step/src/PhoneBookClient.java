import java.io.*;
import java.net.*;

public class PhoneBookClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Choose PhoneBook (1 or 2): ");
            int phoneBookId = Integer.parseInt(reader.readLine());

            System.out.println("Choose method (1: Add Entry, 2: Query Phone Numbers, 3: Get Description): ");
            int methodId = Integer.parseInt(reader.readLine());

            int param1 = 0, param2 = 0, param3 = 0;

            if (methodId == 1) {
                System.out.println("Enter name code (0-9): ");
                param1 = Integer.parseInt(reader.readLine());
                System.out.println("Enter phone number code (0-9): ");
                param2 = Integer.parseInt(reader.readLine());
                System.out.println("Enter description code (0-9): ");
                param3 = Integer.parseInt(reader.readLine());
            } else if (methodId == 3) {
                System.out.println("Enter name code (0-9): ");
                param1 = Integer.parseInt(reader.readLine());
            }

            Message message = new Message(phoneBookId, methodId, param1, param2, param3);
            out.writeInt(message.encode());

            String response = in.readUTF();
            System.out.println("Response from server: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}