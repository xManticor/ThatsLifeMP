package model;

public class Lawsuit extends BlueCard {

    public Lawsuit(String career) {
        super(career);
    }

    public void action(Player player) {
        amount = generateRandom(5, 15) * 10000;
        player.removeCash(amount);
    }
}