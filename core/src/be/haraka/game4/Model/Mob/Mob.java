package be.haraka.game4.Model.Mob;

import be.haraka.game4.Controls.Command;
import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Item.EquipmentItem;
import be.haraka.game4.Model.Item.WeaponItem;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.States.MobIdleState;
import be.haraka.game4.Model.States.State;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Base class for Mobs, Characters. Extends {@link GameObject}.
 *
 * @author GriffinBabe
 */
public class Mob extends SolidObject {

    public static String MAX_MANA = "max-mana";
    public static String MAX_HEALTH = "max-health";
    public static String ARMOR = "armor";
    public static String SPEED = "speed";
    public static String ACCELERATION = "acceleration";

    private static Direction DEFAULT_DIRECTION = Direction.S;
    private static State DEFAULT_ACTION_STATE = new MobIdleState();

    private State actionState;

    // Equipped weapon
    private WeaponItem weapon;

    // Not sure if this a good approach
    private List<EquipmentItem> equipments;

    // List of commands that will be executed upon update
    private List<Command> commandQueue = new ArrayList<>();

    // Mob statistics
    private HashMap<String, Stat> statList = new HashMap<>();

    // Inventory, holds all the items.
    private Inventory inventory;

    // Mob current statistics.
    private int health;
    private int mana;

    public Mob(float x, float y, float width, float height, String objectName) {
        super(x,y, width, height, objectName);
        direction = DEFAULT_DIRECTION;
        actionState = DEFAULT_ACTION_STATE;
    }

    /**
     * Updates the mob, processing all the commands,
     * and calling the state update method.
     *
     * A state update can return a new state that the
     * mob will switch on.
     *
     * @param world the world where our mob is.
     * @param delta time ellpased since last call.
     */
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
     * Executes a command, called during update function.
     * An executed command can return a new state, that will
     * directly be applied in ths function.
     * @param command, the processed command
     * @param world, the world where our mob is.
     */
    private void executeCommand(Command command, World world) {
        State newState = command.applyTo(actionState);

        if (newState != null) {
            actionState.exit(this, world);
            actionState = newState;
            actionState.enter(this, world);
            notifyObservers(Event.CHANGED_STATE);
        }
    }

    /**
     * Equips the given item, applying all of it's
     * {@link EquipmentItem#stats} to the mob stats,
     * and adding the item to the {@link #equipments} list.
     * @param item, the equipped item.
     */
    public void equip(EquipmentItem item) {
        // Cannot equip an item in a slot already equipped.
        for (EquipmentItem eItem : equipments) {
            if (eItem.getSlot()==item.getSlot()) {
                return;
            }
        }
        for (String key : statList.keySet()) {
            Stat stat = statList.get(key);
            StatModifier modifier = item.getStat(key);
            stat.addAdditional(modifier.getAdditional());
            stat.addMultiplier(modifier.getMutliplier());
        }
        equipments.add(item);
    }

    /**
     * Unequips the given item, removing all of it's
     * {@link EquipmentItem#stats} to the mob stats,
     * and removing the item from the {@link #equipments}
     * list.
     * @param item, the unequipped item.
     */
    public void unequip(EquipmentItem item) {
        for (String key : statList.keySet()) {
            Stat stat = statList.get(key);
            StatModifier modifier = item.getStat(key);
            stat.removeAdditional(modifier.getAdditional());
            stat.removeMultiplier(modifier.getMutliplier());
        }
        equipments.remove(item);
    }


    /**
     * Sets the statistics of the Mob, like max-health.
     */
    public void setStats(int maxHealth, int maxMana, int armor, float speed, float acceleration) {
        statList.put(MAX_HEALTH, new Stat(maxHealth, Stat.StatType.INTEGER_ROUND));
        statList.put(MAX_MANA, new Stat(maxMana, Stat.StatType.INTEGER_ROUND));
        statList.put(ARMOR, new Stat(armor, Stat.StatType.INTEGER_ROUND));
        statList.put(SPEED, new Stat(speed, Stat.StatType.FLOAT));
        statList.put(ACCELERATION, new Stat(acceleration, Stat.StatType.FLOAT));
    }

    /**
     * Adds a new command to be processed in our list.
     * @param command
     */
    public void addCommand(Command command) {
        this.commandQueue.add(command);
    }

    /**
     * Clones a new mob from this one. With the
     * same stats, position and equipments. The
     * state is set to IDLE tho.
     * @return the new mob.
     */
    @Override
    public GameObject clone() {
        Mob nMob = new Mob(x,y,width,height,objectName);
        nMob.statList = this.statList;
        nMob.equipments = this.equipments;
        return nMob;
    }

    public float getMaxMovementSpeed() {return statList.get(SPEED).value();}

    public String getStateName() { return actionState.getStateType().stateName; }

    public int getHealth() {return health;}

    public int getMana() {
        return mana;
    }

    public int getMaxHealth() {
        return (int)statList.get(MAX_HEALTH).value();
    }

    public int getMaxMana() {
        return (int)statList.get(MAX_MANA).value();
    }

    public int getArmor() {
        return (int)statList.get(ARMOR).value();
    }

    public float getAcceleration() {
        return (float) statList.get(ACCELERATION).value();
    }
}
