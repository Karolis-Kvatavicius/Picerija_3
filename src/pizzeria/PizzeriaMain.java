package pizzeria;

import pizzeria.drinks.*;
import pizzeria.food.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static pizzeria.drinks.DrinkAddittion.*;
import static pizzeria.food.Sauce.*;

public class PizzeriaMain {

    private static Scanner scanner = new Scanner( System.in );
    private static List<Drink> clientsDrinks = new ArrayList<>();
    private static List<Food> clientsDishes = new ArrayList<>();

    public static void main(String[] args) {
        
        String input, input2;

        do {
            printMainMenu();
            input = scanner.nextLine();
                if (input.equals( "1" )) {
                    do {
                        printSubMenu( input );
                        input2 = scanner.nextLine();
                        if (input2.matches( "^[0-7]$" )) {
                            addDrink( input2 );
                            break;
                        }
                        else {
                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą.\n" );
                        }
                    } while (1>0);
                } else if (input.equals( "2" )) {
                    do {
                        printSubMenu( input );
                        input2 = scanner.nextLine();
                        if (input2.matches( "^[0-3]$" )) {
                            addFood( input2 );
                            break;
                        }
                        else {
                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą.\n" );
                        }
                    } while (1>0);
                } else if (input.equals( "3" )) {
                    printSubMenu( input );
                    emptyOrder();
                } else if (input.equals( "4" )) {
                    printSubMenu( input );
                    printCheckout();
                } else if (input.equals( "0" )) {
                    System.out.println("Išeinama iš programos");
                    break;
                }
                else {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                }
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
                System.out.println( "Pasirinkit maistą" );
                System.out.println( "1. Pica wrap, 2. Pica salami, 3. Pica funghi, 0. Išeiti į pagrindinį menu" );
                break;

            case "3":
                System.out.println( "Jūsų užsakymas anuliuotas" );
                break;

            case "4":
                System.out.println( "Jūsų čekis:" );
                break;

            case "0":
                System.out.println( "Programa išjungta" );
                break;

            default:
                System.out.println( "Tokio pasirinkimo nėra" );
        }
    }



