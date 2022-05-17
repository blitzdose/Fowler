import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RentalTest {

    Movie testMovie;
    Rental testRental;

    @Before
    public void setupObjects() {
        testMovie = new Movie( "Interstellar", Movie.REGULAR);
        testRental = new Rental(testMovie, 5);
    }

    @Test
    public void testGetMovie() {
        assertEquals(testMovie, testRental.getMovie());
    }

    @Test
    public void testGetDaysRented(){
        assertEquals(5, testRental.getDaysRented());
    }
}
