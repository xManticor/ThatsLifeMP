package model;

/**
 * PlayerToPlayer interface for choosing a player
 */
public interface PlayerToPlayer {

    public Player choosePlayer(Player player, Player[] otherplayers);
}