package model;

public class TipTheServer extends BlueCard {

    public TipTheServer(String career) {
        super(career);
    }

    public void action(Player player) {
        amount = generateRandom(1, 10) * 1000;
        player.removeCash(amount);
    }

}