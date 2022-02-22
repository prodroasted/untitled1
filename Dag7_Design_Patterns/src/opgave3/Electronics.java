package opgave3;

public class Electronics extends Item {

    private double avgEnergyUsePrHour;

    Electronics(String name, double price, String description, MomsBeregning moms, double avgEnergyUsePrHour) {
        super(name, price, description, moms);

        this.avgEnergyUsePrHour = avgEnergyUsePrHour;
    }

}
