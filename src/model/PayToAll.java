package model;

public class PayToAll extends ActionCard {

    public PayToAll(String name, int amount) {
        super(name, amount);
    }

    // Not sure kung gagana pero walang errors HAHHA
    public void action(int amount, Player payer, Player[] receivers) {

        int numReceivers = 0;

        for (int i = 0; i < receivers.length; i++) {
            if (payer.getName() != receivers[i].getName()) {
                numReceivers++;
                while(payer.getCash() < amount){
                    payer.addLoan();
                    payer.addCash(20000);
                }
                receivers[i].addCash(amount);
            }
        }
        payer.removeCash(amount * numReceivers);
    }

}
