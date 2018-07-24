package pizzeria;

import pizzeria.drinks.*;
import pizzeria.food.*;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static pizzeria.drinks.DrinkAddittion.*;
import static pizzeria.food.Sauce.*;


public class AllMethods {

    private static Scanner scanner = new Scanner( System.in );
    private static List<Drink> clientsDrinks = new ArrayList<>();
    private static List<Food> clientsDishes = new ArrayList<>();
    private static int customerCount;
    private static long time2 = fixTime();
    private static List<Integer> addDrinkQuant = new ArrayList<>();
    private static List<Integer> addFoodQuant = new ArrayList<>();
    private static double dailyIncome;
    static DecimalFormat f = new DecimalFormat( "#0.00 €" );


    static void printMainMenu() {
        System.out.println();
        System.out.println( "Pasirinkite kategoriją:" );
        System.out.println( "1. Gėrimų meniu,  2. Maisto meniu, 3. Anuliuoti užsakymą, 4. Gauti saskaitą, 0. Išeiti iš programos" );


    }

    private static void printSubMenu(String input) {

        switch (input) {
            case "1":
                System.out.println( "Pasirinkite gėrimus:" );
                System.out.println( readFile( "drinksmenu.txt", 1 ) );
                break;

            case "2":
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


    private static void addDrink(String input2) {
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
                    pickQuantityAndCoffeeAdd( input3 );
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
                    pickQuantityAndTeaAdd( input3 );
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

    private static void addFood(String input2) {

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

    private static void wrapAdd(String input3) {
        boolean flag = false;
        String input4, input5, input6;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                do {
                    System.out.println( readFile( "foodmenu.txt", 2 ) );
                    input4 = scanner.nextLine();
                    if (input4.matches( "[1-3]" )) {

                        do {
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
                                addFoodQuant.add( Integer.parseInt( NO_SAUCE.getFQuant() ) );
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

    private static void saliamiAdd(String input3) {
        boolean flag = false;
        String input4, input5, input6;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                do {
                    System.out.println( readFile( "foodmenu.txt", 4 ) );
                    input4 = scanner.nextLine();
                    if (input4.matches( "[1-3]" )) {

                        do {
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
                                addFoodQuant.add( Integer.parseInt( NO_SAUCE.getFQuant() ) );
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

    private static void funghiAdd(String input3) {
        boolean flag = false;
        String input4, input5, input6;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {

                do {
                    System.out.println( readFile( "foodmenu.txt", 3 ) );
                    input4 = scanner.nextLine();
                    if (input4.matches( "[1-3]" )) {

                        do {
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
                                addFoodQuant.add( Integer.parseInt( NO_SAUCE.getFQuant() ) );
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

    private static double printCheckout() {
        double sum = 0;
        int i = 0;
        int j = 0;
        String input;
        if (clientsDishes.size() != 0 || clientsDrinks.size() != 0) {

            System.out.println( "Jūsų sąskaita:" );
            System.out.println( "----------------------------------------------------------------------------------------" );

            for (Drink a : clientsDrinks) {
                System.out.println( a.getName() + ":  kaina: " + f.format( a.getPrice() ) +
                        ", kiekis: " + a.getQuantity() + ", suma: " + f.format( a.calculateItemPrice() ) );
                sum += a.calculateItemPrice();
                if (a.getDrinkAddPrice() != 0.0) {
                    System.out.println( a.getDrinkAddName() + ": kaina: " + f.format( a.getDrinkAddPrice() ) +
                            ", kiekis: " + addDrinkQuant.get( i ) + ", suma: " + f.format( (a.getDrinkAddPrice() * addDrinkQuant.get( i )) ) );
                } else {
                    System.out.println( "Be priedų: 0.00 €" );
                }
                sum += a.getDrinkAddPrice() * addDrinkQuant.get( i );

                i++;
            }

            for (Food a : clientsDishes) {

                System.out.println( a.getName() + ":  kaina: " + f.format( a.getPrice() ) +
                        ", kiekis: " + a.getQuantity() + ", suma: " + f.format( a.calculateItemPrice() ) );
                sum += a.calculateItemPrice();
                if (a.getSaucePrice() != 0.0) {
                    System.out.println( a.getSaucename() + ": kaina: " + f.format( a.getSaucePrice() ) +
                            ", kiekis: " + addFoodQuant.get( j ) + ", suma: " + f.format( (a.getSaucePrice() * addFoodQuant.get( j )) ) );
                } else {
                    System.out.println( "Be padažo: 0.00 €" );
                }
                sum += a.getSaucePrice() * addFoodQuant.get( j );

                j++;
            }
            System.out.println( "Viso suma: " + f.format( sum ) );
            System.out.println( "----------------------------------------------------------------------------------------" );

            System.out.println( "1.Patvirtinti užsakymą  0.Atšaukti" );

            do {
                input = scanner.nextLine();
                if (input.equals( "1" )) {
                    System.out.println( "Jūsų užsakymas bus paruoštas " + getDateTime() );
                    emptyOrder();
                    break;
                } else if (input.equals( "0" )) {
                    System.out.println( "Užsakymas anuliuotas." );
                    emptyOrder();
                    break;
                } else {
                    System.out.println( "Tokio pasirinkimo nėra" );
                }
            } while (!input.equals( "1" ) || !input.equals( "0" ));

            //System.out.println( "Jusu uzsakymas bus paruostas " + getDateTime() );
            //System.out.println( getWaitTime() );
            // emptyOrder();
        } else {
            System.out.println( "Jūs dar nieko neužsisakėte." );
        }
        return sum;
    }

    private static void selectWater(String sort, int quantity, DrinkAddittion addition) {

        Drink drink1 = new Water( sort );
        drink1.setQuantity( quantity );
        drink1.setDrinkAddittion( addition );
        clientsDrinks.add( drink1 );
    }

    private static void selectBeer(String sort, int quantity, DrinkAddittion addition) {
        Drink drink1 = new Beer( sort );
        drink1.setQuantity( quantity );
        drink1.setDrinkAddittion( addition );
        clientsDrinks.add( drink1 );
    }

    private static void selectCoffee(int quantity, DrinkAddittion addition) {
        Drink drink1 = new Coffee();
        drink1.setQuantity( quantity );
        drink1.setDrinkAddittion( addition );
        clientsDrinks.add( drink1 );
    }

    private static void selectTea(int quantity, DrinkAddittion addition) {
        Drink drink1 = new Tea();
        drink1.setQuantity( quantity );
        drink1.setDrinkAddittion( addition );
        clientsDrinks.add( drink1 );
    }

    private static void selectWrap(String size, int quantity, Sauce sauce) {
        Food food1 = new PizzaWrap( size );
        food1.setQuantity( quantity );
        food1.setSauce( sauce );
        clientsDishes.add( food1 );
    }

    private static void selectSalami(String size, int quantity, Sauce sauce) {
        Food food1 = new PizzaSalami( size );
        food1.setQuantity( quantity );
        food1.setSauce( sauce );
        clientsDishes.add( food1 );
    }

    private static void selectFunghi(String size, int quantity, Sauce sauce) {
        Food food1 = new PizzaFunghi( size );
        food1.setQuantity( quantity );
        food1.setSauce( sauce );
        clientsDishes.add( food1 );
    }

    static void mainLogic(String input, String inputX) {
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
        } else if (input.equals( "4")) {
            printSubMenu( input );
//            if(inputX.equals( password() )) {
                dailyIncome += printCheckout();
//            }
        } else if (input.equals( "0" )) {
            System.out.print( "" );
        } else {
            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą" );
        }
    }

    private static void pickQuantityAndWaterAdd(String input3, String sort) {
        boolean flag = false;
        String input4, input5;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
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
                    addDrinkQuant.add( Integer.parseInt( NONE.getQuant() ) );
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
                    addDrinkQuant.add( Integer.parseInt( NONE.getQuant() ) );
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

    private static void pickQuantityAndCoffeeAdd(String input3) {
        boolean flag = false;
        String input4, input5;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                System.out.println( readFile( "drinkaddmenu.txt", 1 ) );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    do {
                        System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d{0,3}$" )) {
                            PIENAS.setQuant( input5 );
                            addDrinkQuant.add( Integer.parseInt( PIENAS.getQuant() ) );
                            selectCoffee( Integer.parseInt( input3 ), PIENAS );
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
                            CUKRUS.setQuant( input5 );
                            addDrinkQuant.add( Integer.parseInt( CUKRUS.getQuant() ) );
                            selectCoffee( Integer.parseInt( input3 ), CUKRUS );
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
                    addDrinkQuant.add( Integer.parseInt( NONE.getQuant() ) );
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

    private static void pickQuantityAndTeaAdd(String input3) {
        boolean flag = false;
        String input4, input5;
        do {
            if (input3.matches( "^[1-9]\\d{0,3}$" )) {
                System.out.println( readFile( "drinkaddmenu.txt", 2 ) );
                input4 = scanner.nextLine();
                if (input4.equals( "1" )) {
                    do {
                        System.out.println( "Įveskite kiekį   0.Grįžti į pagrindinį meniu" );
                        input5 = scanner.nextLine();
                        if (input5.matches( "^[1-9]\\d{0,3}$" )) {
                            MEDUS.setQuant( input5 );
                            addDrinkQuant.add( Integer.parseInt( MEDUS.getQuant() ) );
                            selectTea( Integer.parseInt( input3 ), MEDUS );
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
                            CUKRUS.setQuant( input5 );
                            addDrinkQuant.add( Integer.parseInt( CUKRUS.getQuant() ) );
                            selectTea( Integer.parseInt( input3 ), CUKRUS );
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
                    addDrinkQuant.add( Integer.parseInt( NONE.getQuant() ) );
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

    public static String readFile(String file, int lineCount) {

        BufferedReader in = null;
        String line = "";
        String menuLine = "";
        String temp;


        try {
            in = new BufferedReader( new FileReader( "C:\\Users\\Donatos\\Desktop\\PizzaProject\\src\\pizzeria\\resources\\" + file ) );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < lineCount; i++) {
            try {

                line = in.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] scores = line.split( "," );

        String[] scores2 = new String[scores.length];
        Arrays.sort( scores );

        if (lineCount == 1 && file.equals( "drinkaddmenu.txt" )) {
            temp = scores[2];
            scores[2] = scores[3];
            scores[3] = temp;
        }

        if (scores[0].startsWith( "0" )) {
            for (int i = 0; i < scores2.length - 1; i++) {
                scores2[i] = scores[i + 1];
            }
            scores2[scores2.length - 1] = scores[0];

            for (String s : scores2) {
                menuLine += s + ", ";
            }
        } else {
            for (String s : scores) {
                menuLine += s + ", ";
            }
        }

        return menuLine.replaceAll( ",\\s$", "" );
    }


    private static String getDateTime() {

        return LocalDateTime.now().plusMinutes( 10 ).format( DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" ) );
    }

    // NENAUDOJAMAS
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

        return "Užsakymas bus paruoštas per " + customerCount * 10 + " minučių";
    }

    static void printDailyIncome() {
        String timeStamp = new SimpleDateFormat( "yyyy-MM-dd" ).format( Calendar.getInstance().getTime() );
        System.out.println( "Jūsų " + timeStamp + " dienos apyvarta: " + f.format( dailyIncome ) );
        System.out.println( timeStamp + " dienos pelnas: " + f.format( dailyIncome - (dailyIncome * 21 / 121) ) );
    }

    static String returnDate() {
        return new SimpleDateFormat( "yyyy-MM-dd " ).format( Calendar.getInstance().getTime() );
    }

    private static long fixTime() {
        return System.currentTimeMillis();
    }

    static Scanner getScanner() {
        return scanner;
    }

    static String password() {
        return "slapt2018";
    }

    static void writeDailyIncome() {
        try {
            BufferedWriter writeLog = new BufferedWriter( new FileWriter( "src\\pizzeria\\log\\log.txt", true ) );
            PrintWriter printLog = new PrintWriter( writeLog );
            if (dailyIncome != 0.0) {
                printLog.println( returnDate() + f.format( dailyIncome ) );
            }
            writeLog.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static double readPrices(String fileName, int lineToRead, int groups, String regex){

        String line = readFile (fileName, lineToRead);
        Pattern pattern = Pattern.compile( regex );
        Matcher stringMatcher = pattern.matcher( line );
        stringMatcher.find();
        return Double.parseDouble( stringMatcher.group(groups)) ;
    }

    public static String getRegex(int ItemsInMenu) {
        String regex = "";
        for(int i = 0; i < ItemsInMenu; i++) {
            regex += ".+\\s(\\d+\\.\\d{2})";
        }
        return regex;
    }
}
