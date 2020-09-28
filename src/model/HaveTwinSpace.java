package model;
/**
 * HaveTwinSpace class, a class under MagentaSpace, this class indicates all the state and behaviour of the HaveTwinSpace Space.
 */
public class HaveTwinSpace extends MagentaSpace {
    /**
     * This is an HaveTwinSpace standard constructor that accepts a String as a name that is to be assigned to the HaveTwinSpace.
     *
     * @param type the name of the HaveTwinSpace to be assigned, also the name is inherited from MagentaSpace class.
     */
    public HaveTwinSpace(String type) {
        super(type);
    }
    /**
     * This method adds a child to the player and the other players pays the player that had a child recently.
     * @param player player to be added a child
     * @param otherPlayers the otherPlayers to be paying to the current player
     */
    public void addPlayerChild(Player player, Player[] otherPlayers) {
        if(player.isMarried()){
            player.addChild(2);
            for(int i = 0; i < otherPlayers.length; i++){
                if(player.getName() != otherPlayers[i].getName())
                    player.addCash(10000);
                otherPlayers[i].removeCash(10000);
            }
        }
    }
}
