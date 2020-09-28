package model;
/**
 * GraduateSpace class, a class under MagentaSpace, this class indicates all the state and behaviour of the GraduateSpace Space.
 */
public class GraduateSpace extends MagentaSpace {
    /**
     * This is an GraduateSpace standard constructor that accepts a String as a name that is to be assigned to the GraduateSpace.
     *
     * @param type the name of the GraduateSpace to be assigned, also the name is inherited from MagentaSpace class.
     * @param connector the connector that leads to the other path
     */
    public GraduateSpace(String type, Path connector)
    {
        super(type, connector);
    }

    /**
     * This method simply changes the player's degree value to true.
     * @param player player to be graduating
     */
    public void graduatePlayer(Player player){
        player.setCollegeDegree(true);
    }
}