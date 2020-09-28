package model;
/**
 *  HouseCard card class, a class under Card class, this class indicates all the state and behaviour of the House Card.
 *
 */
public class HouseCard extends Card {
    private String type = "House";
    private String name;
    private int value;
    /**
     * This is an HouseCard standard constructor that accepts a String as a name that is to be assigned to the HouseCard.
     * @param name the name of the House Card to be assigned, also the name inherited from Card class.
     */
    public HouseCard(String name, int value) {
        super(name);
        this.value = value;
    }

    /**
     * A getter method, returns the value of the house card.
     * @return value
     */
    public int getValue() {
        return this.value;
    }
}