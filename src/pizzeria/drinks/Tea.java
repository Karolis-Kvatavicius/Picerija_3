package pizzeria.drinks;

import static pizzeria.AllMethods.getRegex;
import static pizzeria.AllMethods.readPrices;

public class Tea implements Drink {

    private double price;
    private String name;
    private int quantity;
    private DrinkAddittion addittion;

    public Tea() {
        this.price = readPrices( "drinksmenu.txt", 1 , 7, getRegex(7));
        this.name = "Arbata";
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
    public void setDrinkAddittion(DrinkAddittion addittion) {
        this.addittion = addittion;
    }

    @Override
    public double getDrinkAddPrice() {
        return this.addittion.getDrinkAdditionPrice();
    }

    @Override
    public String getDrinkAddName() {
        return this.addittion.getDrinkAddittionName();
    }

}
