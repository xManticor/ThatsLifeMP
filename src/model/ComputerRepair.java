package model;

public class ComputerRepair extends BlueCard {
    public ComputerRepair(String career) {
        super(career);
    }

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