    static void addDrink(String input2) {
        String input3, input4;
        switch (input2) {
            case "1": {
                boolean flag = false;
                do {
                    System.out.println( "Įveskite kiekį" );
                    input3 = scanner.nextLine();
                    if (input3.matches( "^[1-9]\\d*$" )) {
                        System.out.println( "Pasirinkite priedą: 1.Citrina, 0.Be priedų" );
                        input4 = scanner.nextLine();
                        if (input4.equals( "1" )) {
                            selectWater( "still", Integer.parseInt( input3 ), CITRINA );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else if (input4.equals( "0" )) {
                            selectWater( "still", Integer.parseInt( input3 ), NONE );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else {
                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                        }
                    } else {
                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                    }
                } while (!flag);
                break;
            }
            case "2": {
                boolean flag = false;
                do {
                    System.out.println( "Įveskite kiekį" );
                    input3 = scanner.nextLine();
                    if (input3.matches( "^[1-9]\\d*$" )) {
                        System.out.println( "Pasirinkite priedą: 1.Citrina, 0.Be priedų" );
                        input4 = scanner.nextLine();
                        if (input4.equals( "1" )) {
                            selectWater( "sparkling", Integer.parseInt( input3 ), CITRINA );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else if (input4.equals( "0" )) {
                            selectWater( "sparkling", Integer.parseInt( input3 ), NONE );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else {
                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                        }
                    } else {
                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                    }
                } while (!flag);
                break;
            }
            case "3": {
                boolean flag = false;
                do {
                    System.out.println( "Įveskite kiekį" );
                    input3 = scanner.nextLine();
                    if (input3.matches( "^[1-9]\\d*$" )) {
                        System.out.println( "Pasirinkite priedą: 1.Citrina, 0.Be priedų" );
                        input4 = scanner.nextLine();
                        if (input4.equals( "1" )) {
                            selectBeer( "light", Integer.parseInt( input3 ), CITRINA );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else if (input4.equals( "0" )) {
                            selectBeer( "light", Integer.parseInt( input3 ), NONE );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else {
                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                        }
                    } else {
                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                    }
                } while (!flag);
                break;
            }
            case "4": {
                boolean flag = false;
                do {
                    System.out.println( "Įveskite kiekį" );
                    input3 = scanner.nextLine();
                    if (input3.matches( "^[1-9]\\d*$" )) {
                        System.out.println( "Pasirinkite priedą: 1.Citrina, 0.Be priedų" );
                        input4 = scanner.nextLine();
                        if (input4.equals( "1" )) {
                            selectBeer( "dark", Integer.parseInt( input3 ), CITRINA );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else if (input4.equals( "0" )) {
                            selectBeer( "dark", Integer.parseInt( input3 ), NONE );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else {
                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                        }
                    } else {
                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                    }
                } while (!flag);
                break;
            }
            case "5": {
                boolean flag = false;
                do {
                    System.out.println( "Įveskite kiekį" );
                    input3 = scanner.nextLine();
                    if (input3.matches( "^[1-9]\\d*$" )) {
                        System.out.println( "Pasirinkite priedą: 1.Citrina, 0.Be priedų" );
                        input4 = scanner.nextLine();
                        if (input4.equals( "1" )) {
                            selectBeer( "white", Integer.parseInt( input3 ), CITRINA );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else if (input4.equals( "0" )) {
                            selectBeer( "white", Integer.parseInt( input3 ), NONE );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else {
                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                        }
                    } else {
                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                    }
                } while (!flag);
                break;
            }
            case "6": {
                boolean flag = false;
                do {
                    System.out.println( "Įveskite kiekį" );
                    input3 = scanner.nextLine();
                    if (input3.matches( "^[1-9]\\d*$" )) {
                        System.out.println( "Pasirinkite priedą: 1.Pienas, 2.Cukrus, 0.Be priedų" );
                        input4 = scanner.nextLine();
                        if (input4.equals( "1" )) {
                            selectCoffee( Integer.parseInt( input3 ), PIENAS );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else if (input4.equals( "2" )) {
                            selectCoffee( Integer.parseInt( input3 ), CUKRUS );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else if (input4.equals( "0" )) {
                            selectCoffee( Integer.parseInt( input3 ), NONE );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else {
                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                        }
                    } else {
                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                    }
                } while (!flag);
                break;
            }
            case "7": {
                boolean flag = false;
                do {
                    System.out.println( "Įveskite kiekį" );
                    input3 = scanner.nextLine();
                    if (input3.matches( "^[1-9]\\d*$" )) {
                        System.out.println( "Pasirinkite priedą: 1.Medus, 2.Cukrus, 0.Be priedų" );
                        input4 = scanner.nextLine();
                        if (input4.equals( "1" )) {
                            selectTea( Integer.parseInt( input3 ), MEDUS );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else if (input4.equals( "2" )) {
                            selectTea( Integer.parseInt( input3 ), CUKRUS );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else if (input4.equals( "0" )) {
                            selectTea( Integer.parseInt( input3 ), NONE );
                            flag = true;
                            System.out.println("Užsakymas sėkmingai papildytas");
                        } else {
                            System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                        }
                    } else {
                        System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                    }
                } while (!flag);
                break;
            }
            case "0": {
                System.out.println("Išeinama į pagrindinį.");
                break;
            }
            default: {
                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                break;
            }
        }
    }

        public static void addFood (String input2) {

            String input3, input4;

            switch (input2) {
                case "1": {
                    boolean flag = false;
                    do {
                        System.out.println( "Įveskite kiekį" );
                        input3 = scanner.nextLine();
                        if (input3.matches( "^[1-9]\\d*$" )) {
                            System.out.println( "Pasirinkite padažą: 1.Švelnus, 2.Mix, 3.Aštrus, 0.Be padažo" );
                            input4 = scanner.nextLine();
                            if (input4.equals( "1" )) {
                                selectPizza( "wrap", Integer.parseInt( input3 ), MILD );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else if (input4.equals( "2" )) {
                                selectPizza( "wrap", Integer.parseInt( input3 ), MIX );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else if (input4.equals( "3" )) {
                                selectPizza( "wrap", Integer.parseInt( input3 ), HOT );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else if (input4.equals( "0" )) {
                                    selectPizza( "wrap", Integer.parseInt( input3 ), NO_SAUCE );
                                    flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else {
                                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                            }
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                        }
                    } while (!flag);
                    break;
                }
                case "2": {
                    boolean flag = false;
                    do {
                        System.out.println( "Įveskite kiekį" );
                        input3 = scanner.nextLine();
                        if (input3.matches( "^[1-9]\\d*$" )) {
                            System.out.println( "Pasirinkite padažą: 1.Švelnus, 2.Mix, 3.Aštrus, 0.Be padažo" );
                            input4 = scanner.nextLine();
                            if (input4.equals( "1" )) {
                                selectPizza( "salami", Integer.parseInt( input3 ), MILD );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else if (input4.equals( "2" )) {
                                selectPizza( "salami", Integer.parseInt( input3 ), MIX );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else if (input4.equals( "3" )) {
                                selectPizza( "salami", Integer.parseInt( input3 ), HOT );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else if (input4.equals( "0" )) {
                                selectPizza( "salami", Integer.parseInt( input3 ), NO_SAUCE );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else {
                                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                            }
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                        }
                    } while (!flag);
                    break;
                }
                case "3": {
                    boolean flag = false;
                    do {
                        System.out.println( "Įveskite kiekį" );
                        input3 = scanner.nextLine();
                        if (input3.matches( "^[1-9]\\d*$" )) {
                            System.out.println( "Pasirinkite padažą: 1.Švelnus, 2.Mix, 3.Aštrus, 0.Be padažo" );
                            input4 = scanner.nextLine();
                            if (input4.equals( "1" )) {
                                selectPizza( "funghi", Integer.parseInt( input3 ), MILD );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else if (input4.equals( "2" )) {
                                selectPizza( "funghi", Integer.parseInt( input3 ), MIX );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else if (input4.equals( "3" )) {
                                selectPizza( "funghi", Integer.parseInt( input3 ), HOT );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else if (input4.equals( "0" )) {
                                selectPizza( "funghi", Integer.parseInt( input3 ), NO_SAUCE );
                                flag = true;
                                System.out.println("Užsakymas sėkmingai papildytas");
                            } else {
                                System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                            }
                        } else {
                            System.out.println( "Klaidingai nurodytas kiekis. Bandykite dar kartą" );
                        }
                    } while (!flag);
                    break;
                }
                case "0": {
                    System.out.println("Išeinama į pagrindinį.");
                    break;
                }
                default: {
                    System.out.println( "Tokio pasirinkimo nėra. Bandykite dar kartą." );
                    break;
                }
            }
        }

        public static void emptyOrder () {
            clientsDishes.clear();
            clientsDrinks.clear();
        }

        public static void printCheckout() {
            double sum = 0;
            for (Drink a : clientsDrinks) {
                try {
                    System.out.println( a.getName() + ":  kaina: " + a.getPrice() + ", kiekis: " + a.getQuantity() + ", suma: " + a.calculateItemPrice() );
                    sum += a.calculateItemPrice();
                    System.out.println( a.getDrinkAddName() + ": kaina: " + a.getDrinkAddPrice() + ", kiekis: " + a.getQuantity() + ", suma: " + (a.getDrinkAddPrice() * a.getQuantity()) );
                    sum += (a.getDrinkAddPrice() * a.getQuantity());
                } catch (NullPointerException e) {
                    System.out.println("Priedai: 0");
                }
            }
            for (Food a : clientsDishes) {
                try {
                    System.out.println( a.getName() + ":  kaina: " + a.getPrice() + ", kiekis: " + a.getQuantity() + ", suma: " + a.calculateItemPrice() );
                    sum += a.calculateItemPrice();
                    System.out.println( a.getSaucename() + ": kaina: " + a.getSaucePrice() + ", kiekis: " + a.getQuantity() + ", suma: " + (a.getSaucePrice() * a.getQuantity()) );
                    sum += (a.getSaucePrice() * a.getQuantity());
                } catch (NullPointerException e) {
                    System.out.println( "Priedai: 0" );
                }
            }
            System.out.println("Viso suma: " + sum);
            clientsDrinks.clear();
            clientsDishes.clear();

        }

        static void selectWater(String sort, int quantity, DrinkAddittion addition) {

            Drink drink1 = new Water( sort );
            drink1.setQuantity(quantity);
            drink1.setDrinkAddittion(addition);
            clientsDrinks.add( drink1 );
        }

        static void selectBeer(String sort, int quantity, DrinkAddittion addition) {
            Drink drink1 = new Beer( sort );
            drink1.setQuantity(quantity);
            drink1.setDrinkAddittion(addition);
            clientsDrinks.add( drink1 );
        }

    static void selectCoffee( int quantity, DrinkAddittion addition) {
        Drink drink1 = new Coffee();
        drink1.setQuantity(quantity);
        drink1.setDrinkAddittion(addition);
        clientsDrinks.add( drink1 );
    }

    static void selectTea( int quantity, DrinkAddittion addition) {
        Drink drink1 = new Tea();
        drink1.setQuantity(quantity);
        drink1.setDrinkAddittion(addition);
        clientsDrinks.add( drink1 );
    }

    static void selectPizza(String sort, int quantity, Sauce sauce) {
        if(sort.equals( "wrap" )) {
            Food food1 = new PizzaWrap();
            food1.setQuantity( quantity );
            food1.setSauce( sauce );
            clientsDishes.add( food1 );
        } else if (sort.equals( "salami" )) {
            Food food1 = new PizzaSalami();
            food1.setQuantity( quantity );
            food1.setSauce( sauce );
            clientsDishes.add( food1 );
        }  else if (sort.equals( "funghi" )) {
            Food food1 = new PizzaFunghi();
            food1.setQuantity( quantity );
            food1.setSauce( sauce );
            clientsDishes.add( food1 );
        }
    }
    }