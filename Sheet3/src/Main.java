import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Phonebook phoneBook = new Phonebook("My Phone Book");

        // Ajouter quelques entrées au répertoire
        phoneBook.addPhoneEntries("John", "123456789", "Home");
        phoneBook.addPhoneEntries("Alice", "987654321", "Office");
        phoneBook.addPhoneEntries("Sarah", "555555555", "Mobile");
        phoneBook.addPhoneEntries("Michael", "111111111", "Home");

        // Rechercher une entrée par nom
        PhonebookEntries foundEntry = phoneBook.searchPhoneEntries("Alice");
        if (foundEntry != null) {
            System.out.println("Found entry: " + foundEntry.getName());
        } else {
            System.out.println("Entry not found.");
        }

        // Afficher toutes les entrées du répertoire
        System.out.println("All entries in " + phoneBook.getPhonebooksName() + ":");
        Set<PhonebookEntries> allEntries = phoneBook.getAllEntries();
        for (PhonebookEntries entry : allEntries) {
            System.out.println("Name: " + entry.getName() + ", Phone Number: " + entry.getNumber() + ", Description: " + entry.getDescription());
        }

        // Afficher le nom du répertoire téléphonique
        System.out.println("Phone book name: " + phoneBook.getPhonebooksName());

        // Afficher toutes les entrées dont le nom commence par 'S'
        phoneBook.displayEntriesStartingWithS();
    }
}