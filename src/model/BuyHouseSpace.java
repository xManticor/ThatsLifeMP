package model;

/**
 * BuyHouseSpace class, a class under MagentaSpace, this class indicates all the state and behaviour of the BuyHouseSpace Space.
 */
public class BuyHouseSpace extends MagentaSpace {
    /**
     * This is an BuyHouseSpace standard constructor that accepts a String as a name that is to be assigned to the BuyHouseSpace.
     *
     * @param type the name of the BuyHouseSpace to be assigned, also the name is inherited from MagentaSpace class.
     */
    public BuyHouseSpace(String type) {

        super(type);
    }

    /**
     * This simply method simply takes a house card deck, then returns a house card.
     * @param houseDeck the blue card deck to be drawn from.
     * @return the house card drawn.
     */
    public HouseCard takeHouseCard(Deck houseDeck){
        return (HouseCard) houseDeck.drawCard();
    }
}
