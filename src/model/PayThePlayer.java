package model;
/**
 * This class is inherited from ACtionCard class
 */
public class PayThePlayer extends ActionCard implements PlayerToPlayer {
    /**
     * This is an PayThePlayer standard constructor that accepts a String as a name and an int as an amount that is to be assigned to the PayThePlayer card.
     * @param name the name of the PayThePlayer Card to be assigned, also the name inherited from ActionCard class.
     * @param amount the amount of the PayThePlayer Card to be assigned.
     */
    public PayThePlayer(String name, int amount) {
        super(name, amount);
    }

    /**
     * This is the method under ActionCard class, wherein the action of the PayThePlayer action card activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is inherited from the ActionCard class.
     * @param payer the player to pay the receiver
     * @param receiver the player to receive the amount
     */
    public void action(Player payer, Player receiver) {
        while(payer.getCash() < amount){
            payer.addLoan();
            payer.addCash(20000);
        }
        payer.removeCash(amount);
        receiver.addCash(amount);
    }

    /**
     * This method chooses the palyer
     * @param player the player to be chosen
     * @return Player
     */
    public Player choosePlayer(Player player, Player[] otherPlayers) {
        return player;
    }
}
