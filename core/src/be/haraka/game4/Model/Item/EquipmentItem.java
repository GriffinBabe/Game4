package be.haraka.game4.Model.Item;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.Mob.Mob;
import be.haraka.game4.Model.Mob.StatModifier;

import java.util.HashMap;

/**
 * Equipment Item, holds a stat list.
 * @see #stats
 */
public class EquipmentItem extends Item {

    /**
     * Dictionnary containing all the additional statistics and multipliers
     * this item brings upon equipment.
     *
     * The naming conventions of the stats are stored staticly int the
     * {@link Mob} class.
     */
    private HashMap<String, StatModifier> stats;

    /** Where the equipment is attached on the body */
    private Slot slot;

    public EquipmentItem(String objectName, Rarity rarity, Slot slot) {
        super(objectName, rarity);
        this.slot = slot;
    }

    public EquipmentItem(float x, float y, Rarity rarity, String objectName, Slot slot) {
        super(x,y,objectName, rarity);
        this.slot = slot;
    }

    /** Sets a stat corresponding to a name. */
    public void setStat(String name, float valueMod, float valueMult) {
        stats.put(name, new StatModifier(valueMod, valueMult));
    }

    /** Gets and returns a stat corresponding to a name*/
    public StatModifier getStat(String name) {
        return stats.get(name);
    }

    /**
     * Does nothing upon update.
     * @see GameObject#update(World, float) ;
     */
    @Override
    public void update(World world, float delta) {

    }

    /**
     * Does nothing as it is an equipment item,
     * not a consumable.
     * @param object, the object we will act on.
     */
    @Override
    public void act(GameObject object) {

    }

    @Override
    public GameObject clone() {
        EquipmentItem item = new EquipmentItem(this.objectName, this.rarity, this.slot);
        item.stats = this.stats;
        return item;
    }

    public Slot getSlot() {return slot;}

    public enum Slot {
        FEET(0),
        LEGS(1),
        BODY(2),
        HEAD(3),
        WEAPON(4);

        public int id;

        Slot(int id) {
            this.id = id;
        }
    }
}
