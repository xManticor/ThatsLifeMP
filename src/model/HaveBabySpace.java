package model;

public class HaveBabySpace extends MagentaSpace {

    public HaveBabySpace(String type) {
        super(type);
    }

    public void addPlayerChild(Player player, Player[] otherplayers) {
        if(player.isMarried()){
            player.addChild(1);
            for(int i = 0; i < otherplayers.length; i++){
                if(player.getName() != otherplayers[i].getName())
                    player.addCash(5000);
                    otherplayers[i].removeCash(5000);
            }
        }
    }
}
