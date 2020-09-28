package model;

public class Card {
    protected String type;
    protected String description;
    protected String name;

    public Card(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
