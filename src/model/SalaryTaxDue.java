package model;

public class SalaryTaxDue extends BlueCard {

    int amount;

    public SalaryTaxDue(String career) {
        super(career);
    }

    public void action(Player player) {
        amount = player.getTaxDue();
        player.removeCash(amount);
    }
}