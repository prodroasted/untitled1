package opgave3;

public class FoodMoms implements MomsBeregning {

    @Override
    public double moms (double price) {
        return price * 1.05;
    }
}
