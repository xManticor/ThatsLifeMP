package model;

import javafx.scene.paint.Color;

import java.awt.event.ActionEvent;

public class OrangeSpace extends Space {

    public OrangeSpace(String type) {
        super(type, Color.ORANGE);
    }

    public OrangeSpace(String type, Path connector) {
        super(type, Color.ORANGE, connector);
    }

    public ActionCard takeActionCard(Deck actionDeck) {
        return (ActionCard) actionDeck.drawCard();
    }

    @Override
    public String toString() {
        return "";
    }

}
