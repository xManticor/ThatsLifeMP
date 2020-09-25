package model;

public class CollectFromAll extends ActionCard {

    public CollectFromAll(String name, int amount) {
        super(name, amount);
    }

    public void action(int amount, Player receiver, Player[] payers) {

        int numPayers = 0;

        for (int i = 0; i < payers.length; i++) {
            if (receiver.getName() != payers[i].getName()) {
                numPayers++;
                payers[i].removeCash(amount);
            }
        }
        receiver.addCash(amount * numPayers);
    }

}
