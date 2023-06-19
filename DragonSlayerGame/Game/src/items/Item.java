package items;

public abstract class Item {
    protected double price;

    public double getPrice() {
        return price;
    }
    public abstract String getName();
}
