package model;
/**
 * F1Race class, a class inherited from BlueCard class, this class indicates all the state and behaviour of the F1Race.
 */
public class F1Race extends BlueCard {
    /**
     * The F1Race constructor that accepts a String career to be set.
     * @param career career, inherited from BlueCard class.
     */
    public F1Race(String career) {
        super(career);
    }
    /**
     * This is the method under BlueCard class, wherein the action of the F1Race blue card activates.
     * This also accepts an Object Player that is supposed to be the target by the action.
     * Moreover this method is inherited from the BlueCard class.
     * @param player the player target
     */
    @Override
    public void action(Player player) {

        amount = (int) (player.getSalary().getSalary() * 0.10);
        player.removeCash(amount);
    }
}