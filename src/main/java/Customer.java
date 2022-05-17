import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer (String name){
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName (){
        return name;
    }

    public String statement() {
        Enumeration rentalEnumeration = rentals.elements();
        String returnString = "Rental Record for " + this.getName() + "\n";
        returnString += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentalEnumeration.hasMoreElements()) {
            Rental aRental = (Rental) rentalEnumeration.nextElement();
            //show figures for this rental
            returnString += "\t" + aRental.getMovie().getTitle()+ "\t" + "\t" + aRental.getDaysRented() + "\t" + String.valueOf(aRental.getCharge()) + "\n";
        }
        //add footer lines
        returnString += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        returnString += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return returnString;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentalEnumeration = rentals.elements();
        while (rentalEnumeration.hasMoreElements()) {
            Rental each = (Rental) rentalEnumeration.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentalEnumeration = rentals.elements();
        while (rentalEnumeration.hasMoreElements()) {
            Rental each = (Rental) rentalEnumeration.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }


}
    