package model;

public class GraduationSpace extends MagentaSpace
{
    public GraduationSpace(String type)
    {
        super(type);
    }

    public void graduatePlayer(Player player){
        player.setCollegeDegree(true);
    }
}