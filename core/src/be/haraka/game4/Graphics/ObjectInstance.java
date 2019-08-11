package be.haraka.game4.Graphics;

import be.haraka.game4.Model.GameObject;

/**
 * ObjectInstance links a GameObject with a Model to render.
 * This is an implementation of the Flyweight pattern.
 *
 * @author GriffinBabe
 */
public class ObjectInstance {

    // Reference to the GameObject
    private GameObject object;

    // Reference to the right Model.
    private Model model;

    public ObjectInstance(GameObject object, Model model) {
        this.object = object;
        this.model = model;
    }

    /**
     * Render class, will be overriden in some Child classes.
     * The basic method from the MotherClass is to simply render
     * the Model's {@link Model#texture} file at the {@link GameObject}
     * position.
     */
    public void render() {

    }

}
