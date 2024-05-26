import java.util.HashSet;
import java.util.Set;

public class PhoneBook {
    private String name;
    private Set<PhoneBookEntry> entries;

    public PhoneBook(String name) {
        this.name = name;
        this.entries = new HashSet<>();
    }

    public PhoneBookEntry searchEntryByName(String name) {
        for (PhoneBookEntry entry : entries) {
            if (entry.getName().equalsIgnoreCase(name)) {
                return entry;
            }
        }
        return null;
    }

    public void addEntry(String name, String phoneNumber, String description) {
        PhoneBookEntry entry = new PhoneBookEntry(name, phoneNumber, description);
        entries.add(entry);
    }

    public Set<PhoneBookEntry> getAllEntries() {
        return entries;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PhoneBook: " + name;
    }
}