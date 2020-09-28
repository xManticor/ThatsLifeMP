package model;

/**
 * The PayTheBank class inherited from ActionCard class
 */
public class PayTheBank extends ActionCard {

    /**
     * This is an PayTheBank standard constructor that accepts a String as a name and an int as an amount that is to be assigned to the PayTheBank card.
     * @param name the name of the PayTheBank Card to be assigned, also the name inherited from ActionCard class.
     * @param amount the amount of the PayTheBank Card to be assigned.
     */
    public PayTheBank(String name, int amount) {
        super(name, amount);
    }
    /**
     * This is the method under ActionCard class, wherein the action of the PayTheBank action card activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is inherited from the ActionCard class.
     * @param target the player target.
     */
    public void action(Player target) {
        while(target.getCash() < amount){
            target.addLoan();
            target.addCash(20000);
        }
        target.removeCash(amount);
    }

}