package model;
/**
 * This class is inherited from ACtionCard class
 */
public class PayToAll extends ActionCard {
    /**
     * This is an PayToAll standard constructor that accepts a String as a name and an int as an amount that is to be assigned to the PayToAll card.
     * @param name the name of the PayToAll Card to be assigned, also the name inherited from ActionCard class.
     * @param amount the amount of the PayToAll Card to be assigned.
     */
    public PayToAll(String name, int amount) {
        super(name, amount);
    }
    /**
     * This is the method under ActionCard class, wherein the action of the PayToAll action card activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is inherited from the ActionCard class.
     * @param payer the player to pay the receiver
     * @param receivers the players to receive the amount
     */
    public void action(Player payer, Player[] receivers) {

        int numReceivers = 0;

        for (int i = 0; i < receivers.length; i++) {
            if (payer.getName() != receivers[i].getName()) {
                numReceivers++;
                while(payer.getCash() < amount){
                    payer.addLoan();
                    payer.addCash(20000);
                }
                receivers[i].addCash(amount);
            }
        }
        payer.removeCash(amount * numReceivers);
    }

}
