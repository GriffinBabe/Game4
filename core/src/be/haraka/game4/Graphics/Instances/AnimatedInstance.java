package be.haraka.game4.Graphics.Instances;

import be.haraka.game4.Exceptions.WrongModelType;
import be.haraka.game4.Graphics.Models.AnimatedModel;
import be.haraka.game4.Math.Translations;
import be.haraka.game4.Math.Vec2i;
import be.haraka.game4.Model.GameObject;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.Observable;

/**
 * Animated ObjectInstance, extends {@link ObjectInstance}.
 * Will render and update behaviour are overwritten.
 * The animation can't change and will loop during all the
 * existance of the {@link GameObject}.
 *
 * @author GriffinBabe
 */
public class AnimatedInstance extends ObjectInstance {

    private float elapsedTime = 0.0f;

    public AnimatedInstance(GameObject object, AnimatedModel model) {
        super(object, model);
    }

    /**
     * Increases the elapsed time from the
     * @param delta
     * @param batch
     */
    @Override
    public void render(float delta, SpriteBatch batch) {
        elapsedTime += delta;
        // TODO: Add directions to animations
        TextureAtlas.AtlasRegion texture = ((AnimatedModel) model)
                .getFrame(elapsedTime, '0');
        Vec2i batchPos = Translations.isoToScreen(object.x(), object.y());
        // Adapt as the position is always on the bottom left corner of the texture
        batchPos.x -= texture.getRegionWidth()/2;
        batch.draw(texture, batchPos.x, batchPos.y);

    }

    /**
     * Overrides the base method from {@link ObjectInstance#update(Observable, Object)}.
     * There is no behaviour as the animated instance only has one animation.
     */
    @Override
    public void update(Observable o, Object arg) {
        // Does nothing as it holds only one animation that can't change.
    }

    /**
     * Changes the AnimatedModel linked to this instance. Usually
     * called when a observer mob changes state.
     * @param animation
     */
    protected void changeAnimation(AnimatedModel animation) {
        this.model = animation;
        if (!(this.model instanceof AnimatedModel)) {
            throw new WrongModelType("New animation for AnimatedInstance must be an AnimatedModel.");
        }
    }
}
