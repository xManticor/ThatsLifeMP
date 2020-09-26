package model;

import java.util.*;

public class Path {
    private String name;
    private ArrayList<Space> spaces;

    public Path(String name) {
        this.name = name;
        spaces = new ArrayList<Space>();
    }

    public Space[] getSpaces() {
        return spaces.toArray(new Space[0]);
    }

    public Space getLastSpace() {
        return spaces.get(getNSpaces() - 1);
    }

    public int getNSpaces() {
        return spaces.size();
    }

    public String getName() {
        return name;
    }

    public void addSpace(Space space){
        spaces.add(space);
    }
}