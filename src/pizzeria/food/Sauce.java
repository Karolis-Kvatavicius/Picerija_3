package pizzeria.food;

public enum Sauce {

    MILD(1, "Švelnus padažas", "0"),
    MIX(1.1, "Mix padažas", "0"),
    HOT(1.25, "Aštrus padažas", "0"),
    NO_SAUCE(0.0, "Be padažo", "0");

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

    public String getSauceName() {return name;}
}
