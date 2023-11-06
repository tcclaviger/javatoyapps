package program;

import io.Console;
import io.FileIO;
import java.io.File;
import java.util.ArrayList;

/**
 * This class represents the console program that
 * will allow users to open and analyze the contents
 * of e-books found with Project Gutenberg.
 *
 * @author Rob Smith
 * @author Josh Archer
 * @version 1.0
 */
public class PGConsoleProgram {
    public static void main(String[] args) {
        Console console = new Console();
        File filesDir = new File("./files/e-books");
        File statsDir = new File("./files/summaries");
        File[] contents = filesDir.listFiles();

        welcomeMessage();
        menuSystem(console, statsDir, contents);
    }

    /**
     * Displays the welcome message when starting the program.
     */
    public static void welcomeMessage() {
        String divider = "----------------------------------------";
        System.out.println("Welcome to Project Gutenberg Program");
        System.out.println(divider);
        System.out.println("""
                Project Gutenberg provides free e-books
                for books that have moved into the public
                domain. You can read more about the project
                here: https://www.gutenberg.org/""");
        System.out.println(divider);
    }

    /**
     * Displays the menu system and loops while the user hasn't chosen exit.
     * @param console console for user input
     * @param statsDir the directory of the book summaries
     * @param contents the array containing the contents of the filesDir
     */
    public static void menuSystem(Console console, File statsDir, File[] contents) {
        int menuChoiceNum = 0;
        while (menuChoiceNum >= 0) {
            System.out.println();
            System.out.println("1. Open a file");
            System.out.println("2. Print file");
            System.out.println("3. Exit");
            menuChoiceNum = console.getInt("");//Actually passed to the user method chosen in pickBookFromList()

            if(menuChoiceNum == 3){
                return; //The escape to exit the program
            }
            else{
                displayBooks(console, statsDir, contents, menuChoiceNum);
            }
        }
    }

    /**
     * Displays the book list for user to select from.
     * @param console console for user input
     * @param statsDir the directory of the book summaries
     * @param contents the array containing the contents of the filesDir
     * @param choice user menu choice
     */
    public static void displayBooks(Console console, File statsDir, File[] contents, int choice) {
        System.out.println();

        //if contents is empty print message, else print the book titles in the contents array
        if (contents.length == 0) {
            System.out.println("Directory is empty.");
        }
        for (int i = 0; i < contents.length; i++) {
            File listItem = contents[i];
            if (listItem.isFile()) {
                System.out.println(i + ": " + listItem.getName());
            }
        }
        pickBookFromList(console, statsDir, contents, choice);
    }

    /**
     * Gets user choice for book to analyze or print, does the arraylist creation, and then proceeds to chosen action by user
     * @param console console for user input
     * @param statsDir the directory of the book summaries
     * @param contents the array containing the contents of the filesDir
     * @param choice user menu choice
     */
    public static void pickBookFromList(Console console, File statsDir, File[] contents, int choice) {
        //get user book choice and return the title of the selected book and actions taken
        int bookNum = -1;
        while(bookNum == -1){
            try {
                bookNum = console.getInt("Enter a book number: ");
                if(bookNum >= contents.length || bookNum < 0){
                    throw new Exception();
                }
            } catch (Exception e) {
                bookNum = -1;
                System.out.println("Choice must be a number on the list of books:");
            }
        }
        File listItem = contents[bookNum];
        FileIO selectedFile = new FileIO(listItem.getAbsolutePath(),listItem.getName());
        ArrayList<String> bookLines = new ArrayList<>(selectedFile.readFile(selectedFile.getPath()));

        if(choice == 1){
            openFile(statsDir, listItem, bookLines, selectedFile);
        }
        else {
            printFile(bookLines);
        }
    }

    /**
     * Notifies the user the file was analyzed and then saves the analysis to the summaries directory
     * @param statsDir the directory of the book summaries
     * @param listItem the book from the contents array
     * @param bookLines the ArrayList that contains the book line by line
     * @param selectedFile the path to the file that was selected
     */
    public static void openFile(File statsDir, File listItem, ArrayList<String> bookLines, FileIO selectedFile) {
        //Gives the prescribed user feedback
        System.out.println("\nReading file: " + listItem.getName());
        System.out.println("Writing analytics for file: " + listItem.getName());
        //builds the output path for the analysis to be written to
        String outputPath = statsDir.getPath()+("\\"+listItem.getName());
        //passes the selected file and has the FileIO class write it to the summaries directory for that book
        selectedFile.writeFile(outputPath, bookLines);
    }

    /**
     * prints the book line by line with the line numbers appended to the beginning of each line
     * @param bookLines the ArrayList that contains the book line by line
     */
    private static void printFile(ArrayList<String> bookLines) {
        //prints the book line by line with line numbers
        System.out.println();
        for (int i = 0; i < bookLines.size(); i++) {
            System.out.println((i+1)+": "+bookLines.get(i));
        }
    }
}
