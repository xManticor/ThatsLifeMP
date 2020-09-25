package model;

public class BlueSpace extends Space {

    public BlueSpace(String type) {

        super(type);
    }

    public Card takeBlueCard(Deck blueDeck) {
        return blueDeck.drawCard();
    }

    @Override
    public String toString() {
        return "";
    }

}
