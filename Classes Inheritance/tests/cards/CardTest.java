package cards;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests functionality of the Card class getters.
 */
class CardTest {
    private static Card joker;
    private static Card rulesInsert;
    private static Card spadesKing;

    @BeforeAll
    static void createCards() {
        joker = new Card("Joker of Jokers");
        rulesInsert = new Card("The copywriter notice card");
        spadesKing = new Card("King of Spades");
    }

    @Test
    void getCardText() {
        assertEquals("Joker of Jokers", joker.getCardText());
        assertEquals("The copywriter notice card", rulesInsert.getCardText());
        assertEquals("King of Spades", spadesKing.getCardText());
    }
}