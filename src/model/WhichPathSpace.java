package model;

public class WhichPathSpace extends MagentaSpace
{
    private Path path1, path2;
    public WhichPathSpace(String name, Path path1, Path path2)
    {
        super(name);
        this.path1 = path1;
        this.path2 = path2;
    }

    public Path getPath1() {
        return path1;
    }

    public Path getPath2() {
        return path2;
    }


    /*public Path choosePath(){
        .
        .

        .

    }*/
}