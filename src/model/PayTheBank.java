package model;

public class PayTheBank extends ActionCard {

    public PayTheBank(String name, int amount) {
        super(name, amount);
    }

    public void action(int amount, Player target) {
        target.removeCash(amount);
    }

}