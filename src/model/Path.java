package model;

import java.util.*;

/**
 * Path class, this is where all the conencted spaces are.
 */
public class Path {
    private String name;
    private ArrayList<Space> spaces;

    /**
     * Path constructor that defines the name and creates the array list of space
     * @param name
     */
    public Path(String name) {
        this.name = name;
        spaces = new ArrayList<Space>();
    }

    /**
     * This returns all the spaces
     * @return Space[]
     */
    public Space[] getSpaces() {
        return spaces.toArray(new Space[0]);
    }

    /**
     * This gets the space
     * @param index the index indicated to get a specific space
     * @return Space
     */
    public Space getSpace(int index) {
        return spaces.get(index);
    }

    /**
     * This gets the last space
     * @return Space
     */
    public Space getLastSpace() {
        return spaces.get(getNSpaces() - 1);
    }

    /**
     * This gets the number of spaces
     * @return number of spaces
     */
    public int getNSpaces() {
        return spaces.size();
    }

    /**
     * This gets the name of the path
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This add space to the array list
     */
    public void addSpace(Space space){
        spaces.add(space);
    }
}