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
     * @param player
     * @param otherplayers
     */
    public void addPlayerChild(Player player, Player[] otherplayers) {
        if(player.isMarried()){
            player.addChild(2);
            for(int i = 0; i < otherplayers.length; i++){
                if(player.getName() != otherplayers[i].getName())
                    player.addCash(10000);
                otherplayers[i].removeCash(10000);
            }
        }
    }
}
