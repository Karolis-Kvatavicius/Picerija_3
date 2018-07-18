package pizzeria.drinks;

import pizzeria.MenuItem;

public interface Drink extends MenuItem {

    void setDrinkAddittion(DrinkAddittion addittion);

    double getDrinkAddPrice();

    String getDrinkAddName();

}
