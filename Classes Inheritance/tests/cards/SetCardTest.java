package cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests functionality of the SetCard class getters.
 */
class SetCardTest {
    private static SetCard cardOne;
    private static SetCard cardTwo;

    @BeforeAll
    static void createSetCards() {
        cardOne = new SetCard("One Red Striped Diamond, ", "Diamond", "Striped", "Red", 1);
        cardTwo = new SetCard("Two Orange Solid Oval", "Oval", "Solid", "Orange", 2);
    }

    @Test
    void getShape() {
        assertEquals("Diamond", cardOne.getShape());
        assertEquals("Oval", cardTwo.getShape());
    }

    @Test
    void getShading() {
        assertEquals("Striped", cardOne.getShading());
        assertEquals("Solid", cardTwo.getShading());
    }

    @Test
    void getColor() {
        assertEquals("Red", cardOne.getColor());
        assertEquals("Orange", cardTwo.getColor());
    }

    @Test
    void getNumber() {
        assertEquals(1, cardOne.getNumber());
        assertEquals(2, cardTwo.getNumber());
    }
}