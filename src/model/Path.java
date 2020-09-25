package model;

public class Path {
    private String name;
    private Space[] spaces;
    private int endpath;

    public Path(String name, int numspaces) {
        this.name = name;
        spaces = new Space[numspaces];
    }

    public Space[] getSpaces() {
        return spaces;
    }

    public String getSpaceType() {
        return name;
    }

    public int getEndPath() {
        endpath = spaces.length;
        return endpath;
    }
}