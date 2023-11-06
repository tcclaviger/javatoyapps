package driver;


/**
 * Test results analysis program to search the data file and parse user requested information from the list of results.
 * Provides methods accessed through AccessibilityResults object to identify data points.
 *
 * @author rob smith
 * @version 1.0
 */

import classes.AccessibilityResults;

public class Main {
    public static void main(String[] args) {
        String fileLocation = "./data/a11yResults.txt";
        AccessibilityResults results = new AccessibilityResults(fileLocation);

        //Quick check of all methods in AccessibilityResults class
        System.out.println(results.numTests());
        System.out.println(results.showTestResults("colO"));
        System.out.println(results.showTestCategory("oarD"));
        System.out.println(results.showAllFailed());
        System.out.println(results.numPass("oar", "gOog"));
    }
}
