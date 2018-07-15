package pizzeria.drinks;

public class Water implements Drink {

    private double price;
    private String name;
    private int quantity;
    private DrinkAddittion addittion;

    public Water(String sort) {
        if(sort.equals( "sparkling" )) {
            this.price = 1.5;
            this.name = "Gazuotas vanduo";
        } else {
            this.price = 1;
            this.name = "Stalo vanduo";
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
        return (this.price * this.quantity);
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
