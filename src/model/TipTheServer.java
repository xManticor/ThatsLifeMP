package model;

/**
 * TipTheSever Class that inherits BlueCard
 */
public class TipTheServer extends BlueCard {

    /**
     * TipTheServer constructor that takes in a String to be passed onto the super class
     * @param career career
     */
    public TipTheServer(String career) {
        super(career);
    }

    /**
     * Executes the action of the card
     * Amount is generated from 1000 to 10000
     * Player pays the generated amount
     * @param player current player
     */
    public void action(Player player) {
        amount = generateRandom(1, 10) * 1000;
        player.removeCash(amount);
    }

}