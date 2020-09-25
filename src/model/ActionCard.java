package model;

public class ActionCard extends Card {
    String type = "Action";
    int amount;
    String name;

    public ActionCard(String name, int amount) {
        super(name);
        this.amount = amount;
    }

    public void action(int amount, Player target) {
        target.addCash(amount);
    }

    public int getAmount() {
        return amount;
    }
}
