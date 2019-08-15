package be.haraka.game4.Graphics.Instances;

import be.haraka.game4.Graphics.Models.AnimatedModel;
import be.haraka.game4.Graphics.Models.ModelList;
import be.haraka.game4.Model.Mob.Event;
import be.haraka.game4.Model.Mob.Mob;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Observable;

/**
 * Mob instance class, extends AnimationInstance.
 *
 * Render function is not overwritten as it
 * only consists of playing the animation, but
 * the update method is changed.
 *
 * This class contains a reference to the modelList,
 * as it needs it to gather new animations when the linked
 * mob's state is changing.
 */
public class MobInstance extends AnimatedInstance {

    // HP/mana bar width, height
    private static int BAR_WIDTH;
    private static int BAR_HEIGHT;

    // height between mana and health bar
    private static int BAR_GAP;

    // flashy green
    private static Color HP_COlOR = new Color(0.505f, 0.960f, 0.258f, 1.0f);
    // dark green
    private static Color NO_HP_COLOR = new Color(0.172f,0.329f,0.086f, 1.0f);

    // flashy blue
    private static Color MANA_COLOR = new Color(0.368f, 0.925f, 1.0f, 1.0f);
    // dark blue
    private static Color NO_MANA_COLOR = new Color(0.14f, 0.27f, 0.36f, 1.0f);


    public MobInstance(Mob mob) {
        super(mob, null);
        updateModel();
    }

    @Override
    public void update(Observable o, Object arg) {
        switch((Event) arg) {
            case CHANGED_STATE:
                updateModel();
                break;
            case CHANGED_DIRECTION:
                updateModel();
                break;
        }
    }

    /**
     * Updates the AnimatedModel from Gathering the
     * {@link be.haraka.game4.Model.GameObject} name,
     * state's name, and direction.
     */
    private void updateModel() {
        String animationName = ((Mob)object).getName()+"-"+((Mob)object).getStateName()
                + object.getDirection().dirC;
        AnimatedModel model = (AnimatedModel) ModelList.getInstance().getModel(animationName);
        changeAnimation(model);
    }
}
