package model;
/**
 * CollectFromAll class, a class under ActionCard, this class indicates all the state and behaviour of the CollectFromAll class.
 */
public class CollectFromPlayer extends ActionCard implements PlayerToPlayer {

    /**
     * This is an CollectFromPlayer standard constructor that accepts a String as a name and an int as an amount that is to be assigned to the CollectFromPlayer card.
     * @param name the name of the CollectFromPlayer Card to be assigned, also the name inherited from ActionCard class.
     * @param amount the amount of the CollectFromPlayer Card to be assigned.
     */
    public CollectFromPlayer(String name, int amount) {
        super(name, amount);
    }
    /**
     * This is the method under ActionCard class, wherein the action of the CollectFromPlayer action card activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is inherited from the ActionCard class.
     * @param payer the player to pay the amount to be receive by the receiver.
     * @param receiver the player to receive the amount to be paid by the payer.
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
     * This method chooses a player then returns it.
     * @param player the player to be chosen.
     * @return the player chosen.
     */
    public Player choosePlayer(Player player, Player[] otherPlayers) {
        return player;
    }
}
