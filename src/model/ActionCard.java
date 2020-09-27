package model;

public class ActionCard extends Card {

    String type = "Action";
    int amount;
    String name;

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
