package opgave3;

public class App {
    public static void main(String[] args) {

        Cart cart = new Cart();

        Food banana = new Food("Banana", 9.95, "You should peal it before eating it", new FoodMoms(), 7);
        Food apple = new Food("Apple", 6.95, "Juicy thing that can mess up your teeth", new FoodMoms(), 10);
        Food beef = new Food("Beef (250g)", 24.95, "I swear there are no worms in here", new FoodMoms(), 4);

        Electronics computer = new Electronics("Lenovo Legion Y520", 9999.95, "1050 Ti, i5 8700h", new ElectronicsMoms(), 100);
        Electronics iPhone = new Electronics("iPhone SE (2020)", 2399.95, "Good phone, maximum privacy (hehe)", new ElectronicsMoms(), 20);

        Alcohol rum = new Alcohol("Gold Rum", 109.95, "The cheapest, eye-watering rum you can get", new AlcoholMoms(), 40);
        Alcohol vodka = new Alcohol("Smirnoff", 119.95, "This is basically slave vodka", new AlcoholMoms(), 40);
        Alcohol beer = new Alcohol("Carlsberg Classic", 14.95, "Best beer there is", new AlcoholMoms(), 4.5);

        Item shirt = new Item("Green shirt", 299.95, "Cotton is for cheap people. This is polyester", new ItemMoms());

        cart.addItems(banana, apple, beef, computer, iPhone, rum, vodka, beer, shirt);

        System.out.println(cart.totalPrice());

    }
}
