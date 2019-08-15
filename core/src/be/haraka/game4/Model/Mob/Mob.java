package be.haraka.game4.Model.Mob;

import be.haraka.game4.Controls.Command;
import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.States.MobIdleState;
import be.haraka.game4.Model.States.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for Mobs, Characters. Extends {@link GameObject}.
 *
 * @author GriffinBabe
 */
public class Mob extends GameObject {

    private static Direction DEFAULT_DIRECTION = Direction.S;
    private static State DEFAULT_ACTION_STATE = new MobIdleState();

    private State actionState;

    // Equipped weapon
    private State weaponState;

    // Not sure if this a good approach
    private List<State> equipmentState;

    // List of commands that will be executed upon update
    private List<Command> commandQueue = new ArrayList<>();

    // Mob statistics
    private float movementSpeed;

    private int maxHealth;
    private int maxMana;
    private int armor;

    // TODO: Add more stats.

    private int health;
    private int mana;

    public Mob(float x, float y, String objectName) {
        super(x,y, objectName);
        direction = DEFAULT_DIRECTION;
        actionState = DEFAULT_ACTION_STATE;
    }

    @Override
    public void update(World world, float delta) {

        // Executes all the commands and empties the list.
        for (Command command : commandQueue) {
            executeCommand(command, world);
        }
        commandQueue.clear();

        // Mob behaviour, depends on the actionState
        State newState = actionState.updateState(delta, this, world);

        // If the updateState from action state returns a state instead
        // of null, this means the state changed.
        if (newState != null) {
            actionState.exit(this, world);
            actionState = newState;
            actionState.enter(this,world);
            notifyObservers(Event.CHANGED_STATE);
        }
    }

    /**
     * Sets the statistics of the Mob, like max-health.
     */
    public void setStats(int maxHealth, int maxMana, int armor, float speed) {
        this.maxHealth = maxHealth;
        this.maxMana = maxMana;
        this.armor = armor;
        this.movementSpeed = speed;
    }

    private void executeCommand(Command command, World world) {
        State newState = command.applyTo(actionState);

        if (newState != null) {
            actionState.exit(this, world);
            actionState = newState;
            actionState.enter(this, world);
            notifyObservers(Event.CHANGED_STATE);
        }
    }

    public void addCommand(Command command) {
        this.commandQueue.add(command);
    }

    @Override
    public GameObject clone() {
        Mob nMob = new Mob(x,y,objectName);
        nMob.setStats(maxHealth, maxMana, armor, movementSpeed);
        return nMob;
    }

    public float getMovementSpeed() {return movementSpeed;}

    public State.StateType getStateType() {
        return actionState.getStateType();
    }

    public String getStateName() { return actionState.getStateType().stateName; }

    public int getHealth() {return health;}

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getArmor() {
        return armor;
    }

    public int getMana() {
        return mana;
    }
}
