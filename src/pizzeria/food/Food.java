package pizzeria.food;

import pizzeria.MenuItem;

public interface Food extends MenuItem {

    void setSauce(Sauce sauce);

    double getSaucePrice();

    String getSaucename();

}
