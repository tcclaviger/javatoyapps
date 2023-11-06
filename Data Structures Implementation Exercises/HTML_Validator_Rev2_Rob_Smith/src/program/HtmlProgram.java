package program;

import validator.Validator;

import java.io.File;
import java.util.Scanner;

/**
 * Contains a console program that reports on whether
 * the HTML files in the examples directory contain
 * valid HTML or not.
 *
 * @author Rob Smith
 * @version 1.1
 */
public class HtmlProgram {
    public static void main(String[] args) {
        welcomeMessage();
        menuSelect();
    }

    private static void welcomeMessage() {
        System.out.println("Welcome to my HTML Validator!");
        System.out.println("-----------------------------");
    }

    private static void menuSelect() {
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    1. Analyze valid files
                    2. Analyze invalid files
                    3. Exit""");
            int menuChoice = getInt(console);

            if (menuChoice == 3) {
                System.out.println("Exiting HTML Validator");
                console.close();
                return;
            } else {
                displayValidator(menuChoice);
            }
        }
    }

    private static void displayValidator(int menuChoice) {
        boolean isValid = false;
        File invalidDir = new File("./examples/invalid");
        File validDir = new File("./examples/valid");
        File[] invalidContents = invalidDir.listFiles();
        File[] validContents = validDir.listFiles();
        File[] testContents = validContents;
        if (menuChoice == 2) testContents = invalidContents;
        if (testContents == null) return;

        for (File file : testContents) {
            Validator tester = new Validator(String.valueOf(file));
            isValid = tester.isValid();
            System.out.println("File is valid: " + isValid);
        }
    }

    private static int getInt(Scanner console) {
        while (!console.hasNextInt()) {
            System.out.println("Please enter a valid number: ");
            console.nextLine();
        }
        int result = console.nextInt();
        console.nextLine();
        if (result > 0 && result < 4) {
            return result;
        } else {
            System.out.println("Not a valid menu option.");
            return 0;
        }
    }
}
