package be.haraka.game4.Model.Mob;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.State;

/**
 * Base class for Mobs, Characters. Extends {@link GameObject}.
 *
 * @author GriffinBabe
 */
public class Mob extends GameObject {

    private State state = State.IDLE;

    public Mob(float x, float y, String objectName) {
        super(x,y, objectName);
    }

    @Override
    public void update(World world, float delta) {
        // Mob behaviour, depends on the state
    }

}
