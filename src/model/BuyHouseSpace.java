package model;

public class BuyHouseSpace extends MagentaSpace {

    public BuyHouseSpace(String type) {

        super(type);
    }

    public HouseCard takeHouseCard(Deck houseDeck){
        return (HouseCard) houseDeck.drawCard();
    }
}
