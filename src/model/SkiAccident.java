package model;

public class SkiAccident extends BlueCard {

    public SkiAccident(String career) {
        super(career);
    }

    public void action(Player player) {
        amount = 10000;
        player.removeCash(amount);
    }
}