package opgave3;

public class ItemMoms implements MomsBeregning{

    @Override
    public double moms (double price) {
        return price * 1.25;
    }

}
