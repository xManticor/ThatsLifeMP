package model;
/**
 *  BlueCard card class, a class under Card class, this class indicates all the state and behaviour of the Blue Card.
 *
 */
public class BlueCard extends Card {

    protected String type = "Blue";
    protected int amount;
    protected String description;
    /**
     * This is an BlueCard standard constructor that accepts a String as a name that is to be assigned to the BlueCard.
     * @param name the name of the Blue Card to be assigned, also the name inherited from Card class.
     */
    public BlueCard(String name) {
        super(name);
    }

    /**
     * This method is for the condition of the BlueCard, then activates it.
     * This method accepts Player object. Player array object and a String.
     *
     * @param player the player who drawn the blue card.
     * @param otherplayers the other players besides the player who drawn the blue card.
     * @param career the career that is assigned to the blue card
     */
    public void blueCardCondition(Player player, Player[] otherplayers, String career) {

        if (isMatchWithCareer(player)) {

            player.addCash(15000);
        }

        else {

            player.removeCash(15000);
            if (findPlayerCareer(otherplayers, career) != null)
                findPlayerCareer(otherplayers, career).addCash(15000);
        }
    }
    /**
     * This is the method under BlueCard class, wherein the action of the BlueCard activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is to be inherited by the Child classes of the BlueCard class.
     * @param player the player target by the action of the Blue Card.
     */
    public void action(Player player) {
    }

    /**
     *  This method simply checks whether the player's matches the blue card's generated career.
     * @param player the player who drawn the blue card.
     * @return boolean, returns true or false. Returns true if player's career matches, otherwise it returns false.
     */

    public boolean isMatchWithCareer(Player player) {
        if (this.name.equals(player.getCareer().getName()))
            return true;
        else
            return false;
    }

    /**
     * This method runs in a loop to find the targeted player career.
     * 
     * @param otherplayers player list
     * @param career name of career
     * @return the player if same career is found, otherwise null.
     */

    public Player findPlayerCareer(Player[] otherplayers, String career) {
        for (int i = 0; i < otherplayers.length; i++) {
            if (career.equals(otherplayers[i].getCareer().getName()))
                return otherplayers[i];
        }
        return null;
    }

    /**
     * This method generates number that ranges from 1 to 49, then returns it.
     * 
     * @return random generated number
     */

    public int generateRandom(int lb, int ub) {

        return (int) Math.random() * (ub - lb + 1) + lb;
    }

}