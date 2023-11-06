package decks;

import cards.Card;
import cards.StandardCard;

import java.util.*;

/**
 * Builds a StandardDeck that creates a standard 52 card playing deck and provides a means to deal cards.
 *
 * @author rob smith
 * @version 1.0
 */
public class StandardDeck extends Deck {
    /**
     * Builds a standard 52 card playing deck.
     */
    public StandardDeck() {
        ArrayList<String> cardSuits = new ArrayList<>();
        Collections.addAll(cardSuits, "Hearts", "Spades", "Diamonds", "Clubs");
        ArrayList<String> cardValues = new ArrayList<>();
        Collections.addAll(cardValues, "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace");

        for (String s : cardSuits) {
            for (String v : cardValues) {
                StandardCard newCard = new StandardCard(v + " of " + s, v, s);
                this.addCard(newCard);
            }
        }
    }

    /**
     * Hides Deck dealTopCard method and deals the card, casting the returned Card into a StandardCard, then returning
     * the StandardCard to the caller.
     *
     * @return StandardCard that was returned as the top card
     */
    public StandardCard dealTopCard() {
        Card dealtCard = super.dealTopCard();
        return ((StandardCard) dealtCard);
    }
}