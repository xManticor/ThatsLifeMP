package model;

public class PayRaise extends GreenSpace {

    public PayRaise(String type) {
        super(type);
    }

    public void raiseSalary(Player player) {
        if (player.getRaiseCounter() != player.getMaxRaise()){
            player.addSalary(generateRandom(50000, 100000));
            player.addRaiseCounter();
        }

        player.addTaxDue(2000);
    }

    public int generateRandom(int lb, int ub) {

        return (int) Math.random() * (ub - lb + 1) + lb;
    }

}
