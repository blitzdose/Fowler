import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer testCustomer;

    @Before
    public void createTestCustomer() {
        testCustomer = new Customer("Christian");
    }

    @Test
    public void testGetName(){
        assertEquals("Christian", testCustomer.getName());
    }



    @Test
    public void testStatementNone(){
        assertEquals("Rental Record for Christian\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", testCustomer.statement());
    }

    @Test
    public void testStatementItem() {
        testCustomer.addRental(new Rental(new Movie("Interstellar", Movie.REGULAR), 3));

        assertEquals("Rental Record for Christian\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tInterstellar\t\t3\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", testCustomer.statement());
    }

}
