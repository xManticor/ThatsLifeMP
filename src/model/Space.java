package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

abstract public class Space {

    private String type;
    private ArrayList<Player> players;
    private Path connector;
    private Color color;

    public Space(String type, Color color) {
        this.type = type;
        this.color = color;
        this.players = new ArrayList<>();
    }

    public Space(String type, Color color, Path connector) {
        this.type = type;
        this.color = color;
        this.connector = connector;
        this.players = new ArrayList<>();
    }

    public Path getConnector() {
        return connector;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public String getType() {
        return type;
    }

    public Player[] getPlayers() {
        return players.toArray(new Player[0]);
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "";
    }

}
