package Car;

import java.util.ArrayList;

public class RentalApp {
    public static void main(String[] args) {
        Rental rental1 = new Rental(1, 10, "10-3-2021");
        Rental rental2 = new Rental(2, 10, "10-3-2021");

        Car Farrari = new Car("3021342", 2002, 2000.0);
        Car Bugatti = new Car("23-D32-2031", 2019, 5000.0);
        Car Punto = new Car("53A-302-3E", 2020, 350.0);
        Car Fiat = new Car("32-3293-49", 2021, 500.0);
        Car RollsRoys = new Car("3845-329-329", 2021, 7000.0);

        ArrayList<Car> xpcars = new ArrayList<Car>();
        xpcars.add(Farrari);
        xpcars.add(Bugatti);
        xpcars.add(RollsRoys);

        ArrayList<Car> cheapcars = new ArrayList<Car>();
        cheapcars.add(Fiat);
        cheapcars.add(Punto);

        rental1.addCars(Farrari);
        rental1.addCars(Bugatti);
        rental1.addCars(RollsRoys);

        rental2.addCars(Fiat);
        rental2.addCars(Punto);

        System.out.println(rental1.getPrice());

        System.out.println("The list of the expensive cars is as follows:");
        System.out.println(" ");
        for (Car c : rental1.getCars()){
            System.out.println("The license and purchase year of the registeret vehicles is as follows: "  + c.getLicense() + " " + c.getPurchaseYear());
        }
         System.out.println(" ");
         System.out.println("The list for the cheap cars is as follows:");
         System.out.println(" ");
        for (Car c : rental2.getCars()){
            System.out.println("The license and purchase year of the registeret vehicles is as follows: "  + c.getLicense() + " " + c.getPurchaseYear());
        }


    }
}
