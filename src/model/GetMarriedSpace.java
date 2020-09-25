package model;

public class GetMarriedSpace extends MagentaSpace {

    public GetMarriedSpace(String type) {

        super(type);
    }

    public void playerMarry(Player player, Player[] otherPlayers) {

        if(player.isMarried() == false){
            player.setMarried(true);


            for (int i = 0; i < otherPlayers.length; i++) {
                if (player.getName() != otherPlayers[i].getName()){
                    if(generateRandom(1, 10) % 2 == 0)
                        otherPlayers[i].removeCash(10000);

                    else
                        otherPlayers[i].removeCash(5000);
                }
            }

        }

    }

    public int generateRandom(int lb, int ub) {
        return (int) Math.random() * (ub - lb + 1) + lb;
    }
}
