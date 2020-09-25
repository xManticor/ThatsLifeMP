package model;

public class OrangeSpace extends Space {

    public OrangeSpace(String type) {

        super(type);
    }

    public Card takeActionCard(Deck actionDeck) {
        return actionDeck.drawCard();
    }

    @Override
    public String toString() {
        return "";
    }

}
