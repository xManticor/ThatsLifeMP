package model;

public class HaveTwinSpace extends MagentaSpace {

    public HaveTwinSpace(String type) {
        super(type);
    }

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
