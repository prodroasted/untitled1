package Car;

import java.util.ArrayList;

public class Car {
    private String License;
    private Double pricePerDay;
    private int purchaseYear;


    public Car (String license, int purchaseYear, double pricePerDay) {
        this.License = license;
        this.purchaseYear = purchaseYear;
        this.pricePerDay = pricePerDay;
    }


    public void setPricePerDay (double price) {
        this.pricePerDay = price;
    }

    public Double getPricePerDay () {
        return pricePerDay;
    }

    public String getLicense () {
        return License;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

}
