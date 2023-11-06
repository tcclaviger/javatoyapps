package io;

import stats.BookAnalytics;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Provides basic file io capabilities to read and
 * write from files in the project.
 *
 * @author Josh Archer
 * @author Rob Smith
 * @version 1.0
 */
public class FileIO {
    /**
     * Accepts a file path and reads the contents from
     * the file line-by-line into an ArrayList. Each
     * element in the list will correspond to a line in
     * the file.
     */
    private String path;
    private String title;

    public FileIO(String path, String title) {
        this.path = path;
        this.title = title;
    }

    /**
     * Builds the ArrayList line by line with each line being added as an element of the ArrayList.
     * @param path the path to the file being read
     * @return returns the ArrayList with each line as an element
     */
    public ArrayList<String> readFile(String path) {
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner reader = new Scanner(new FileInputStream((path)))) {
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading from file " + ex.getMessage());
        }
        return lines;
    }

    /**
     * Accepts a file path and Arraylist of strings and
     * writes the strings to the file. Any previous contents
     * in the file should be overwritten.
     *
     * @param path  the path to the text file
     * @param lines the ArrayList of strings to write to the
     *              input file
     */
    public void writeFile(String path, ArrayList<String> lines) {
        BookAnalytics bookAnalytics = new BookAnalytics(lines);
        int lengthOfWords =  bookAnalytics.wordCount();
        int lengthOfChars = bookAnalytics.letterCount();
        int lengthOfLines = bookAnalytics.lineCount();

        try (PrintWriter fileWriter = new PrintWriter(new FileOutputStream(path))) {
            fileWriter.println("Analytics for: " + title);
            fileWriter.println("----------------------------------------");
            fileWriter.println("Words Count: " + lengthOfWords);
            fileWriter.println("Letter Count: " + lengthOfChars);
            fileWriter.println("Line Count: " + lengthOfLines);
        } catch (IOException ex) {
            System.out.println("Error writing to file: "+ex.getMessage());
        }
    }

    /**
     * getter for the path
     * @return the path to the file
     */
    public String getPath() {
        return path;
    }

    /**
     * setter for the path
     * @param path the path to the file
     */
    public void setPath(String path) {
        this.path = path;
    }
}













