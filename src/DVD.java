/**
 * DVD class creates an object with DVD media specific details for library cataloging.
 * It extends from Artifact class and allows for generic type bounding
 * */
public class DVD extends Artifact {
    private int duration;
    private String genre;
    // DVD constructor
    public DVD(String title,int duration, String genre, Boolean NSCCollection) {
        super(title,NSCCollection);
        this.duration = duration;
        this.genre = genre;
    }
    @Override
    public String toString() {
        return  super.toString() + ", Duration: " + duration+ ", Genre: "+ genre;
    }
}