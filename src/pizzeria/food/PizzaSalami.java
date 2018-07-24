package pizzeria.food;

import static pizzeria.AllMethods.getRegex;
import static pizzeria.AllMethods.readPrices;

public class PizzaSalami implements Food {
    private double price;
    private String name;
    private int quantity;
    private Sauce sauce;

    public PizzaSalami(String size) {
        if (size.equals( "1" )) {
            this.price = readPrices( "foodmenu.txt", 4 , 1, getRegex(3));
            this.name = "Maža salami pica";
        } else if (size.equals( "2" )) {
            this.price = readPrices( "foodmenu.txt", 4 , 2, getRegex(3));
            this.name = "Vidutinė salami pica";
        } else {
            this.price = readPrices( "foodmenu.txt", 4 , 3, getRegex(3));
            this.name = "Didelė salami pica";
        }
        this.quantity = 0;
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
