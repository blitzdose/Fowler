import java.lang.*;
import java.util.*;

class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<>();

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
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        StringBuilder returnString = new StringBuilder("Rental Record for " + this.getName() + "\n");
        returnString.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        while (rentalEnumeration.hasMoreElements()) {
            Rental aRental = rentalEnumeration.nextElement();
            //show figures for this rental
            returnString.append("\t").append(aRental.getMovie().getTitle()).append("\t").append("\t").append(aRental.getDaysRented()).append("\t").append(aRental.getCharge()).append("\n");
        }
        //add footer lines
        returnString.append("Amount owed is ").append(getTotalCharge()).append("\n");
        returnString.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");
        return returnString.toString();
    }

    public String htmlStatement() {
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        StringBuilder result = new StringBuilder("<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n");
        while (rentalEnumeration.hasMoreElements()) {
            Rental each = rentalEnumeration.nextElement();
            //show figures for each rental
            result.append(each.getMovie().getTitle()).append(": ").append(each.getCharge()).append("<BR>\n");
        }
        //add footer lines
        result.append("<P>You owe <EM>").append(getTotalCharge()).append("</EM><P>\n");
        result.append("On this rental you earned <EM>").append(getTotalFrequentRenterPoints()).append("</EM> frequent renter points<P>");
        return result.toString();
    }


    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        while (rentalEnumeration.hasMoreElements()) {
            Rental each = rentalEnumeration.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration<Rental> rentalEnumeration = rentals.elements();
        while (rentalEnumeration.hasMoreElements()) {
            Rental each = rentalEnumeration.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }


}
    