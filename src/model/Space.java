package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Abstract space class which gives methods to its children spaces
 */
abstract public class Space {

    private String type;
    private ArrayList<Player> players;
    private Path connector;
    private Color color;

    /**
     * Space constructor that takes in Space type and color from its children classes
     * @param type space type
     * @param color space color
     */
    public Space(String type, Color color) {
        this.type = type;
        this.color = color;
        this.players = new ArrayList<>();
    }

    /**
     * Space constructor that takes in Space type, color from its children classes, and a connector path
     * @param type space type
     * @param color space color
     * @param connector connector path
     */
    public Space(String type, Color color, Path connector) {
        this.type = type;
        this.color = color;
        this.connector = connector;
        this.players = new ArrayList<>();
    }

    /**
     * Gets the type of space
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the connector path
     * @return connector
     */
    public Path getConnector() {
        return connector;
    }

    /**
     * Gets the ArrayList of players
     * @return players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     *  Gets the color of the space
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Adds a player into ArrayList of players
     * @param player player to be added
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Remove a player into ArrayList of players
     * @param player player to be removed
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }

}
