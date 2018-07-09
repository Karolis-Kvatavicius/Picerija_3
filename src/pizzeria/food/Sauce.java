package pizzeria.food;

public enum Sauce {

    MILD(1, "Švelnus padažas"),
    MIX(1.1, "Mix padažas"),
    HOT(1.25, "Aštrus padažas"),
    NO_SAUCE(0.0, "Be padažo");

    private double price;
    private String name;

    Sauce(double price, String name) {
        this.price = price;
        this.name = name;
    }


    public double getSaucePrice() {
        return price;
    }

    public String getSauceName() {return name;}
}
