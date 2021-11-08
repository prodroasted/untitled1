package Car;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars = new ArrayList<Car>();

    public Rental (int number, int days, String date) {
        this.number = number;
        this.days = days;
        this.date = date;


    }

    public void addCar(Car car){
        if (!cars.contains(car)){
            cars.add(car);
            car.addRental(this);
        }
    }

    public void removeCar (Car car){
        if(cars.contains(car)){
            cars.remove(car);
            car.addRental(this);
        }
    }

    public void setDays (int days) {
        this.days = days;
    }

    public int getDays () {
        return days;
    }


}
