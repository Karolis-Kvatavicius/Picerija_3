package pizzeria;

import jdk.dynalink.linker.ConversionComparator;
import pizzeria.drinks.*;
import pizzeria.food.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import static pizzeria.drinks.DrinkAddittion.*;
import static pizzeria.food.Sauce.*;

public class PizzeriaMain {

    private static Scanner scanner = new Scanner( System.in );
    private static List<Drink> clientsDrinks = new ArrayList<>();
    private static List<Food> clientsDishes = new ArrayList<>();
    //private static String[] menu = readFile( "menu2.txt" );
    private static int customerCount;
    private static long time2 = fixTime();
    private static List<Integer> addQuant = new ArrayList<>(  );

    public static void setCustomerCount(int customerCount) {
        PizzeriaMain.customerCount -= customerCount;
    }

    public static int getCustomerCount() {
        return customerCount;
    }

    public static void main(String[] args) throws IOException {
        String input;

        System.out.println(Arrays.toString( readFile( "foodmenu.txt" ) ));
        System.out.println();
        System.out.println(Arrays.toString( readFile( "drinksmenu.txt" ) ));
        System.out.println();

        do {

            printMainMenu();
            input = scanner.nextLine();
            if (input.equals( "0" )) {
                System.out.println( "Išeinama iš programos" );
                break;
            }
            mainLogic( input );
        } while (!input.equals( "0" ));
    }


    static void printMainMenu() {
        System.out.println();
        System.out.println( "Pasirinkite kategoriją : 1. Gėrimų menu,  2. Maisto menu," +
                " 3. Anuliuoti užsakymą, 4. Gauti saskaitą, 0. Išeiti iš programos." );


    }

    static void printSubMenu(String input) {

        switch (input) {
            case "1":
                System.out.println( "Pasirinkite gėrimus:" );
                System.out.println( "1. Vanduo, 2. Gazuotas vanduo, 3. Šviesus alus, 4. Tamsus alus, 5. Baltas alus, 6. Kava, 7. Arbata, 0. Išeiti į pagrindinį" );
                break;

            case "2":
                System.out.println( "Pasirinkite maistą:" );
                System.out.println( "1. Pica wrap, 2. Pica funghi, 3. Pica saliami, 0. Išeiti į pagrindinį" );
//                for (String item : menu) {
//                    if(item.startsWith( "4" )) {
//                        break;
//                    }
//                    System.out.print(item + ", ");
//                }
                break;

            case "3":
                System.out.println( "Jūsų užsakymas anuliuotas" );
                break;

            case "4":
                break;

            case "0":
                System.out.println( "Programa išjungta" );
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
                        System.out.println( "Grįžtama į pagrindinį menu" );
                        break;
                    }
                    pickQuantityAndWaterAdd( input3, "still" );
                } while (!input3.matches( "^[1-9]\\d*$" ));
                break;
            }
            case "2": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį menu" );
                        break;
                    }
                    pickQuantityAndWaterAdd( input3, "sparkling" );
                } while (!input3.matches( "^[1-9]\\d*$" ));
                break;
            }
            case "3": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį menu" );
                        break;
                    }
                    pickQuantityAndBeerAdd( input3, "light" );
                } while (!input3.matches( "^[1-9]\\d*$" ));
                break;
            }
            case "4": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį menu" );
                        break;
                    }
                    pickQuantityAndBeerAdd( input3, "dark" );
                } while (!input3.matches( "^[1-9]\\d*$" ));
                break;
            }
            case "5": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį menu" );
                        break;
                    }
                    pickQuantityAndBeerAdd( input3, "white" );
                } while (!input3.matches( "^[1-9]\\d*$" ));
                break;
            }

            case "6": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį menu" );
                        break;
                    }
                    pickQuantityAndCoffeeAdd( input3, "" );
                } while (!input3.matches( "^[1-9]\\d*$" ));
                break;
            }
            case "7": {
                do {
                    System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                    input3 = scanner.nextLine();
                    if (input3.equals( "0" )) {
                        System.out.println( "Grįžtama į pagrindinį menu" );
                        break;
                    }
                    pickQuantityAndTeaAdd( input3, "" );
                } while (!input3.matches( "^[1-9]\\d*$" ));
                break;
            }
            case "0": {
                System.out.println( "Išeinama į pagrindinį." );
                break;
            }
            default: {
                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                break;
            }
        }
    }

