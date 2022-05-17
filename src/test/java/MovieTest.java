import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    Movie testMovie;

    @Before
    public void setTestMovie() {
        testMovie= new Movie("Bohemian Rhapsody", Movie.NEW_RELEASE);
    }

    @Test
    public void testGetMovie(){
        assertEquals("Bohemian Rhapsody",testMovie.getTitle());
    }

    @Test
    public void testGetPriceCode(){
        assertEquals(Movie.NEW_RELEASE, testMovie.getPriceCode());
    }


    @Test
    public void testSetPriceCode(){
        testMovie.setPriceCode(Movie.CHILDRENS);
        assertEquals(Movie.CHILDRENS, testMovie.getPriceCode());
    }
}
