package be.haraka.game4.Model.Mob;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.States.State;

/**
 * Base class for Mobs, Characters. Extends {@link GameObject}.
 *
 * @author GriffinBabe
 */
public class Mob extends GameObject {

    private State state;

    public Mob(float x, float y, String objectName) {
        super(x,y, objectName);
        direction = Direction.S;
    }

    @Override
    public void update(World world, float delta) {
        // Mob behaviour, depends on the state
    }

    public String getStateName() {
        return state.getName();
    }


}
