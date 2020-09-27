package model;

public class GraduationSpace extends MagentaSpace {

    public GraduationSpace(String type)
    {
        super(type);
    }

    public GraduationSpace(String type, Path connector)
    {
        super(type, connector);
    }

    public void graduatePlayer(Player player){
        player.setCollegeDegree(true);
    }
}