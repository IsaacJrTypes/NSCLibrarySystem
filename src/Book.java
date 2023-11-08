/**
 * Book class creates an object with Book media specific details for library cataloging.
 * It extends from Artifact class and allows for generic type bounding
 * */
public class Book extends Artifact{
    private String author;
    private String ISBN;
    // Book constructor
    public Book(String title,String author, String ISBN, Boolean NSCCollection) {
        super(title,NSCCollection);
        this.ISBN = ISBN;
        this.author = author;
    }

    @Override
    public String toString() {
        return  super.toString() + ", Author: " + author + ", ISBN: " + ISBN;
    }
}