package Car;

public class RentalApp {
    public static void main(String[] args) {

        Car c = new Car("WUP", 1993);

        Rental r = new Rental(10, 5, "1993");
        Rental s = new Rental(13, 120, "1934");
        Rental b = new Rental(14, 13, "1945");
        Rental e = new Rental(12, 32, "1934");

        r.addCar(c);
        s.addCar(c);
        b.addCar(c);
        e.addCar(c);

        System.out.println(c.maxDays());

    }
}
