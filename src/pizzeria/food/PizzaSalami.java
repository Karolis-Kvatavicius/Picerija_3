package pizzeria.food;

public class PizzaSalami implements Food{
    private double price;
    private String name;
    private int quantity;
    private Sauce sauce;

    public PizzaSalami() {
        this.name = "Saliami pica";
        this.quantity = 0;
        this.price = 12;
        this.sauce = null;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public double calculateItemPrice() {
        return this.price * this.quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }


    @Override
    public double getSaucePrice() {
        return this.sauce.getSaucePrice();
    }

    @Override
    public String getSaucename() {
        return this.sauce.getSauceName();
    }
}
