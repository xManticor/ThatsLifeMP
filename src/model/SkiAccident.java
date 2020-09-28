package model;

/**
 * SkiAccident Class that inherits BlueCard
 */
public class SkiAccident extends BlueCard {

    /**
     * SkiAccident constructor that takes in a String that will be passed to its superclass
     * @param career career
     */
    public SkiAccident(String career) {
        super(career);
    }

    /**
     * Executes the action of the card
     * Player pays the amount of 10000
     * @param player current player
     */
    public void action(Player player) {
        amount = 10000;
        player.removeCash(amount);
    }
}