//    public static void addFood(String input2) {
//
//        String input3, input4;
//
//        switch (input2) {
//            case "1": {
//                boolean flag = false;
//                do {
//                    System.out.println( "Įveskite kiekį" );
//                    input3 = scanner.nextLine();
//                    if (input3.matches( "^[1-9]\\d*$" )) {
//                        System.out.println( "Pasirinkite padažą: 1.Švelnus, 2.Mix, 3.Aštrus, 0.Be padažo" );
//                        input4 = scanner.nextLine();
//                        if (input4.equals( "1" )) {
//                            selectPizza( "wrap", Integer.parseInt( input3 ), MILD );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else if (input4.equals( "2" )) {
//                            selectPizza( "wrap", Integer.parseInt( input3 ), MIX );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else if (input4.equals( "3" )) {
//                            selectPizza( "wrap", Integer.parseInt( input3 ), HOT );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else if (input4.equals( "0" )) {
//                            selectPizza( "wrap", Integer.parseInt( input3 ), NO_SAUCE );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else {
//                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
//                        }
//                    } else {
//                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
//                    }
//                } while (!flag);
//                break;
//            }
//            case "2": {
//                boolean flag = false;
//                do {
//                    System.out.println( "Įveskite kiekį" );
//                    input3 = scanner.nextLine();
//                    if (input3.matches( "^[1-9]\\d*$" )) {
//                        System.out.println( "Pasirinkite padažą: 1.Švelnus, 2.Mix, 3.Aštrus, 0.Be padažo" );
//                        input4 = scanner.nextLine();
//                        if (input4.equals( "1" )) {
//                            selectPizza( "salami", Integer.parseInt( input3 ), MILD );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else if (input4.equals( "2" )) {
//                            selectPizza( "salami", Integer.parseInt( input3 ), MIX );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else if (input4.equals( "3" )) {
//                            selectPizza( "salami", Integer.parseInt( input3 ), HOT );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else if (input4.equals( "0" )) {
//                            selectPizza( "salami", Integer.parseInt( input3 ), NO_SAUCE );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else {
//                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
//                        }
//                    } else {
//                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
//                    }
//                } while (!flag);
//                break;
//            }
//            case "3": {
//                boolean flag = false;
//                do {
//                    System.out.println( "Įveskite kiekį" );
//                    input3 = scanner.nextLine();
//                    if (input3.matches( "^[1-9]\\d*$" )) {
//                        System.out.println( "Pasirinkite padažą: 1.Švelnus, 2.Mix, 3.Aštrus, 0.Be padažo" );
//                        input4 = scanner.nextLine();
//                        if (input4.equals( "1" )) {
//                            selectPizza( "funghi", Integer.parseInt( input3 ), MILD );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else if (input4.equals( "2" )) {
//                            selectPizza( "funghi", Integer.parseInt( input3 ), MIX );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else if (input4.equals( "3" )) {
//                            selectPizza( "funghi", Integer.parseInt( input3 ), HOT );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else if (input4.equals( "0" )) {
//                            selectPizza( "funghi", Integer.parseInt( input3 ), NO_SAUCE );
//                            flag = true;
//                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                        } else {
//                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
//                        }
//                    } else {
//                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
//                    }
//                } while (!flag);
//                break;
//            }
//            case "0": {
//                System.out.println( "Išeinama į pagrindinį." );
//                break;
//            }
//            default: {
//                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
//                break;
//            }
//        }
//    }

    static void addFood(String input2) {

        String input3;
        switch (input2) {

            case "1": {
                System.out.println( "Įveskite kiekį" );
                input3 = scanner.nextLine();
                wrapAdd( input3 );
                break;
            }
            case "2": {
                System.out.println( "Įveskite kiekį" );
                input3 = scanner.nextLine();
                saliamiAdd( input3 );
                break;
            }
            case "3": {
                System.out.println( "Įveskite kiekį" );
                input3 = scanner.nextLine();
                funghiAdd( input3 );
                break;
            }

            case "0": {
                System.out.println( "Išeinama į pagrindinį." );
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
        String input4;
        String input5;
        do {
            if (input3.matches( "^[1-9]\\d*$" )) {
                System.out.println( "Pasirinkite picos dydį : 1. Maža, 2.Vidutinė, 3. Didelė" );
                input5 = scanner.nextLine();
                if (input5.matches( "[1-3]" )) {
                    System.out.println( "Pasirinkite padažą: 1.Švelnus, 2.Mix, 3.Aštrus, 0.Be padažo" );
                    input4 = scanner.nextLine();
                    if (input4.equals( "1" )) {
                        selectWrap( input5, Integer.parseInt( input3 ), MILD );
                        flag = true;
                        System.out.println( "Užsakymas sėkmingai papildytas" );
                    } else if (input4.equals( "2" )) {
                        selectWrap( input5, Integer.parseInt( input3 ), MIX );
                        flag = true;
                        System.out.println( "Užsakymas sėkmingai papildytas" );
                    } else if (input4.equals( "3" )) {
                        selectWrap( input5, Integer.parseInt( input3 ), HOT );
                        flag = true;
                        System.out.println( "Užsakymas sėkmingai papildytas" );
                    } else if (input4.equals( "0" )) {
                        selectWrap( input5, Integer.parseInt( input3 ), NO_SAUCE );
                        flag = true;
                        System.out.println( "Užsakymas sėkmingai papildytas" );
                    } else {
                        System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                    }
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                }
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                break;
            }
        } while (!flag);
    }

    static void saliamiAdd(String input3) {
        boolean flag = false;
        String input4;
        String input5;
        do {
            System.out.println( "Pasirinkite picos dydį : 1. Maža, 2.Vidutinė, 3. Didelė" );
            input5 = scanner.nextLine();
            if (input3.matches( "^[1-9]\\d*$" )) {
                System.out.println( "Pasirinkite padažą: 1.Švelnus, 2.Mix, 3.Aštrus, 0.Be padažo" );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    selectSalami( input5, Integer.parseInt( input3 ), MILD );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "2" )) {
                    selectSalami( input5, Integer.parseInt( input3 ), MIX );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "3" )) {
                    selectSalami( input5, Integer.parseInt( input3 ), HOT );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    selectSalami( input5, Integer.parseInt( input3 ), NO_SAUCE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                }
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
            }
        } while (!flag);
    }

    static void funghiAdd(String input3) {
        boolean flag = false;
        String input4;
        String input5;
        do {
            System.out.println( "Pasirinkite picos dydį : 1. Maža, 2.Vidutinė, 3. Didelė" );
            input5 = scanner.nextLine();
            if (input3.matches( "^[1-9]\\d*$" )) {
                System.out.println( "Pasirinkite padažą: 1.Švelnus, 2.Mix, 3.Aštrus, 0.Be padažo" );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    selectFunghi( input5, Integer.parseInt( input3 ), MILD );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "2" )) {
                    selectFunghi( input5, Integer.parseInt( input3 ), MIX );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "3" )) {
                    selectFunghi( input5, Integer.parseInt( input3 ), HOT );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    selectFunghi( input5, Integer.parseInt( input3 ), NO_SAUCE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                }
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
            }
        } while (!flag);
    }


    public static void emptyOrder() {
        clientsDishes.clear();
        clientsDrinks.clear();
        addQuant.clear();
    }

    public static void printCheckout() {
        double sum = 0;

        if(clientsDishes.size() != 0 || clientsDrinks.size() != 0) {
            System.out.println( "Jūsų sąskaita:" );
            for (Drink a: clientsDrinks) {
                for (Integer i : addQuant) {

                System.out.println( a.getName() + ":  kaina: " + a.getPrice() +
                        ", kiekis: " + a.getQuantity() + ", suma: " + a.calculateItemPrice() );
                sum += a.calculateItemPrice();
                System.out.println( a.getDrinkAddName() + ": kaina: " + a.getDrinkAddPrice() +
                            ", kiekis: " + i + ", suma: " + (a.getDrinkAddPrice() * Integer.parseInt( a.getDrinkAdd().getQuant() )) );
                sum += (a.getDrinkAddPrice() * i);
                }
            }
            for (Food a : clientsDishes) {

                System.out.println( a.getName() + ":  kaina: " + a.getPrice() +
                        ", kiekis: " + a.getQuantity() + ", suma: " + a.calculateItemPrice() );
                sum += a.calculateItemPrice();
                if (a.getSaucePrice() != 0) {
                    System.out.println( a.getSaucename() + ": kaina: " + a.getSaucePrice() +
                            ", kiekis: " + a.getQuantity() + ", suma: " + (a.getSaucePrice() * a.getQuantity()) );
                } else {
                    System.out.println( "Be padažo: 0.00 €" );
                }
                sum += (a.getSaucePrice() * a.getQuantity());

            }
            System.out.println( "Viso suma: " + sum );
            System.out.println( getDateTime() );
            System.out.println( getWaitTime() );
            emptyOrder();
        } else {
            System.out.println("Jūs dar nieko neužsisakėte.");
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

//    static void selectPizza(String sort, int quantity, Sauce sauce) {
//        if (sort.equals( "wrap" )) {
//            Food food1 = new PizzaWrap();
//            food1.setQuantity( quantity );
//            food1.setSauce( sauce );
//            clientsDishes.add( food1 );
//        } else if (sort.equals( "salami" )) {
//            Food food1 = new PizzaSalami();
//            food1.setQuantity( quantity );
//            food1.setSauce( sauce );
//            clientsDishes.add( food1 );
//        } else if (sort.equals( "funghi" )) {
//            Food food1 = new PizzaFunghi();
//            food1.setQuantity( quantity );
//            food1.setSauce( sauce );
//            clientsDishes.add( food1 );
//        }
//    }

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
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą.\n" );
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
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą.\n" );
                }
            } while (1 > 0);
        } else if (input.equals( "3" )) {
            printSubMenu( input );
            emptyOrder();
        } else if (input.equals( "4" )) {
            printSubMenu( input );
            printCheckout();
        } else {
            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
        }
    }

    static void pickQuantityAndWaterAdd(String input3, String sort) {
        boolean flag = false;
        String input4, input5;
        do {
            if (input3.matches( "^[1-9]\\d*$" )) {
                System.out.println( "Pasirinkite priedą: 1.Citrina, 2.Be priedų, 0.Grįžti į pagrindinį menu" );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    //TODO
                    do {
                        System.out.println("Įveskite kiekį   0.Grįžti į pagrindinį menu");
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d*$" )) {
                            CITRINA.setQuant( input5 );
                            addQuant.add( Integer.parseInt( CITRINA.getQuant() ))   ;
                            selectWater( sort, Integer.parseInt( input3 ), CITRINA);
                            System.out.println( "Užsakymas sėkmingai papildytas" );
//                            CITRINA.setQuant( "0" );
                        } else if(input5.equals( "0" )) {
                            System.out.println("Grįžtama į pagrindinį menu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d*$" ));
                    flag = true;

                } else if (input4.equals( "2" )) {
                    selectWater( sort, Integer.parseInt( input3 ), NONE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    System.out.println( "Grįžtama į pagrindinį menu" );
                    flag = true;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
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
            if (input3.matches( "^[1-9]\\d*$" )) {
                System.out.println( "Pasirinkite priedą: 1.Citrina, 2.Be priedų, 0.Grįžti į pagrindinį menu" );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    do {
                        System.out.println("Įveskite kiekį   0.Grįžti į pagrindinį menu");
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d*$" )) {
                            CITRINA.setQuant( input5 );
                            addQuant.add( Integer.parseInt( CITRINA.getQuant() ))   ;
                            selectBeer( sort, Integer.parseInt( input3 ), CITRINA);
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if(input5.equals( "0" )) {
                            System.out.println("Grįžtama į pagrindinį menu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d*$" ));
                    flag = true;
                } else if (input4.equals( "2" )) {
                    selectBeer( sort, Integer.parseInt( input3 ), NONE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    System.out.println( "Grįžtama į pagrindinį menu" );
                    flag = true;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
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
            if (input3.matches( "^[1-9]\\d*$" )) {
                System.out.println( "Pasirinkite priedą: 1.Pienas, 2.Cukrus, 3.Be priedų, 0.Grįžti į pagrindinį menu" );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    do {
                        System.out.println("Įveskite kiekį   0.Grįžti į pagrindinį menu");
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d*$" )) {
                            //TODO
                            selectCoffee(Integer.parseInt( input3 ), PIENAS );
                            PIENAS.setQuant( input5 );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if(input5.equals( "0" )) {
                            System.out.println("Grįžtama į pagrindinį menu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d*$" ));
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "2" )) {
                    do {
                        System.out.println("Įveskite kiekį   0.Grįžti į pagrindinį menu");
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d*$" )) {
                            selectCoffee(Integer.parseInt( input3 ), CUKRUS );
                            CUKRUS.setQuant( input5 );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if(input5.equals( "0" )) {
                            System.out.println("Grįžtama į pagrindinį menu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d*$" ));
                    flag = true;
                } else if (input4.equals( "3" )) {
                    selectCoffee( Integer.parseInt( input3 ), NONE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    System.out.println( "Grįžtama į pagrindinį menu" );
                    flag = true;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
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
            if (input3.matches( "^[1-9]\\d*$" )) {
                System.out.println( "Pasirinkite priedą: 1.Medus, 2.Cukrus, 3.Be priedų, 0.Grįžti į pagrindinį menu" );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    do {
                        System.out.println("Įveskite kiekį   0.Grįžti į pagrindinį menu");
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d*$" )) {
                            selectCoffee(Integer.parseInt( input3 ), MEDUS );
                            MEDUS.setQuant( input5 );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if(input5.equals( "0" )) {
                            System.out.println("Grįžtama į pagrindinį menu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d*$" ));
                    flag = true;
                } else if (input4.equals( "2" )) {
                    do {
                        System.out.println("Įveskite kiekį   0.Grįžti į pagrindinį menu");
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d*$" )) {
                            selectCoffee(Integer.parseInt( input3 ), CUKRUS );
                            CUKRUS.setQuant( input5 );
                            System.out.println( "Užsakymas sėkmingai papildytas" );
                        } else if(input5.equals( "0" )) {
                            System.out.println("Grįžtama į pagrindinį menu" );
                            break;
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                            System.out.println();
                        }
                    } while (!input5.matches( "^[1-9]\\d*$" ));
                    flag = true;
                } else if (input4.equals( "3" )) {
                    selectTea( Integer.parseInt( input3 ), NONE );
                    flag = true;
                    System.out.println( "Užsakymas sėkmingai papildytas" );
                } else if (input4.equals( "0" )) {
                    System.out.println( "Grįžtama į pagrindinį menu" );
                    flag = true;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą.\n" );
                }
            } else {
                System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą.\n" );
                break;
            }
        } while (!flag);
    }


    static String[] readFile(String file) throws IOException {

        BufferedReader in = null;
        try {
            in = new BufferedReader( new FileReader( "C:\\Users\\karol\\IdeaProjects\\Picerija_3\\src\\pizzeria\\resources\\" + file ) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = "";
        try {
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] scores = line.split( "," );

        System.out.println(Arrays.toString( scores ));
        Arrays.sort( scores);

        return scores;
    }

    private static String getDateTime() {
        String timeStamp = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( Calendar.getInstance().getTime() );
        return timeStamp;
    }

    private static String getWaitTime() {
        customerCount += 1;
        if (customerCount < Math.floor( (fixTime() - time2) / 10000 )) { // 600 000 = 10 minutes, now it is 10 secs.
            customerCount = 1;
        } else {
            customerCount -= Math.floor( (fixTime() - time2) / 10000 );
        }
        if (Math.floor( (fixTime() - time2) / 10000 ) != 0) {
            time2 = fixTime();
        }
        String timeExp = "Užsakymas bus paruoštas per " + customerCount * 10 + " minučių";
        return timeExp;
    }

    private static long fixTime() {
        return System.currentTimeMillis();
    }


}