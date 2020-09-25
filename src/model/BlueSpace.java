package model;

public class BlueSpace extends Space {

    public BlueSpace(String type) {

        super(type);
    }

    public BlueCard takeBlueCard(Deck blueDeck) {
        return (BlueCard) blueDeck.drawCard();
    }

    @Override
    public String toString() {
        return "";
    }

}
