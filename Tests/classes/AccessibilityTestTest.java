package classes;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class AccessibilityTestTest {

    private final AccessibilityTest testGoogle = new AccessibilityTest("SpecialTest", "notfound","error","notfound","error","A special test test case 1");
    private final AccessibilityTest testWave = new AccessibilityTest("SpecialTest2", "notfound","error","error","notfound","A special test test case 2");
    private final AccessibilityTest testSortsite = new AccessibilityTest("SpecialTest3", "notfound","error","notfound","notfound","A special test test case 3");
    private final AccessibilityTest testAslint = new AccessibilityTest("SpecialTest4", "error","error","notfound","notfound","A special test test case 4");

    @Test
    void getDescription() {
        assertEquals("A special test test case 1", testGoogle.getDescription());
        assertEquals("A special test test case 2", testWave.getDescription());
        assertEquals("A special test test case 3", testSortsite.getDescription());
        assertEquals("A special test test case 4", testAslint.getDescription());
    }

    @Test
    void getCategory() {
        assertEquals("SpecialTest", testGoogle.getCategory());
        assertEquals("SpecialTest2", testWave.getCategory());
        assertEquals("SpecialTest3", testSortsite.getCategory());
        assertEquals("SpecialTest4", testAslint.getCategory());
    }

    @Test
    void getGoogleResult() {
        assertEquals("notfound", testGoogle.getGoogleResult());
    }

    @Test
    void getWaveResult() {
        assertEquals("error", testWave.getWaveResult());
    }

    @Test
    void getSortSiteResult() {
        assertEquals("notfound", testSortsite.getSortSiteResult());
    }

    @Test
    void getAslintResult() {
        assertEquals("notfound", testAslint.getAslintResult());
    }
}