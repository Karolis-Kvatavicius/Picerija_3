package pizzeria;

import java.util.Arrays;

import static pizzeria.AllMethods.*;
import static pizzeria.drinks.DrinkAddittion.CUKRUS;

public class PizzeriaMain {

    public static void main(String[] args) {
        String input, input2 = "";

        do {
            printMainMenu();
            input = getScanner().nextLine();
            if (input.equals( "0" )) {
                System.out.println( "Įveskite slaptažodį   X.Grįžti į pagrindinį meniu" );

                do {
                    input2 = getScanner().nextLine();
                    if (input2.equals( password() )) {
                        System.out.println( "Išeinama iš programos\n" );
                        printDailyIncome();
                        writeDailyIncome();
                        break;
                    } else if (input2.equalsIgnoreCase( "x" )) {
                        System.out.println( "Grįžtama į pagrindinį meniu" );
                        break;
                    } else {
                        System.out.println( "Slaptažodis neteisingas. Bandykite dar kartą arba X.Grįžti į pagrindinį meniu" );
                    }
                } while (1 > 0);
            }
            mainLogic( input, input2 );
        } while (!input2.equals( password() ));

    }
}