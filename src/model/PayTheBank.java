package model;

public class PayTheBank extends ActionCard {

    public PayTheBank(String name, int amount) {
        super(name, amount);
    }

    public void action(int amount, Player target) {
        while(target.getCash() < amount){
            target.addLoan();
            target.addCash(20000);
        }
        target.removeCash(amount);
    }

}