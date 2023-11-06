package cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests functionality of the getters for the StandardCard class.
 */
class StandardCardTest {

    private static StandardCard cardOne;
    private static StandardCard cardTwo;

    @BeforeAll
    static void createSetCards() {
        cardOne = new StandardCard("Ace of Spades", "Ace", "Spades");
        cardTwo = new StandardCard("2 of Clubs", "2", "Clubs");
    }

    @Test
    void getRank() {
        assertEquals("Ace", cardOne.getRank());
        assertEquals("2", cardTwo.getRank());
    }

    @Test
    void getSuit() {
        assertEquals("Spades", cardOne.getSuit());
        assertEquals("Clubs", cardTwo.getSuit());
    }
}