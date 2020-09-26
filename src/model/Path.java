package model;

import java.util.*;

public class Path {
    private String name;
    private ArrayList<Space> spaces;
    private int endpath;

    public Path(String name) {
        this.name = name;
        spaces = new ArrayList<Space>();
    }

    public ArrayList<Space> getSpaces() {
        return spaces;
    }

    public String getSpaceType() {
        return name;
    }

    public void addSpace(Space space){
        spaces.add(space);
    }
}