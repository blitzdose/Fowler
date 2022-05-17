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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentalEnumeration = rentals.elements();
        String returnString = "Rental Record for " + this.getName() + "\n";
        returnString += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentalEnumeration.hasMoreElements()) {
            Rental aRental = (Rental) rentalEnumeration.nextElement();
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && aRental.getDaysRented() > 1)
                frequentRenterPoints ++;
            //show figures for this rental
            returnString += "\t" + aRental.getMovie().getTitle()+ "\t" + "\t" + aRental.getDaysRented() + "\t" + String.valueOf(aRental.getCharge()) + "\n";
            totalAmount += aRental.getCharge();
        }
        //add footer lines
        returnString += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        returnString += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return returnString;
    }

}
    