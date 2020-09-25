package model;

public class HouseCard extends Card {
    String type = "House";
    String name;
    int value;

    public HouseCard(String name, int value) {
        super(name);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "";
    }
}