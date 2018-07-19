package pizzeria.drinks;

public enum DrinkAddittion {

    CUKRUS( 0, "Cukrus", "0" ),
    MEDUS( 0.6, "Medus", "0" ),
    CITRINA( 0.3, "Citrina", "0" ),
    PIENAS( 0.5, "Pienas", "0" ),
    NONE( 0.0, "Be priedų", "0" );

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
