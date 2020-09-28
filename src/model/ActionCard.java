package model;

/**
 *  ActionCard card class, a class under Card class, this class indicates all the state and behaviour of the Action Card.
 *
 */
public class ActionCard extends Card {

    protected String type = "Action";
    protected int amount;
    protected String name;

    /**
     * This is an ActionCard standard constructor that accepts a String as a name that is to be assigned to the ActionCard.
     * @param name the name of the Action Card to be assigned, also the name inherited from Card class.
     */
    public ActionCard(String name) {

        super(name);
    }

    /**
     * This is an ActionCard standard constructor that accepts a String as a name and an int as an amount that is to be assigned to the ActionCard.
     * @param name the name of the Action Card to be assigned, also the name inherited from Card class.
     * @param amount the amount of the Action Card to be assigned.
     */
    public ActionCard(String name, int amount) {
        super(name);
        this.amount = amount;
    }

    /**
     * This is the method under ActionCard class, wherein the action of the ActionCard activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is to be inherited by the Child classes of the ActionCard class.
     * @param target the player target by the action of the Action Card.
     */
    public void action(Player target) {
        target.addCash(getAmount());
    }

    /**
     *  This method simply returns the ActionCard amount assigned.
     * @return the ActionCard amount.
     */
    public int getAmount() {
        return amount;
    }
}
