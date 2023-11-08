/**
 * NSCLibraryMediaContainer class uses generics and bounded types
 * to restrict type parameters to Book, DVD, and Magazine.
 * Implements generic Iterable.
 */

import java.util.ArrayList;
import java.util.Iterator;

public class NSCLibraryMediaContainer<T extends Artifact> implements Iterable<T> {
    // Holds arrays
    private ArrayList<T> crate;
    // Crate constructor for instantiation
    public NSCLibraryMediaContainer() {
        this.crate = new ArrayList<T>();
    }
    // Method enables adding items to instantiate crate
    public void add(T item) {
        this.crate.add(item);
    }
    // Enables removal of item from instantiate crate
    public void remove(T item) {
        this.crate.remove(item);
    }
    // Implements iterator
    @Override
    public Iterator<T> iterator() {
        return this.crate.iterator();
    }
    // Prints every element in an iterable
    public void display() {
        Iterator<T> iterator = this.iterator();
        while(iterator.hasNext()) {
            T item = iterator.next();
            System.out.println(item);
        }
    }
    // Prints specific items in an iterable
    public void display(T item) {
        Iterator<T> iterator = this.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            T item1 = iterator.next();
            if (item1.equals(item)) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Item does not exist in crate");
        }
    }

}