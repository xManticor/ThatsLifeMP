package model;

import javafx.scene.paint.Color;
/**
 *  BlueSpace class, a class under Space class, this class indicates all the state and behaviour of the Blue Space.
 *
 */
public class BlueSpace extends Space {

    /**
     * This is an BlueSpace standard constructor that accepts a String as a name that is to be assigned to the BlueSpace.
     * This also sets the BlueSpace color to blue.
     * @param type the name of the Blue Space to be assigned, also the name inherited from Card class.
     */
    public BlueSpace(String type) {
        super(type, Color.BLUE);
    }

    /**
     * This simply method simply takes a blue card deck, then returns a blue card.
     * @param blueDeck the blue card deck to be drawn from.
     * @return the blue card drawn.
     */
    public BlueCard takeBlueCard(Deck blueDeck) {
        return (BlueCard) blueDeck.drawCard();
    }
}
