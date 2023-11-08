/**
 * Artifact a super class represents a media item with information for logging into library system.
 * It enables generic type bounding in NSCLibraryMediaContainer class
 * */
public class Artifact {
    private String title;

    private Boolean NSCCollection;

    public Artifact(String title, Boolean NSCCollection) {
        this.title = title;
        this.NSCCollection = NSCCollection;
    }

    @Override
    public String toString() {
        return "Title: "+ title+ ", NSCCollection: "+ NSCCollection;
    }
}