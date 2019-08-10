package be.haraka.game4.Graphics;

import be.haraka.game4.Model.GameObject;

/**
 * ObjectInstance links a GameObject with a Model to render.
 * This is a Flyweight example.
 *
 */
public class ObjectInstance {

    private GameObject object;
    private Model model;

    public ObjectInstance(GameObject object, Model model) {
        this.object = object;
        this.model = model;
    }

    public void render() {

    }

}
