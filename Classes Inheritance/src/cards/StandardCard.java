package cards;

/**
 * Creates a card of the standard 52 card deck, using the suit and rank of the card.
 *
 * @author rob smith
 * @version 1.0
 */
public class StandardCard extends Card {
    private final String suit;
    private final String rank;

    /**
     * Constructor for the class.
     *
     * @param rank String of the card playing value aka 1-14
     * @param suit String of Clubs, Hearts, Diamonds, or Spades
     */
    public StandardCard(String cardText, String rank, String suit) {
        super(cardText);
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Getter for the rank of the card
     *
     * @return String of the value of the card, 1-14
     */
    public String getRank() {
        return rank;
    }

    /**
     * Getter for the suit of the card
     *
     * @return String of the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * toString method to provide the stringified value of the card in one call.
     *
     * @return String that has both rank and suit formatted for display
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
