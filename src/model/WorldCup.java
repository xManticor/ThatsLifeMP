package model;

/**
 * WorldCup class inherits BlueCard and its methods
 */
public class WorldCup extends BlueCard {

    /**
     * WorldCup constructor that takes in a String to be passed into super class
     * @param career career
     */
    public WorldCup(String career) {
        super(career);
    }

    /**
     * Executes the action which the player pays the players
     * Amount to be paid is number of players multiplied by 5000
     * @param player current player
     * @param players players to be paid
     */
    public void action(Player player, Player[] players) {

        amount = players.length * 5000;
        player.removeCash(amount);
    }
}