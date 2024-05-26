import java.util.Set;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook("My Phone Book");

        // Adding entries to the phone book
        phoneBook.addEntry("Sam Smith", "123-456-7890", "Home");
        phoneBook.addEntry("Sarah Connor", "987-654-3210", "Work");
        phoneBook.addEntry("John Doe", "555-555-5555", "Mobile");
        phoneBook.addEntry("Steve Jobs", "800-123-4567", "Office");

        // Searching for an entry
        PhoneBookEntry entry = phoneBook.searchEntryByName("Sarah Connor");
        if (entry != null) {
            System.out.println("Found entry: " + entry);
        } else {
            System.out.println("Entry not found");
        }

        // Display all entries with names starting with 'S'
        System.out.println("Entries with names starting with 'S':");
        for (PhoneBookEntry e : phoneBook.getAllEntries()) {
            if (e.getName().startsWith("S")) {
                System.out.println(e);
            }
        }

    }
}