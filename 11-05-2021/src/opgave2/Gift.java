package opgave2;

public class Gift {
    private String description;
    private double price;
    private Person person;

    public Gift (String description, Person person){
        this.description = description;
        this.person = person;
    }

    public Person getPerson(){
        return this.person;
    }

    public void setPrice (double price){
        this.price = price;
    }

    public double getPrice () {
        return price;
    }
}
