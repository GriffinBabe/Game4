package be.haraka.game4.Model.Mob;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.States.State;

import java.util.List;

/**
 * Base class for Mobs, Characters. Extends {@link GameObject}.
 *
 * @author GriffinBabe
 */
public class Mob extends GameObject {

    private State actionState;

    // Equipped weapon
    private State weaponState;

    // Not sure if this a good approach
    private List<State> equipmentState;

    // Mob statistics
    private float movementSpeed;

    private float maxHealth;
    private float maxMana;
    private float armor;

    // TODO: Add more stats.

    private float health;
    private float mana;

    public Mob(float x, float y, String objectName) {
        super(x,y, objectName);
        direction = Direction.S;
    }

    @Override
    public void update(World world, float delta) {
        // Mob behaviour, depends on the actionState
        State newState = actionState.updateState(delta, this, world);

        // If the updateState from action state returns a state instead
        // of null, this means the state changed.
        if (newState != null) {
            actionState.exit(this, world);
            actionState = newState;
            actionState.enter(this,world);
        }
    }

    public float getMovementSpeed() {return movementSpeed;}

    public String getStateName() {
        return actionState.getStateName();
    }

}
