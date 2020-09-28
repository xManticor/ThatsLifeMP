package model;
/**
 * GetMarriedSpace class, a class under MagentaSpace, this class indicates all the state and behaviour of the GetMarriedSpace Space.
 */
public class GetMarriedSpace extends MagentaSpace {
    /**
     * This is an GetMarriedSpace standard constructor that accepts a String as a name that is to be assigned to the GetMarriedSpace.
     *
     * @param type the name of the GetMarriedSpace to be assigned, also the name is inherited from MagentaSpace class.
     */
    public GetMarriedSpace(String type) {

        super(type);
    }

    /**
     * This method activates the marry condition
     * @param player the player married
     * @param otherPlayers the other players to pay the recent married player
     */
    public void playerMarry(Player player, Player[] otherPlayers) {

        if(player.isMarried() == false){
            player.setMarried(true);
            System.out.println(player.isMarried() + "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<, MARRIED");

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

    /**
     * This method generates random number
     * @param lb lower bound
     * @param ub upper bound
     * @return the generated number
     */
    public int generateRandom(int lb, int ub) {
        return (int) Math.random() * (ub - lb + 1) + lb;
    }
}
