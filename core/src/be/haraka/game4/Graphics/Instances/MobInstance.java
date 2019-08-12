package be.haraka.game4.Graphics.Instances;

import be.haraka.game4.Graphics.Models.ModelList;
import be.haraka.game4.Graphics.Window;
import be.haraka.game4.Model.Mob.Mob;

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

    /**
     * Reference to the {@link Window#modelList}
     * as it is needed to gather new animations
     * when the MobInstance get's notified.
     *
     */
    public ModelList models;

    public MobInstance(Mob mob, ModelList models) {
        super(mob, null);
        this.models = models;
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO: Check if the state has changed and change animation.
    }

    /**
     * Updates the AnimatedModel from Gathering the
     * {@link be.haraka.game4.Model.GameObject} name,
     * state's name, and direction.
     */
    private void updateModel() {
        String animationName = ((Mob)object).objectName+"-"+((Mob)object).getStateName()+
                "-"+object.getDirection();
        changeAnimation(animationName);
    }
}
