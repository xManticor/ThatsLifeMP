package model;
/**
 * This class is inherited from GreenSPace class
 */
public class PayRaise extends GreenSpace {
    /**
     * PayRaise constructor this is where its' type is defined or created
     * @param type
     */
    public PayRaise(String type) {
        super(type);
    }
    /**
     * This method gives the salary raise to the player
     * @param player player to be given raise.
     */
    public void raiseSalary(Player player) {
        if (player.getRaiseCounter() != player.getMaxRaise()){
            player.addSalary(generateRandom(50000, 100000));
            player.addRaiseCounter();
        }

        player.addTaxDue(2000);
    }

    /**
     * This generates random number
     * @param lb lowerbound of the range
     * @param ub upperbound of the range
     * @return int
     */
    public int generateRandom(int lb, int ub) {

        return (int) Math.random() * (ub - lb + 1) + lb;
    }

}
