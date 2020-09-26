package model;

import javafx.scene.paint.Color;

abstract public class MagentaSpace extends Space {

    public MagentaSpace(String type) {
        super(type, Color.MAGENTA);
    }
    public MagentaSpace(String type, Path connector) {
        super(type, Color.MAGENTA, connector);
    }
}
