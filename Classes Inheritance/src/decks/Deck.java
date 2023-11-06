package decks;

import cards.Card;

import java.util.*;

/**
 * Deck class tracks what cards are in the dealer deck and which are in the discard deck via
 * arraylists of Card class objects.
 *
 * @author rob smith
 * @version 1.0
 */
public class Deck {
    private ArrayList<Card> dealerPile = new ArrayList<>();
    private ArrayList<Card> discardPile = new ArrayList<>();

    /**
     * Constructor for the Deck
     */
    public Deck() {
    }

    /**
     * Adds the card to the dealer pile
     *
     * @param card a card object to add
     */
    public void addCard(Card card) {
        dealerPile.add(card);
    }

    /**
     * Moves all Card objects in the discard pile to the dealer pile, then shuffles the
     * order of the Card objects within the dealer pile a random number of times, between 1 and 5.
     */
    public void shuffle() {
        dealerPile.addAll(discardPile);
        discardPile.clear();
        Random rand = new Random();
        for (int i = 0; i < rand.nextInt(1, 5); i++) {
            Collections.shuffle(dealerPile);
        }
    }

    /**
     * Deals the top card (zero position of the dealer pile arraylist), moves it to the discard pile, removes it from
     * the dealer pile and returns the dealt card.
     *
     * @return the dealt card as a Card object.
     */
    public Card dealTopCard() {
        //Try Catch is present to handle case of deck building failure
        try {
            Card dealtCard = dealerPile.get(0);
            discardPile.add(dealerPile.get(0));
            dealerPile.remove(0);
            return dealtCard;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Game deck is empty, cannot deal a card.");
            return null;
        }
    }

    /**
     * Getter for the count of the dealer pile arraylist.
     *
     * @return int value of the dealer pile arraylist size.
     */
    public int cardCount() {
        return dealerPile.size();
    }

    @Override
    public String toString() {
        if (dealerPile.size() == 0) {
            return "No deck to display, deck must be constructed.";
        }
        StringBuilder builder = new StringBuilder();

        //Builds the Deck print string
        builder.append(cardCount() + " cards in deck\n*****************\n");
        for (Card cards : dealerPile) {
            builder.append(cards.toString()).append("\n");
        }

        //Builds the Discard print string
        builder.append("\n").append(52 - cardCount() + " cards in discard\n*****************\n");
        for (Card cards : discardPile) {
            builder.append(cards.toString()).append("\n");
        }

        //Returns the String value of the StringBuilder builder object
        return builder.toString();
    }
}
