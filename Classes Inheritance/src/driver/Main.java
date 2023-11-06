package driver;

import decks.Deck;
import decks.StandardDeck;
import java.util.Scanner;

/**
 * Driver for the cardDeck project. Provides a user driven menu from which the user can
 * perform various activites with the deck of cards.
 *
 * @author rob smith
 * @version 1.0
 */
public class Main {
    /**
     * This method displays a menu of options for the user
     */
    public static void displayMenu() {
        System.out.println();
        System.out.println("Welcome to my card deck program!");
        System.out.println("1.  Display deck status");
        System.out.println("2.  Deal top card of deck");
        System.out.println("3.  Shuffle Deck");
        System.out.println("4.  Exit.");
        System.out.println();
    }

    /**
     * Allows the user to navigate the program via a list of options.
     *
     * @param in Scanner to take user's menu choice
     */
    public static void userMenu(Deck gameDeck, Scanner in) {
        String choice = "";
        // while the user has not chosen to exit

        while (!choice.equals("4")) {

            displayMenu();

            // get user choice
            System.out.print("Enter your numerical choice: ");
            choice = in.next();
            System.out.println();

            switch (choice) {
                case "1":
                    System.out.println(gameDeck);
                    break;
                case "2":
                    System.out.println(gameDeck.dealTopCard());
                    break;
                case "3":
                    gameDeck.shuffle();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
            System.out.println();
        }
        System.out.println("Goodbye");
        in.close();
    }

    /**
     * Main method that drives the program.
     * @param args no arguments required or accounted for
     */
    public static void main(String[] args) {
        StandardDeck gameDeck = new StandardDeck();
        userMenu(gameDeck, new Scanner(System.in));
    }
}

