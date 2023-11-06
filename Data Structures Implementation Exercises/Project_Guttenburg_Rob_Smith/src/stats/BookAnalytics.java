package stats;

import java.util.ArrayList;

/**
 * Stores the lines of a book in an ArrayList
 * and calculates simple analytics on the text
 * * @author Josh Archer
 * * @author Rob Smith
 * * @version 1.0
 */
public class BookAnalytics {
    private ArrayList<String> bookLines;

    /**
     * Stores the list of lines found in the book.
     * @param bookLines the list of lines
     */
    public BookAnalytics(ArrayList<String> bookLines) {
        this.bookLines = bookLines;
    }

    /**
     * Returns the number of words found in the lines
     * of the book by splitting each line at a space and counting.
     * Note: To make this calculation simpler, you can
     * ignore punctuation when implementing the method.
     * @return the word count
     */
    public int wordCount() {
        int totalWords = 0;
        for (String line : bookLines) {
            totalWords += line.split(" ").length;
        }
        return totalWords;
    }

    /**
     * Returns the number of letters found in the lines
     * of the book.
     *
     * @return the letter count
     */
    public int letterCount() {
        int charCount = 0;
        for (String line : bookLines) {
            charCount += line.length();
        }
        return charCount;
    }

    /**
     * Returns the number of lines in the book.
     *
     * @return the line count
     */
    public int lineCount() {
        return bookLines.size();
    }
}
