package model;

/**
 * The CollectFromBank class inherited from ActionCard class
 */
public class CollectFromBank extends ActionCard {

    /**
     * This is an CollectFromBank standard constructor that accepts a String as a name and an int as an amount that is to be assigned to the CollectFromBank card.
     * @param name the name of the CollectFromBank Card to be assigned, also the name inherited from ActionCard class.
     * @param amount the amount of the CollectFromBank Card to be assigned.
     */
    public CollectFromBank(String name, int amount) {
        super(name, amount);
    }
}
