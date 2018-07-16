package pizzeria;

import static pizzeria.AllMethods.getScanner;
import static pizzeria.AllMethods.mainLogic;
import static pizzeria.AllMethods.printMainMenu;

public class PizzeriaMain {

    public static void main(String[] args) {
        String input;

        do {
            printMainMenu();
            input = getScanner().nextLine();
            if (input.equals( "0" )) {
                System.out.println( "Išeinama iš programos\n" );
                break;
            }
            mainLogic( input );
        } while (!input.equals( "0" ));
    }
}