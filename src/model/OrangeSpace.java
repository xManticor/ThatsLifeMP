package model;

import javafx.scene.paint.Color;

import java.awt.event.ActionEvent;
/**
 * This orange space class, a class under space class.
 */
public class OrangeSpace extends Space {
    /**
     * OrangeSpace constructor. This defines the type and color of OrangeSpace
     * @param type
     */
    public OrangeSpace(String type) {
        super(type, Color.ORANGE);
    }
    /**
     * OrangeSpace constructor. This defines the type, color of OrangeSpace and connector
     * @param type space type
     * @param connector Path connector
     */
    public OrangeSpace(String type, Path connector) {
        super(type, Color.ORANGE, connector);
    }

    /**
     * This method takes an action card then returns it
     * @param actionDeck the deck tobe drawn from.
     * @return ActionCard
     */
    public ActionCard takeActionCard(Deck actionDeck) {
        return (ActionCard) actionDeck.drawCard();
    }


}
