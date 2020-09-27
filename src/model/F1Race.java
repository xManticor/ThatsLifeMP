package model;

public class F1Race extends BlueCard {

    public F1Race(String career) {
        super(career);
    }

    @Override
    public void action(Player player) {

        amount = (int) (player.getSalary().getSalary() * 0.10);
        player.removeCash(amount);
    }
}