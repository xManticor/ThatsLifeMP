package model;

public class PayThePlayer extends ActionCard implements PlayerToPlayer {

    public PayThePlayer(String name, int amount) {
        super(name, amount);
    }

    // Not sure kung gagana pero walang errors HAHHA
    public void action(int amount, Player payer, Player receiver) {
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
