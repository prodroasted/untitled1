package Car;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String date;
    ArrayList<Car> cars = new ArrayList<Car>();

    public Rental (int number, int days, String date) {
        this.number = number;
        this.days = days;
        this.date = date;
    }

    public ArrayList<Car> getCars () {
        return new ArrayList<Car>(cars);
    }

    public void addCars(Car car){
        if (!cars.contains(car)) {
            cars.add(car);
        }
    }

    public void removeCars (Car car){
        if (cars.contains(car)){
            cars.remove(car);
        }
    }

    public void setDays (int days) {
        this.days = days;
    }

    public int getDays () {
        return days;
    }

    public double getPrice () {
        return days;

    }
}
