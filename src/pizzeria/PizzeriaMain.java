package pizzeria;

import pizzeria.drinks.*;
import pizzeria.food.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static pizzeria.drinks.DrinkAddittion.*;
import static pizzeria.food.Sauce.*;

public class PizzeriaMain {

    private static Scanner scanner = new Scanner( System.in );
    private static List<Drink> clientsDrinks = new ArrayList<>();
    private static List<Food> clientsDishes = new ArrayList<>();
    private static int customerCount;
    private static long time2 = fixTime();
    private static List<Integer> addDrinkQuant = new ArrayList<>();
    private static List<Integer> addFoodQuant = new ArrayList<>();

    public static void main(String[] args) {
        String input;

        do {
            printMainMenu();
            input = scanner.nextLine();
            if (input.equals( "0" )) {
                System.out.println( "Išeinama iš programos\n" );
                break;
            }
            mainLogic( input );
        } while (!input.equals( "0" ));
    }


    static void printMainMenu() {
        System.out.println();
        System.out.println( "Pasirinkite kategoriją : 1. Gėrimų menu,  2. Maisto menu," +
                " 3. Anuliuoti užsakymą, 4. Gauti saskaitą, 0. Išeiti iš programos" );


    }

    static void printSubMenu(String input) {

        switch (input) {
            case "1":
                //TODO keisti spausdinima
                System.out.println( "Pasirinkite gėrimus:" );
                System.out.println( readFile( "drinksmenu.txt", 1 ) );
                break;

            case "2":
                //TODO keisti spausdinima
                System.out.println( "Pasirinkite maistą:" );
                System.out.println( readFile( "foodmenu.txt", 1 ) );
                break;

            case "3":
                System.out.println( "Jūsų užsakymas anuliuotas" );
                break;

            case "4":
                break;

            case "0":
                break;

            default:
                System.out.println( "Tokio pasirinkimo nėra" );
        }
    }


