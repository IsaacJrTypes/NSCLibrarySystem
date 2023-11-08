import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class NSCLibraryTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void testMediaContainer() {
        //Create mock data
        Book book1 = new Book("Book1Title", "auth1", "222-333-4-4", false);
        Book book2 = new Book("Book2Title", "auth2", "772-333-4-4", true);
        DVD dvd1 = new DVD("dvd1Title", 90, "Horror", true);
        DVD dvd2 = new DVD("dvd2Title", 120, "Comedy", false);
        Magazine mag1 = new Magazine("mag1Title", 1728, "Jan", true);
        Magazine mag2 = new Magazine("mag2Title", 7398, "Dec", false);

        // Create container instances
        NSCLibraryMediaContainer<Book> bookContainer = new NSCLibraryMediaContainer<>();
        NSCLibraryMediaContainer<DVD> DVDContainer = new NSCLibraryMediaContainer<>();
        NSCLibraryMediaContainer<Magazine> magContainer = new NSCLibraryMediaContainer<>();
        NSCLibraryMediaContainer<Artifact> artifactContainer = new NSCLibraryMediaContainer<>();

        // Assert container type
        assertSame(bookContainer.getClass(), NSCLibraryMediaContainer.class);
        assertSame(DVDContainer.getClass(), NSCLibraryMediaContainer.class);
        assertSame(magContainer.getClass(), NSCLibraryMediaContainer.class);
        assertSame(artifactContainer.getClass(), NSCLibraryMediaContainer.class);


        // Add items
        bookContainer.add(book1);
        bookContainer.add(book2);
        DVDContainer.add(dvd1);
        DVDContainer.add(dvd2);
        magContainer.add(mag1);
        magContainer.add(mag2);
        artifactContainer.add(book1);
        artifactContainer.add(dvd1);
        artifactContainer.add(mag1);

        // Display items in bookContainer
        bookContainer.display();
        String expectedBookContainerOutput = """
                Title: Book1Title, NSCCollection: false, Author: auth1, ISBN: 222-333-4-4
                Title: Book2Title, NSCCollection: true, Author: auth2, ISBN: 772-333-4-4""";
        assertEquals(expectedBookContainerOutput, outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset(); //Empties outputStreamCaptor

        // Display items in DVDContainer
        DVDContainer.display();
        String expectedDVDContainerOutput = """
                Title: dvd1Title, NSCCollection: true, Duration: 90, Genre: Horror
                Title: dvd2Title, NSCCollection: false, Duration: 120, Genre: Comedy""";
        assertEquals(expectedDVDContainerOutput, outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        // Display items in magContainer
        magContainer.display();
        String expectedMagContainerOutput = """
                Title: mag1Title, NSCCollection: true, Issue Number: 1728, Month: Jan
                Title: mag2Title, NSCCollection: false, Issue Number: 7398, Month: Dec""";
        assertEquals(expectedMagContainerOutput, outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        // Display items in artifactContainer
        artifactContainer.display();
        String expectedArtifactContainerOutput = """
                Title: Book1Title, NSCCollection: false, Author: auth1, ISBN: 222-333-4-4
                Title: dvd1Title, NSCCollection: true, Duration: 90, Genre: Horror
                Title: mag1Title, NSCCollection: true, Issue Number: 1728, Month: Jan""";
        assertEquals(expectedArtifactContainerOutput, outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        // Print individual items using NSCMediaUtils
        NSCMediaUtils.printMediaDetails(book2);
        String expectedBook2Output = "Title: Book2Title, NSCCollection: true, Author: auth2, ISBN: 772-333-4-4";
        assertEquals(expectedBook2Output, outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        NSCMediaUtils.printMediaDetails(dvd2);
        String expectedDVD2Output = "Title: dvd2Title, NSCCollection: false, Duration: 120, Genre: Comedy";
        assertEquals(expectedDVD2Output, outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();

        NSCMediaUtils.printMediaDetails(mag2);
        String expectedMag2Output = "Title: mag2Title, NSCCollection: false, Issue Number: 7398, Month: Dec";
        assertEquals(expectedMag2Output, outputStreamCaptor.toString().trim());
        outputStreamCaptor.reset();
    }
    @AfterEach // Resets standard output stream
    public void tearDown() {
        System.setOut(standardOut);
    }

}