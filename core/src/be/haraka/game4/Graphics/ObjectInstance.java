package be.haraka.game4.Graphics;

import be.haraka.game4.Math.Translations;
import be.haraka.game4.Math.Vec2i;
import be.haraka.game4.Model.GameObject;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
    public void render(SpriteBatch batch) {
        Texture texture = model.getTexture();
        Vec2i batchPos = Translations.isoToScreen(object.x, object.y);
        batch.draw(texture, batchPos.x, batchPos.y);
    }

}
