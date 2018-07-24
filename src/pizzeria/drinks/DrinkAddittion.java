package pizzeria.drinks;

import static pizzeria.AllMethods.getRegex;
import static pizzeria.AllMethods.readPrices;

public enum DrinkAddittion {

    CUKRUS( readPrices( "drinkaddmenu.txt", 2 , 2, getRegex(3) ), "Cukrus", "0" ),
    MEDUS( readPrices( "drinkaddmenu.txt", 2 , 1, getRegex(3) ),"Medus", "0" ),
    CITRINA( readPrices( "drinkaddmenu.txt", 3 , 1, getRegex(2) ), "Citrina", "0" ),
    PIENAS( readPrices( "drinkaddmenu.txt", 1 , 1, getRegex(3) ), "Pienas", "0" ),
    NONE( 0.00, "Be priedų", "0" );

    private double price;
    private String name;
    private String quant;

    DrinkAddittion(double price, String name, String quant) {
        this.price = price;
        this.name = name;
        this.quant = quant;
    }

    public String getDrinkAddittionName() {
        return name;
    }

    public double getDrinkAdditionPrice() {
        return price;
    }

    public String getQuant() {
        return quant;
    }

    public void setQuant(String quant) {
        this.quant = quant;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
