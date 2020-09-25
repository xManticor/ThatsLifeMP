package model;

public class WorldCup extends BlueCard {

    public WorldCup(String career) {
        super(career);
    }

    public void action(Player player, Player[] players) {

        amount = players.length * 5000;
        player.removeCash(amount);
    }
}