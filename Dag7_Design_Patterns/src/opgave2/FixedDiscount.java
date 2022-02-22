package opgave2;

public class FixedDiscount extends Discount {

    private int fixedDiscount;
    private int discountLimit;

    public FixedDiscount (int fixedDiscount, int discountLimit) {
        super();

        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }

    public int getFixedDiscount() {
        return this.fixedDiscount;
    }

    public void setFixedDiscount(int fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }

    public int getDiscountLimit() {
        return this.discountLimit;
    }

    public void setDiscountLimit(int discountLimit) {
        this.discountLimit = discountLimit;
    }

    @Override
    public double getDiscount (double price) {
        return (price >= this.discountLimit) ? this.fixedDiscount : 0;
    }

}
