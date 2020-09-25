package model;

public class HaveBabySpace extends MagentaSpace {

    public HaveBabySpace(String type) {

        super(type);
    }

    public void addPlayerChild(Player player){
        player.addChild(1);
    }


}
