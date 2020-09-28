package model;

/**
 *  ActionCard card class, a class under Card class, this co
 */
public class ActionCard extends Card {

    protected String type = "Action";
    protected int amount;
    protected String name;

    /**
     * ActionCard standard constructor accepting a
     * @param name of the Action Card
     */
    public ActionCard(String name) {
        super(name);
    }

    public ActionCard(String name, int amount) {
        super(name);
        this.amount = amount;
    }

    public void action(Player target) {
        target.addCash(getAmount());
    }

    public int getAmount() {
        return amount;
    }
}
