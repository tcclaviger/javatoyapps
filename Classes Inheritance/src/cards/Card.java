package cards;

/**
 * Parent class Card, provides a common ancestor for StandardCard and SetCard. This class contains a very
 * basic constructor and a singular field for cardText.
 *
 * @author rob smith
 * @version 1.0
 */
public class Card {
    private String cardText;

    /**
     * Constructor for the Card class.
     *
     * @param cardText the card text
     */
    public Card(String cardText) {
        this.cardText = cardText;
    }

    /**
     * Getter for the card description text
     *
     * @return the card text
     */
    public String getCardText() {
        return cardText;
    }

    /**
     * Overriding to String for the Card class
     *
     * @return the card text of the card
     */
    @Override
    public String toString() {
        return cardText;
    }
}
