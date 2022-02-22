package opgave3;

public class AlcoholMoms implements MomsBeregning {

    @Override
    public double moms (double price) {
        double taxPrice = price * 1.8;
        return (taxPrice > 90.0) ? price * 2.2 : taxPrice;
    }

}
