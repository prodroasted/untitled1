package opgave3;

public class Food extends Item {

    private int shelfLife;

    Food(String name, double price, String description, MomsBeregning moms, int shelfLife) {
        super(name, price, description, moms);

        this.shelfLife = shelfLife;
    }

}
