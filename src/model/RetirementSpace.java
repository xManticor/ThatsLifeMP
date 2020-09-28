package model;

import javafx.scene.paint.Color;

public class RetirementSpace extends Space {

    public RetirementSpace(String type) {
        super(type, Color.MAGENTA);
    }

    public void retirePlayer(Player player) {
        addPlayer(player);
        //Retirement pay
        if(player.getName().equals(getPlayers().get(0).getName())) {
                player.addCash(100000);
            }
        else if(player.getName().equals(getPlayers().get(1).getName())) {
                player.addCash(50000);
            }
        else if(player.getName().equals(getPlayers().get(2).getName())) {
                player.addCash(20000);
            }
        //Number of children
        player.addCash(player.getChildren() * 10000);

        //Sell house
        player.addCash(player.getHouse().getValue());

        //Loans with interest
        player.payLoan(player.getLoan()/25000);


    }
}
