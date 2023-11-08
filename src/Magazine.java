/**
 * Magazine class creates an object with Magazine media specific details for library cataloging.
 * It extends from Artifact class and allows for generic type bounding
 * */
public class Magazine extends Artifact{
    private int issueNumber;
    private String month;
    // Magazine constructor
    public Magazine(String title,int issueNumber, String month, Boolean NSCCollection) {
        super(title,NSCCollection);
        this.issueNumber = issueNumber;
        this.month = month;
    }
    @Override
    public String toString() {
        return  super.toString() + ", Issue Number: " + issueNumber + ", Month: "+month;
    }
}