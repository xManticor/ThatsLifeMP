package model;

public class GraduateSpace extends MagentaSpace {

    public GraduateSpace(String type)
    {
        super(type);
    }

    public GraduateSpace(String type, Path connector)
    {
        super(type, connector);
    }

    public void graduatePlayer(Player player){
        player.setCollegeDegree(true);
    }
}