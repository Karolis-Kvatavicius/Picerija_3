package pizzeria.drinks;

public class Beer implements Drink {

    private double price;
    private String name;
    private int quantity;
    private DrinkAddittion addittion;

    public Beer(String sort) {
        
        if(sort.equals( "dark" )) {
            this.price = 3.5;
            this.name = "Tamsus alus";
        } else if(sort.equals( "white" )) {
            this.price = 3.75;
            this.name = "Baltas alus";
        } else {
          this.price = 3;
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

    @Override
    public DrinkAddittion getDrinkAdd() {
        return this.addittion;
    }
}
