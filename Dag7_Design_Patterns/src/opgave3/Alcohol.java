package opgave3;

public class Alcohol extends Item {

    private double alcoholPercent;

    Alcohol(String name, double price, String description, MomsBeregning moms, double alcoholPercent) {
        super(name, price, description, moms);

        this.alcoholPercent = alcoholPercent;
    }

}
