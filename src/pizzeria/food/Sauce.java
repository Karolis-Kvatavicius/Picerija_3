package pizzeria.food;

import static pizzeria.AllMethods.getRegex;
import static pizzeria.AllMethods.readPrices;

public enum Sauce {
    MILD( readPrices( "sauceMenu.txt", 1 , 1, getRegex(4) ), "Švelnus padažas", "0" ),
    MIX( readPrices( "sauceMenu.txt", 1 , 2, getRegex(4) ), "Mix padažas", "0" ),
    HOT( readPrices( "sauceMenu.txt", 1 , 3, getRegex(4) ), "Aštrus padažas", "0" ),
    NO_SAUCE( 0, "Be padažo", "0" );

    private double price;
    private String name;
    private String quant;

    Sauce(double price, String name, String quant) {
        this.price = price;
        this.name = name;
        this.quant = quant;
    }

    public String getFQuant() {
        return quant;
    }

    public void setFQuant(String quant) {
        this.quant = quant;
    }

    public double getSaucePrice() {
        return price;
    }

    public String getSauceName() {
        return name;
    }
}
