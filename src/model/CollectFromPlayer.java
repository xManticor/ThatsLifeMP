package model;

public class CollectFromPlayer extends ActionCard implements PlayerToPlayer {

    public CollectFromPlayer(String name) {
        super(name);
    }

    public CollectFromPlayer(String name, int amount) {
        super(name, amount);
    }

    public void action(Player payer, Player receiver) {
        while(payer.getCash() < amount){
            payer.addLoan();
            payer.addCash(20000);
        }
        payer.removeCash(amount);
        receiver.addCash(amount);
    }

    public Player choosePlayer(Player player) {
        return player;
    }
}
