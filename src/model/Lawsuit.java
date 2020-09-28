package model;
/**
 * Lawsuit class, a class inherited from BlueCard class, this class indicates all the state and behaviour of the Lawsuit.
 */
public class Lawsuit extends BlueCard {
    /**
     * The Lawsuit that accepts a String career to be set.
     * @param career career
     */
    public Lawsuit(String career) {
        super(career);
    }
    /**
     * This is the method under BlueCard class, wherein the action of the Lawsuit blue card activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is inherited from the BlueCard class.
     * @param player the player target
     */
    public void action(Player player) {
        amount = generateRandom(5, 15) * 10000;
        player.removeCash(amount);
    }
}