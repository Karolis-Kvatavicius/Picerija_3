package pizzeria.drinks;

import static pizzeria.AllMethods.getRegex;
import static pizzeria.AllMethods.readPrices;

public class Beer implements Drink {

    private double price;
    private String name;
    private int quantity;
    private DrinkAddittion addittion;

    public Beer(String sort) {

        if (sort.equals( "dark" )) {
            this.price = readPrices( "drinksmenu.txt", 1 , 4, getRegex(7));
            this.name = "Tamsus alus";
        } else if (sort.equals( "white" )) {
            this.price = readPrices( "drinksmenu.txt", 1 , 5, getRegex(7));
            this.name = "Baltas alus";
        } else {
            this.price = readPrices( "drinksmenu.txt", 1 , 3, getRegex(7));
            this.name = "Šviesus alus";
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
