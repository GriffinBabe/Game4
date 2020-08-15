package be.haraka.game4.Graphics.Instances;

import be.haraka.game4.Graphics.Models.Model;
import be.haraka.game4.Math.Translations;
import be.haraka.game4.Math.Vec2i;
import be.haraka.game4.Model.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Observable;
import java.util.Observer;

/**
 * ObjectInstance links a GameObject with a Model to render.
 * This is an implementation of the Flyweight pattern.
 *
 * ObjectInstance is an observer that gets notified by the linked {@link GameObject}
 *
 * @author GriffinBabe
 */
public class ObjectInstance implements Observer {

    // Reference to the GameObject
    protected GameObject object;

    // Reference to the right Model.
    protected Model model;


    public ObjectInstance(GameObject object, Model model) {
        this.object = object;
        this.model = model;
        // We now observe our model
        object.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    /**
     * Render class, will be overriden in some Child classes.
     * The basic method from the MotherClass is to simply render
     * the Model's {@link Model#texture} file at the {@link GameObject}
     * position.
     */
    public void render(float delta, SpriteBatch batch) {
        Texture texture = model.getTexture();
        Vec2i batchPos = Translations.orthoToScreen(object.x(), object.y());
        batch.draw(texture, batchPos.x, batchPos.y);
    }

    /**
     * Compares the given object with the instance current {@link GameObject}.
     * @param obj the {@link GameObject} to compare with.
     * @return true if the objects are the same, false otherwise.
     */
    public boolean reflectsObject(GameObject obj) {
        return obj == object;
    }

    public float getX() {return object.x();}

    public float getY() {return object.y();}

    public int getRenderPriority() {return model.getRenderPriority();}

}
