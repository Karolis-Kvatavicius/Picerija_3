package pizzeria.food;

public class PizzaWrap implements Food{

    private double price;
    private String name;
    private int quantity;
    private Sauce sauce;

//    public PizzaWrap() {
//        this.name = "Wrap pica";
//        this.quantity = 0;
//        this.price = 10;
//        this.sauce = null;
//    }

    public PizzaWrap(String size){
        if(size.equals("1")) {
            this.price = 8.25;
            this.name = "Maža wrap pica";
        }  else if(size.equals("2")){
            this.price = 10.20;
            this.name = "Vidutinė wrap pica";
        }  else if(size.equals( "3" )) {
            this.price = 11.20;
            this.name = "Didelė wrap pica";
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
