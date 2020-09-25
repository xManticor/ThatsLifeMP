package model;

public class Card {
    String type;
    String description;
    String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // add toString method
}
