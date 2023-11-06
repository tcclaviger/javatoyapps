package cards;

/**
 * Set card class that builds a set card and provides getters and a toString method.
 *
 * @author rob smith
 * @version 1.0
 */
public class SetCard extends Card {
    private final String shape;
    private final String shading;
    private final String color;
    private final int number;

    /**
     * Constructor for the SetCard class, uses super to pass value to parent class for card text.
     *
     * @param cardText String field for the card text
     * @param shape    String for the shape of the card
     * @param shading  String for the shading of the card
     * @param color    String for the color of the card
     * @param number   int field for the number of card
     */
    public SetCard(String cardText, String shape, String shading, String color, int number) {
        super(cardText);
        this.shape = shape;
        this.shading = shading;
        this.color = color;
        this.number = number;
    }

    /**
     * Getter for the shape of the card
     *
     * @return String of the shape
     */
    public String getShape() {
        return shape;
    }

    /**
     * Getter for the shading of the card
     *
     * @return String of the shading
     */
    public String getShading() {
        return shading;
    }

    /**
     * Getter for the color of the card
     *
     * @return String of the color
     */
    public String getColor() {
        return color;
    }

    /**
     * Getter for the number of the card
     *
     * @return number of the card as an int
     */
    public int getNumber() {
        return number;
    }

    /**
     * Override toString for the setCard class
     *
     * @return String that contains all values of the card with formatting
     */
    @Override
    public String toString() {
        return shape + " " + shading + " " + color + " " + number + " " + super.toString();
    }
}
