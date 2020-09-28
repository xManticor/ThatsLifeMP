package model;
/**
 * CollectFromAll class, a class under ActionCard, this class indicates all the state and behaviour of the CollectFromAll class.
 */
public class CollectFromAll extends ActionCard {

    /**
     * This is an CollectFromAll standard constructor that accepts a String as a name and an int as an amount that is to be assigned to the CollectFromAll card.
     * @param name the name of the CollectFromAll Card to be assigned, also the name inherited from ActionCard class.
     * @param amount the amount of the CollectFromAll Card to be assigned.
     */
    public CollectFromAll(String name, int amount) {
        super(name, amount);
    }
    /**
     * This is the method under ActionCard class, wherein the action of the CollectFromAll action card activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is inherited from the ActionCard class.
     * @param receiver the player to receive the amount to be paid by the players
     * @param payers the array of payers
     */
    public void action(Player receiver, Player[] payers) {

        int numPayers = 0;

        for (int i = 0; i < payers.length; i++) {
            if (receiver.getName() != payers[i].getName()) {
                numPayers++;
                while(amount > payers[i].getCash()){
                    payers[i].addLoan();
                    payers[i].addCash(20000);
                }
                payers[i].removeCash(amount);
            }
        }
        receiver.addCash(amount * numPayers);
    }

}
