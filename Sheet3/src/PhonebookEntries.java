public class PhonebookEntries {
    private String p_b_entriesName;
    private String p_b_entriesNumber;
    private String p_b_entriesDescription;

    public PhonebookEntries(String p_b_entriesName, String p_b_entriesNumber, String p_b_entriesDescription){
        this.p_b_entriesName = p_b_entriesName;
        this.p_b_entriesNumber = p_b_entriesNumber;
        this.p_b_entriesDescription = p_b_entriesDescription;
    }
    public String getName(){
        return p_b_entriesName;
    }
    public  String getNumber(){
        return p_b_entriesNumber;
    }
    public String getDescription(){
        return p_b_entriesDescription;
    }
    public void changeDescription(String newDescription){
        this.p_b_entriesDescription = newDescription;
    }
}
