import java.io.*;
import java.net.*;
import java.util.Set;

public class PhoneBookServer {
    private static final int PORT = 12345;
    static PhoneBook phoneBook1 = new PhoneBook("PhoneBook1");
    static PhoneBook phoneBook2 = new PhoneBook("PhoneBook2");

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started...");
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

            int request = in.readInt();
            Message message = Message.decode(request);

            PhoneBook phoneBook = (message.getPhoneBookId() == 1) ? PhoneBookServer.phoneBook1 : PhoneBookServer.phoneBook2;
            String response = "";

            switch (message.getMethodId()) {
                case 1: // Add entry
                    String name = decodeName(message.getParam1());
                    String phoneNumber = decodePhoneNumber(message.getParam2());
                    String description = decodeDescription(message.getParam3());
                    phoneBook.addEntry(name, phoneNumber, description);
                    response = "Entry added successfully";
                    break;
                case 2: // Query phone numbers
                    Set<PhoneBookEntry> entries = phoneBook.getAllEntries();
                    StringBuilder responseBuilder = new StringBuilder();
                    for (PhoneBookEntry entry : entries) {
                        responseBuilder.append(entry.getPhoneNumber()).append("\n");
                    }
                    response = responseBuilder.toString();
                    break;
                case 3: // Get description
                    name = decodeName(message.getParam1());
                    PhoneBookEntry entry = phoneBook.searchEntryByName(name);
                    response = (entry != null) ? entry.getDescription() : "Entry not found";
                    break;
            }
            out.writeUTF(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String decodeName(int code) {
        String[] names = {"Meier", "Schmidt", "Muller", "Weber", "Schneider", "Fischer", "Meyer", "Wagner", "Becker", "Hoffmann"};
        return names[code];
    }

    private String decodePhoneNumber(int code) {
        return String.format("555-%04d", code);
    }

    private String decodeDescription(int code) {
        String[] descriptions = {"Home", "Work", "Mobile", "Office", "Other", "Home1", "Work1", "Mobile1", "Office1", "Other1"};
        return descriptions[code];
    }
}