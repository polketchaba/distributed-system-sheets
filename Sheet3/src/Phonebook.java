import java.util.HashSet;
import java.util.Set;

public class Phonebook {
    private String phonebooksName;
    private Set<PhonebookEntries> p_b_Entries;

    public Phonebook(String phonebooksName){
        this.phonebooksName = phonebooksName;
        this.p_b_Entries = new HashSet<>();
    }

    public PhonebookEntries searchPhoneEntries(String p_b_EntriesName){
        for(PhonebookEntries entry: p_b_Entries){
            if(entry.getName().equals(p_b_EntriesName)){
                return entry;
            }
        }
        return null;
    }

    public void addPhoneEntries(String name, String number, String description){
        PhonebookEntries newEntry = new PhonebookEntries(name, number, description);
        p_b_Entries.add(newEntry);
    }

    public Set<PhonebookEntries> getAllEntries(){
        return p_b_Entries;
    }

    public String getPhonebooksName(){
        return phonebooksName;
    }
    public void displayEntriesStartingWithS() {
        System.out.println("Entries in " + phonebooksName + " starting with 'S':");
        for (PhonebookEntries entry : p_b_Entries) {
            if (entry.getName().startsWith("S")) {
                System.out.println("Name: " + entry.getName() + ", Phone Number: " + entry.getNumber() + ", Description: " + entry.getDescription());
            }
        }
    }
}
