package classes;

/**
 * Class that tracks each test result as an object that can be querried and compared to other
 * test results to order in a TreeSet.
 * @author rob smith
 * @version 1.0
 */
public class AccessibilityTest implements Comparable<AccessibilityTest>{

    private final String description;
    private final String category;
    private final String googleResult;
    private final String waveResult;
    private final String sortSiteResult;
    private final String aslintResult;

    public AccessibilityTest(String category, String googleResult, String waveResult, String sortSiteResult, String aslintResult, String description) {
        this.description = description;
        this.category = category;
        this.googleResult = googleResult;
        this.waveResult = waveResult;
        this.sortSiteResult = sortSiteResult;
        this.aslintResult = aslintResult;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return returns the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return returns the google result
     */
    public String getGoogleResult() {
        return googleResult;
    }

    /**
     * @return returns the wave result
     */
    public String getWaveResult() {
        return waveResult;
    }

    /**
     * @return returns the sort site result
     */
    public String getSortSiteResult() {
        return sortSiteResult;
    }

    /**
     * @return returns the aslint result
     */
    public String getAslintResult() {
        return aslintResult;
    }

    @Override
    public String toString() {
        return "//Category: " + category + " // Description: " + description + "//   Google Result: " + googleResult +
                ", WAVE Result: " + waveResult + ", SortSite Result: " + sortSiteResult + ", ASLint Result: " + aslintResult;
    }

    @Override
    public int compareTo(AccessibilityTest o) {
        return this.description.compareTo(o.getDescription());
    }
}
