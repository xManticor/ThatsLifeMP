package model;

/**
 * WhichPathSpace class that inherits MagentaSpace
 */
public class WhichPathSpace extends MagentaSpace
{
    private Path path1, path2;

    /**
     * WhichPathSpace constructor that takes in a String to be passed into super class, and 2 paths.
     * @param name name of the space
     * @param path1 first path
     * @param path2 second path
     */
    public WhichPathSpace(String name, Path path1, Path path2)
    {
        super(name);
        this.path1 = path1;
        this.path2 = path2;
    }

    /**
     * Gets first path
     * @return path1
     */
    public Path getPath1() {
        return path1;
    }

    /**
     * Gets second path
     * @return path2
     */
    public Path getPath2() {
        return path2;
    }

}