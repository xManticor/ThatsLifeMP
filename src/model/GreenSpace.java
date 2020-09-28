package model;

import javafx.scene.paint.Color;
/**
 * GreenSpace class, a class under Space, this class indicates all the state and behaviour of the GreenSpace.
 */
abstract public class GreenSpace extends Space {
    /**
     * The greenspace constructor, this sets the type and the color of the GreenSpace to green
     * @param type space type
     */
    public GreenSpace(String type) {
        super(type, Color.GREEN);
    }
}
