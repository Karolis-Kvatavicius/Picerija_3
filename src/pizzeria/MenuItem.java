package pizzeria;

public interface MenuItem {

    double getPrice();
    String getName();
    int getQuantity();
    double calculateItemPrice();
    void setQuantity(int quantity);

}
