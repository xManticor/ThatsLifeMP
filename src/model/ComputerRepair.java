package model;

/**
 * ComputerRepair class, a class inherited from BlueCard class, this class indicates all the state and behaviour of the ComputerRepair.
 */
public class ComputerRepair extends BlueCard {
    /**
     * The computer repair constructor that accepts a String career to be set.
     * @param career career
     */
    public ComputerRepair(String career) {
        super(career);
    }
    /**
     * This is the method under BlueCard class, wherein the action of the ComputerRepair blue card activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is inherited from the BlueCard class.
     * @param player the player target
     */
    @Override
    public void action(Player player) {

        if (generateRandom(1, 10) % 2 == 0) {
            amount = 5000;
            player.removeCash(amount);
        }

        else {
            amount = 10000;
            player.addCash(amount);
        }
    }
}