package model;

import javafx.scene.paint.Color;

public class BlueSpace extends Space {

    public BlueSpace(String type) {
        super(type, Color.BLUE);
    }

    public BlueCard takeBlueCard(Deck blueDeck) {
        return (BlueCard) blueDeck.drawCard();
    }

    @Override
    public String toString() {
        return "";
    }

}
