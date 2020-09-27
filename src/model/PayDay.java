package model;

public class PayDay extends GreenSpace {

    public PayDay(String type) {
        super(type);
    }

    public void giveSalary(Player player) {
        player.addCash(player.getPlayerSalary());
    }

    @Override
    public String toString() {
        return "";
    }

}
