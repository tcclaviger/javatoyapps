package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A class which creates a set of all the test results. It provides methods to search the results in the set
 * by various criteria to identify the failures and passes of certain tests or certain checkers.
 *
 * @author rob smith
 * @version 1.0
 */
public class AccessibilityResults {
    TreeSet<AccessibilityTest> testResults = new TreeSet<>();

    public AccessibilityResults(String fileInputLocation) {
        try (Scanner fileInput = new Scanner(new File(fileInputLocation))) {

            while (fileInput.hasNextLine()) {
                AccessibilityTest newTest = new AccessibilityTest(
                        fileInput.next(),//category
                        fileInput.next(),//googleresult
                        fileInput.next(),//waveresult
                        fileInput.next(),//sortsiteresult
                        fileInput.next(),//aslintresult
                        fileInput.nextLine());//description
                testResults.add(newTest);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found at " + fileInputLocation + " please check your file path.");
        } catch (NoSuchElementException e){
            System.out.println("Failure to create TreeSet. Contact Support Staff.");
        }
    }

    /**
     * Returns the size of the testResults set as an integer
     *
     * @return number of test records as integer
     */
    public String numTests() {
        return "Total Tests: "+testResults.size()+"\n";
    }

    /**
     * Takes in a search parameter as a String and searches all tests in set for matching
     * descriptions or descriptions which contain the search term, the builds a string and includes
     * total number of matches found and returns it all as a string.
     *
     * @param searchParameter String of search term
     * @return formatted string which displays all results and quantity found
     */
    public String showTestResults(String searchParameter) {
        StringBuilder sb = new StringBuilder();
        int numMatches = 0;

        for (AccessibilityTest test : testResults) {
            if (test.getDescription().toLowerCase().contains(searchParameter.toLowerCase())) {
                sb.append(test.toString() + "\n");
                numMatches++;
            }
        }

        sb.append("\nTotal tests with a description containing \""+searchParameter+"\": " + numMatches + "\n");
        return sb.toString();
    }

    /**
     * Takes in a search parameter as a String and searches all tests in set for matching
     * categories or categories which contain the search term, the builds a string and includes
     * total number of matches found and returns it all as a string.
     *
     * @param category String of search term
     * @return formatted string which displays all results and quantity found
     */
    public String showTestCategory(String category) {
        StringBuilder sb = new StringBuilder();
        int numMatches = 0;

        for (AccessibilityTest test : testResults) {
            if (test.getCategory().toLowerCase().contains(category.toLowerCase())) {
                sb.append(test.toString() + "\n");
                numMatches++;
            }
        }
        sb.append("\nTotal test with a category containing \""+category+ "\": " + numMatches + "\n");
        return sb.toString();
    }

    /**
     * Searches all tests in set for results where all the checkers failed to identify a
     * deficiency and returns the tests that failed all checks.
     *
     * @return formatted string which displays all results and quantity found
     */
    public String showAllFailed() {
        StringBuilder sb = new StringBuilder();
        int numMatches = 0;

        for (AccessibilityTest test : testResults) {
            if (test.getAslintResult().equals("notfound")   &&
                test.getGoogleResult().equals("notfound")   &&
                test.getWaveResult().equals("notfound")     &&
                test.getSortSiteResult().equals("notfound") ){
                sb.append(test.toString() + "\n");
                numMatches++;
            }
        }
        sb.append("\nTotal test failed: " + numMatches + "\n");
        return sb.toString();
    }

    /**
     * Method searches for all tests which contain the two search parameters; category and tester. If the
     * test checker contains the parameter checker and the test category contains the parameter category and the
     * test was a pass containing error or error_paid, it counts the result, returning the total number found with all conditions matching.
     *
     * @param category the category of test searching for
     * @param checker  the company checking
     * @return the total number of passed tests that include the category and checker
     */
    public String numPass(String category, String checker) {
        int numMatches = 0;

        //checks first if the category parameter provided matches any categories in the set. If a match is found
        //then it tests for the test website matching the checker parameter. If a match is found, it then checks
        //for the presence of error or error_paid, and if found increments numMatches to count number passed.
        for (AccessibilityTest test : testResults) {
            if (test.getCategory().toLowerCase().contains(category.toLowerCase())) {
                if (("google".contains(checker.toLowerCase())   && (test.getGoogleResult().contains("error")    || test.getGoogleResult().contains("error_paid")))      ||
                    ("wave".contains(checker.toLowerCase())     && (test.getWaveResult().contains("error")      || test.getWaveResult().contains("error_paid")))        ||
                    ("sortsite".contains(checker.toLowerCase()) && (test.getSortSiteResult().contains("error")  || test.getSortSiteResult().contains("error_paid")))    ||
                    ("aslint".contains(checker.toLowerCase())   && (test.getAslintResult().contains("error")    || test.getAslintResult().contains("error_paid")))      ){
                    numMatches++;
                }
            }
        }
        return "Total passing tests with matches of \""+category+"\" and \""+checker+"\" Found: " + numMatches +  "\n";
    }
}
