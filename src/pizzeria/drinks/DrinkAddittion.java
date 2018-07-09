package pizzeria.drinks;

public enum DrinkAddittion {

    CUKRUS(0.2, "Cukrus"),
    MEDUS(0.6, "Medus" ),
    CITRINA(0.3, "Citrina" ),
    PIENAS(0.5, "Pienas" ),
    NONE(0.0, "Be priedų");

    private double price;
    private String name;

    DrinkAddittion(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getDrinkAddittionName() {return name;}
    
    public double getDrinkAdditionPrice() {
        return price;
    }
}
