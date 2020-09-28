package model;

import javafx.scene.paint.Color;

/**
 * This magenta space class, a class under space class.
 */
abstract public class MagentaSpace extends Space {
    /**
     * MagentaSpace constructor. This defines the type and color of MagentaSpace
     * @param type
     */
    public MagentaSpace(String type) {
        super(type, Color.MAGENTA);
    }
    /**
     * MagentaSpace constructor. This defines the type, color of MagentaSpace and connector
     * @param type space type
     * @param connector Path connector
     */
    public MagentaSpace(String type, Path connector) {
        super(type, Color.MAGENTA, connector);
    }
}
