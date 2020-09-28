package model;

/**
 * Card class, the parent of all types of card classes.
 */
public class Card {
    protected String type;
    protected String name;

    /**
     * This is an Card standard constructor that accepts a String as a name that is to be assigned to the Card.
     * @param name the name of the Card to be assigned.
     */
    public Card(String name) {
        this.name = name;
    }

    /**
     * A getter method. This method simply returns the name of the card.
     * @return the String name of the Card.
     */
    public String getName() {
        return name;
    }
}
