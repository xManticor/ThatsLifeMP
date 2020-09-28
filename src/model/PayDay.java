package model;

/**
 * This class is inherited from GreenSPace class
 */
public class PayDay extends GreenSpace {
    /**
     * PayDay constructor this is where its' type is defined or created
     * @param type
     */
    public PayDay(String type) {
        super(type);
    }

    /**
     * This method gives the salary to the player
     * @param player player to be given salary.
     */
    public void giveSalary(Player player) {
        player.addCash(player.getPlayerSalary());
    }

}
