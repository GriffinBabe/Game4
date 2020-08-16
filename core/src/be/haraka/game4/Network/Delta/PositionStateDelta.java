package be.haraka.game4.Network.Delta;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;

/**
 * Represents a {@link be.haraka.game4.Model.GameObject} movement.
 */
public class PositionStateDelta extends StateDelta {

    public float deltaX, deltaY;

    public PositionStateDelta(long id, float dx, float dy) {
        super(id);
        deltaX = dx;
        deltaY = dy;
    }

    /**
     * Applies the position changes to the networked {@link be.haraka.game4.Model.GameObject}.
     * @param world reference to world, to access {@link be.haraka.game4.Model.GameObject}.
     * @param deltatime time passed since last local network update.
     */
    public void apply(World world, float deltatime) {
        float dx = deltaX * deltatime;
        float dy = deltaY * deltatime;
        GameObject object = world.getNetworkObject(super.ID);
        object.move(dx, dy);
    }
}