    static void addDrink(String input2) {
        String input3;
        switch (input2) {
            case "1": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    pickQuantityAndWaterAdd( input3, "still" );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }
            case "2": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    pickQuantityAndWaterAdd( input3, "sparkling" );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }
            case "3": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    pickQuantityAndBeerAdd( input3, "light" );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }
            case "4": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    pickQuantityAndBeerAdd( input3, "dark" );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }
            case "5": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    pickQuantityAndBeerAdd( input3, "white" );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }

            case "6": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    pickQuantityAndCoffeeAdd( input3, "" );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }
            case "7": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    pickQuantityAndTeaAdd( input3, "" );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }
            case "0": {
                System.out.println( "Grįžtama į pagrindinį meniu." );
                break;
            }
            default: {
                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                break;
            }
        }
    }

    static void addFood(String input2) {

        String input3;
        switch (input2) {

            case "1": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    wrapAdd( input3 );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }
            case "2": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    funghiAdd( input3 );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }
            case "3": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    }
                    saliamiAdd( input3 );
                } while (!input3.matches( "^[1-9]\\d{0,3}$" ));
                break;
            }

            case "0": {
                System.out.println( "Grįžtama į pagrindinį meniu." );
                break;
            }
            default: {
                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                break;
            }
        }
    }

    static void wrapAdd(String input3) {
        boolean flag = false;
        String input4, input5, input6;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                do {
                    //TODO keisti spausdinima
                    System.out.println( readFile( "foodmenu.txt", 2 ) );
                    input4 = scanner.nextLine();
                    if (input4.matches( "[1-3]" )) {

                        do {
                            //TODO keisti spausdinima
                            System.out.println( readFile( "saucemenu.txt", 1 ) );
                            input5 = scanner.nextLine();
                            if (input5.equals( "1" )) {
                                do {
                                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                                    input6 = scanner.nextLine();
                                    if (input6.matches( "^[1-9]\\d{0,3}$" )) {
                                        MILD.setFQuant( input6 );
                                        addFoodQuant.add( Integer.parseInt( MILD.getFQuant() ) );
                                        selectWrap( input4, Integer.parseInt( input3 ), MILD );
                                        System.out.println( "Užsakymas sėkmingai papildytas" );
                                    } else if (input6.equals( "0" )) {
                                        System.out.println( "Grįžtama į pagrindinį meniu" );
                                        break;
                                    } else {
                                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                                        System.out.println();
                                    }
                                } while (!input6.matches( "^[1-9]\\d{0,3}$" ));
                                flag = true;
                            } else if (input5.equals( "2" )) {
                                do {
                                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                                    input6 = scanner.nextLine();
                                    if (input6.matches( "^[1-9]\\d{0,3}$" )) {
                                        MIX.setFQuant( input6 );
                                        addFoodQuant.add( Integer.parseInt( MIX.getFQuant() ) );
                                        selectWrap( input4, Integer.parseInt( input3 ), MIX );
                                        System.out.println( "Užsakymas sėkmingai papildytas" );
                                    } else if (input6.equals( "0" )) {
                                        System.out.println( "Grįžtama į pagrindinį menu" );
                                        break;
                                    } else {
                                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                                        System.out.println();
                                    }
                                } while (!input6.matches( "^[1-9]\\d{0,3}$" ));
                                flag = true;
                            } else if (input5.equals( "3" )) {
                                do {
                                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                                    input6 = scanner.nextLine();
                                    if (input6.matches( "^[1-9]\\d{0,3}$" )) {
                                        HOT.setFQuant( input6 );
                                        addFoodQuant.add( Integer.parseInt( HOT.getFQuant() ) );
                                        selectWrap( input4, Integer.parseInt( input3 ), HOT );
                                        System.out.println( "Užsakymas sėkmingai papildytas" );
                                    } else if (input6.equals( "0" )) {
                                        System.out.println( "Grįžtama į pagrindinį meniu" );
                                        break;
                                    } else {
                                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                                        System.out.println();
                                    }
                                } while (!input6.matches( "^[1-9]\\d{0,3}$" ));
                                flag = true;
                            } else if (input5.equals( "4" )) {
                                selectWrap( input4, Integer.parseInt( input3 ), NO_SAUCE );
                                flag = true;
                                System.out.println( "Užsakymas sėkmingai papildytas" );
                            } else if (input5.equals( "0" )) {
                                System.out.println( "Grįžtama į pagrindinį meniu" );
                                flag = true;
                            } else {
                                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą\n" );
                            }
                        } while (!flag);
                    } else if (input4.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        flag = true;
                    } else {
                        System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą\n" );
                    }
                } while (!flag);
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą\n" );
                break;
            }
        } while (!flag);
    }

    static void saliamiAdd(String input3) {
        boolean flag = false;
        String input4, input5, input6;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                do {
                    //TODO keisti spausdinima
                    System.out.println( readFile( "foodmenu.txt", 4 ) );
                    input4 = scanner.nextLine();
                    if (input4.matches( "[1-3]" )) {

                        do {
                            //TODO keisti spausdinima
                            System.out.println( readFile( "saucemenu.txt", 1 ) );
                            input5 = scanner.nextLine();
                            if (input5.equals( "1" )) {
                                do {
                                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                                    input6 = scanner.nextLine();
                                    if (input6.matches( "^[1-9]\\d{0,3}$" )) {
                                        MILD.setFQuant( input6 );
                                        addFoodQuant.add( Integer.parseInt( MILD.getFQuant() ) );
                                        selectSalami( input4, Integer.parseInt( input3 ), MILD );
                                        System.out.println( "Užsakymas sėkmingai papildytas" );
                                    } else if (input6.equals( "0" )) {
                                        System.out.println( "Grįžtama į pagrindinį meniu" );
                                        break;
                                    } else {
                                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                                        System.out.println();
                                    }
                                } while (!input6.matches( "^[1-9]\\d{0,3}$" ));
                                flag = true;
                            } else if (input5.equals( "2" )) {
                                do {
                                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                                    input6 = scanner.nextLine();
                                    if (input6.matches( "^[1-9]\\d{0,3}$" )) {
                                        MIX.setFQuant( input6 );
                                        addFoodQuant.add( Integer.parseInt( MIX.getFQuant() ) );
                                        selectSalami( input4, Integer.parseInt( input3 ), MIX );
                                        System.out.println( "Užsakymas sėkmingai papildytas" );
                                    } else if (input6.equals( "0" )) {
                                        System.out.println( "Grįžtama į pagrindinį meniu" );
                                        break;
                                    } else {
                                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                                        System.out.println();
                                    }
                                } while (!input6.matches( "^[1-9]\\d{0,3}$" ));
                                flag = true;
                            } else if (input5.equals( "3" )) {
                                do {
                                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                                    input6 = scanner.nextLine();
                                    if (input6.matches( "^[1-9]\\d{0,3}$" )) {
                                        HOT.setFQuant( input6 );
                                        addFoodQuant.add( Integer.parseInt( HOT.getFQuant() ) );
                                        selectSalami( input4, Integer.parseInt( input3 ), HOT );
                                        System.out.println( "Užsakymas sėkmingai papildytas" );
                                    } else if (input6.equals( "0" )) {
                                        System.out.println( "Grįžtama į pagrindinį meniu" );
                                        break;
                                    } else {
                                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                                        System.out.println();
                                    }
                                } while (!input6.matches( "^[1-9]\\d{0,3}$" ));
                                flag = true;
                            } else if (input5.equals( "4" )) {
                                selectSalami( input4, Integer.parseInt( input3 ), NO_SAUCE );
                                flag = true;
                                System.out.println( "Užsakymas sėkmingai papildytas" );
                            } else if (input5.equals( "0" )) {
                                System.out.println( "Grįžtama į pagrindinį meniu" );
                                flag = true;
                            } else {
                                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą\n" );
                            }
                        } while (!flag);
                    } else if (input4.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        flag = true;
                    } else {
                        System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą\n" );
                    }
                } while (!flag);
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą\n" );
                break;
            }
        } while (!flag);
    }

    static void funghiAdd(String input3) {
        boolean flag = false;
        String input4, input5, input6;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {

                do {
                    //TODO keisti spausdinima
                    System.out.println( readFile( "foodmenu.txt", 3 ) );
                    input4 = scanner.nextLine();
                    if (input4.matches( "[1-3]" )) {

                        do {
                            //TODO keisti spausdinima
                            System.out.println( readFile( "saucemenu.txt", 1 ) );
                            input5 = scanner.nextLine();
                            if (input5.equals( "1" )) {
                                do {
                                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                                    input6 = scanner.nextLine();
                                    if (input6.matches( "^[1-9]\\d{0,3}$" )) {
                                        MILD.setFQuant( input6 );
                                        addFoodQuant.add( Integer.parseInt( MILD.getFQuant() ) );
                                        selectFunghi( input4, Integer.parseInt( input3 ), MILD );
                                        System.out.println( "Užsakymas sėkmingai papildytas" );
                                    } else if (input6.equals( "0" )) {
                                        System.out.println( "Grįžtama į pagrindinį meniu" );
                                        break;
                                    } else {
                                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                                        System.out.println();
                                    }
                                } while (!input6.matches( "^[1-9]\\d{0,3}$" ));
                                flag = true;
                            } else if (input5.equals( "2" )) {
                                do {
                                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                                    input6 = scanner.nextLine();
                                    if (input6.matches( "^[1-9]\\d{0,3}$" )) {
                                        MIX.setFQuant( input6 );
                                        addFoodQuant.add( Integer.parseInt( MIX.getFQuant() ) );
                                        selectFunghi( input4, Integer.parseInt( input3 ), MIX );
                                        System.out.println( "Užsakymas sėkmingai papildytas" );
                                    } else if (input6.equals( "0" )) {
                                        System.out.println( "Grįžtama į pagrindinį meniu" );
                                        break;
                                    } else {
                                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                                        System.out.println();
                                    }
                                } while (!input6.matches( "^[1-9]\\d{0,3}$" ));
                                flag = true;
                            } else if (input5.equals( "3" )) {
                                do {
                                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                                    input6 = scanner.nextLine();
                                    if (input6.matches( "^[1-9]\\d{0,3}$" )) {
                                        HOT.setFQuant( input6 );
                                        addFoodQuant.add( Integer.parseInt( HOT.getFQuant() ) );
                                        selectFunghi( input4, Integer.parseInt( input3 ), HOT );
                                        System.out.println( "Užsakymas sėkmingai papildytas" );
                                    } else if (input6.equals( "0" )) {
                                        System.out.println( "Grįžtama į pagrindinį meniu" );
                                        break;
                                    } else {
                                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                                        System.out.println();
                                    }
                                } while (!input6.matches( "^[1-9]\\d{0,3}$" ));
                                flag = true;
                            } else if (input5.equals( "4" )) {
                                selectFunghi( input4, Integer.parseInt( input3 ), NO_SAUCE );
                                flag = true;
                                System.out.println( "Užsakymas sėkmingai papildytas" );
                            } else if (input5.equals( "0" )) {
                                System.out.println( "Grįžtama į pagrindinį meniu" );
                                flag = true;
                            } else {
                                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą\n" );
                            }
                        } while (!flag);
                    } else if (input4.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        flag = true;
                    } else {
                        System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą\n" );
                    }
                } while (!flag);
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą\n" );
                break;
            }
        } while (!flag);
    }


    private static void emptyOrder() {
        clientsDishes.clear();
        clientsDrinks.clear();
        addDrinkQuant.clear();
        addFoodQuant.clear();
    }

    private static void printCheckout() {
        double sum = 0;
        int i = 0;
        int j = 0;
        DecimalFormat f = new DecimalFormat( "#0.00 €" );
        if (clientsDishes.size() != 0 || clientsDrinks.size() != 0) {

            System.out.println( "Jūsų sąskaita:" );
            System.out.println("----------------------------------------------------------------------------------------");

            for (Drink a : clientsDrinks) {
                System.out.println( a.getName() + ":  kaina: " + f.format( a.getPrice() ) +
                        ", kiekis: " + a.getQuantity() + ", suma: " + f.format( a.calculateItemPrice() ) );
                sum += a.calculateItemPrice();
                if (a.getDrinkAddPrice() != 0.0) {
                    System.out.println( a.getDrinkAddName() + ": kaina: " + f.format( a.getDrinkAddPrice() ) +
                            ", kiekis: " + addDrinkQuant.get( i ) + ", suma: " + f.format( (a.getDrinkAddPrice() * addDrinkQuant.get( i )) ) );
                    i++;
                } else {
                    System.out.println( "Be priedų: 0.00 €" );
                }
                if (addDrinkQuant.size() != 0) {
                    sum += a.getDrinkAddPrice() * addDrinkQuant.get( i - 1 );
                }
            }

            for (Food a : clientsDishes) {

                System.out.println( a.getName() + ":  kaina: " + f.format( a.getPrice() ) +
                        ", kiekis: " + a.getQuantity() + ", suma: " + f.format( a.calculateItemPrice() ) );
                sum += a.calculateItemPrice();
                if (a.getSaucePrice() != 0.0) {
                    System.out.println( a.getSaucename() + ": kaina: " + f.format( a.getSaucePrice() ) +
                            ", kiekis: " + addFoodQuant.get( j ) + ", suma: " + f.format( (a.getSaucePrice() * addFoodQuant.get( j )) ) );
                    j++;
                } else {
                    System.out.println( "Be padažo: 0.00 €" );
                }
                if (addFoodQuant.size() != 0) {
                    sum += a.getSaucePrice() * addFoodQuant.get( j - 1 );
                }
            }
            System.out.println( "Viso suma: " + f.format( sum ) );
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println( getDateTime() );
            System.out.println( getWaitTime() );
            emptyOrder();
        } else {
            System.out.println( "Jūs dar nieko neužsisakėte." );
        }
    }

    static void selectWater(String sort, int quantity, DrinkAddittion addition) {

        Drink drink1 = new Water( sort );
        drink1.setQuantity( quantity );
        drink1.setDrinkAddittion( addition );
        clientsDrinks.add( drink1 );
    }

    static void selectBeer(String sort, int quantity, DrinkAddittion addition) {
        Drink drink1 = new Beer( sort );
        drink1.setQuantity( quantity );
        drink1.setDrinkAddittion( addition );
        clientsDrinks.add( drink1 );
    }

    static void selectCoffee(int quantity, DrinkAddittion addition) {
        Drink drink1 = new Coffee();
        drink1.setQuantity( quantity );
        drink1.setDrinkAddittion( addition );
        clientsDrinks.add( drink1 );
    }

    static void selectTea(int quantity, DrinkAddittion addition) {
        Drink drink1 = new Tea();
        drink1.setQuantity( quantity );
        drink1.setDrinkAddittion( addition );
        clientsDrinks.add( drink1 );
    }

    static void selectWrap(String size, int quantity, Sauce sauce) {
        Food food1 = new PizzaWrap( size );
        food1.setQuantity( quantity );
        food1.setSauce( sauce );
        clientsDishes.add( food1 );
    }

    static void selectSalami(String size, int quantity, Sauce sauce) {
        Food food1 = new PizzaSalami( size );
        food1.setQuantity( quantity );
        food1.setSauce( sauce );
        clientsDishes.add( food1 );
    }

    static void selectFunghi(String size, int quantity, Sauce sauce) {
        Food food1 = new PizzaFunghi( size );
        food1.setQuantity( quantity );
        food1.setSauce( sauce );
        clientsDishes.add( food1 );
    }

    static void mainLogic(String input) {
        String input2;
        if (input.equals( "1" )) {
            do {
                printSubMenu( input );
                input2 = scanner.nextLine();
                if (input2.matches( "^[0-7]$" )) {
                    addDrink( input2 );
                    break;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą\n" );
                }
            } while (1 > 0);
        } else if (input.equals( "2" )) {
            do {
                printSubMenu( input );
                input2 = scanner.nextLine();
                if (input2.matches( "^[0-3]$" )) {
                    addFood( input2 );
                    break;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą\n" );
                }
            } while (1 > 0);
        } else if (input.equals( "3" )) {
            printSubMenu( input );
            emptyOrder();
        } else if (input.equals( "4" )) {
            printSubMenu( input );
            printCheckout();
        } else {
            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą" );
        }
    }

    static void pickQuantityAndWaterAdd(String input3, String sort) {
        boolean flag = false;
        String input4, input5;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                //TODO keisti spausdinima
                System.out.println( readFile( "drinkaddmenu.txt", 3 ) );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    do {
                        System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d{0,3}$" )) {
                            CITRINA.setQuant( input5 );
                            addDrinkQuant.add( Integer.parseInt( CITRINA.getQuant() ) );
                            selectWater( sort, Integer.parseInt( input3 ), CITRINA );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if (input5.equals( "0" )) {
                            System.out.println( "Grįžtama į pagrindinį meniu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d{0,3}$" ));
                    flag = true;

                } else if (input4.equals( "2" )) {
                    selectWater( sort, Integer.parseInt( input3 ), NONE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    System.out.println( "Grįžtama į pagrindinį meniu" );
                    flag = true;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą" );
                    System.out.println();
                }
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                System.out.println();
                break;
            }

        } while (!flag);
    }

    private static void pickQuantityAndBeerAdd(String input3, String sort) {
        boolean flag = false;
        String input4, input5;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                //TODO keisti spausdinima
                System.out.println( readFile( "drinkaddmenu.txt", 3 ) );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    do {
                        System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d{0,3}$" )) {
                            CITRINA.setQuant( input5 );
                            addDrinkQuant.add( Integer.parseInt( CITRINA.getQuant() ) );
                            selectBeer( sort, Integer.parseInt( input3 ), CITRINA );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if (input5.equals( "0" )) {
                            System.out.println( "Grįžtama į pagrindinį meniu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d{0,3}$" ));
                    flag = true;
                } else if (input4.equals( "2" )) {
                    selectBeer( sort, Integer.parseInt( input3 ), NONE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    System.out.println( "Grįžtama į pagrindinį meniu" );
                    flag = true;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą" );
                    System.out.println();
                }
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                System.out.println();
                break;
            }
        } while (!flag);
    }

    static void pickQuantityAndCoffeeAdd(String input3, String sort) {
        boolean flag = false;
        String input4, input5;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                //TODO keisti spausdinima
                System.out.println( readFile( "drinkaddmenu.txt", 1 ) );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    do {
                        System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d{0,3}$" )) {
                            selectCoffee( Integer.parseInt( input3 ), PIENAS );
                            PIENAS.setQuant( input5 );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if (input5.equals( "0" )) {
                            System.out.println( "Grįžtama į pagrindinį meniu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d{0,3}$" ));
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "2" )) {
                    do {
                        System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d{0,3}$" )) {
                            selectCoffee( Integer.parseInt( input3 ), CUKRUS );
                            CUKRUS.setQuant( input5 );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if (input5.equals( "0" )) {
                            System.out.println( "Grįžtama į pagrindinį meniu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d{0,3}$" ));
                    flag = true;
                } else if (input4.equals( "3" )) {
                    selectCoffee( Integer.parseInt( input3 ), NONE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    System.out.println( "Grįžtama į pagrindinį meniu" );
                    flag = true;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą" );
                    System.out.println();
                }
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                System.out.println();
                break;
            }
        } while (!flag);
    }

    static void pickQuantityAndTeaAdd(String input3, String sort) {
        boolean flag = false;
        String input4, input5;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                //TODO keisti spausdinima
                System.out.println( readFile( "drinkaddmenu.txt", 2 ) );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    do {
                        System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d{0,3}$" )) {
                            selectTea( Integer.parseInt( input3 ), MEDUS );
                            MEDUS.setQuant( input5 );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if (input5.equals( "0" )) {
                            System.out.println( "Grįžtama į pagrindinį meniu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d{0,3}$" ));
                    flag = true;
                } else if (input4.equals( "2" )) {
                    do {
                        System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d{0,3}$" )) {
                            selectTea( Integer.parseInt( input3 ), CUKRUS );
                            CUKRUS.setQuant( input5 );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if (input5.equals( "0" )) {
                            System.out.println( "Grįžtama į pagrindinį meniu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d{0,3}$" ));
                    flag = true;
                } else if (input4.equals( "3" )) {
                    selectTea( Integer.parseInt( input3 ), NONE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    System.out.println( "Grįžtama į pagrindinį meniu" );
                    flag = true;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą\n" );
                }
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą\n" );
                break;
            }
        } while (!flag);
    }

    //TODO keist si metoda arba ivest papildoma
    static String readFile(String file, int lineCount) {

        BufferedReader in = null;
        try {
            in = new BufferedReader( new FileReader( "C:\\Users\\karol\\IdeaProjects\\Picerija_3\\src\\pizzeria\\resources\\" + file ) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        for (int i = 0; i < lineCount; i++) {
            try {

                line = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] scores = line.split( "," );

        String menuLine = "";
        for (String s : scores) {
            menuLine += s + ", ";
        }

        return menuLine.replaceAll( ",\\s$", "" );
    }

    private static String getDateTime() {
        String timeStamp = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( Calendar.getInstance().getTime() );
        return timeStamp;
    }

    private static String getWaitTime() {
        customerCount += 1;
        if (customerCount < Math.floor( (fixTime() - time2) / 600000 )) { // 600 000 = 10 minutes, 10 000 = 10 secs.
            customerCount = 1;
        } else {
            customerCount -= Math.floor( (fixTime() - time2) / 600000 );
        }
        if (Math.floor( (fixTime() - time2) / 600000 ) != 0) {
            time2 = fixTime();
        }
        String timeExp = "Užsakymas bus paruoštas per " + customerCount * 10 + " minučių";
        return timeExp;
    }

    private static long fixTime() {
        return System.currentTimeMillis();
    }

}