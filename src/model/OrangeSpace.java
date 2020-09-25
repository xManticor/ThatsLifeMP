package model;

import java.awt.event.ActionEvent;

public class OrangeSpace extends Space {

    public OrangeSpace(String type) {

        super(type);
    }

    public ActionCard takeActionCard(Deck actionDeck) {
        return (ActionCard) actionDeck.drawCard();
    }

    @Override
    public String toString() {
        return "";
    }

}
