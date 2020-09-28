package model;

/**
 * SalaryTaxDue class that inherits BlueCard
 */
public class SalaryTaxDue extends BlueCard {

    protected int amount;

    /**
     * SalaryTaxdue constructor that takes in a String that's passed to its superclass
     * @param career career
     */
    public SalaryTaxDue(String career) {
        super(career);
    }

    /**
     * Executes the action
     * Player pays the amount of his TaxDue
     * @param player current player
     */
    public void action(Player player) {
        amount = player.getTaxDue();
        player.removeCash(amount);
    }
}