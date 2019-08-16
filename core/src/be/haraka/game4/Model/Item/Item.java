package be.haraka.game4.Model.Item;

import be.haraka.game4.Model.GameObject;

/**
 * Item abstract base class.
 * An Item can be an equipment or a consumable.
 * Act will called when a player uses the item.
 *
 * @author GriffinBabe
 */
public abstract class Item extends GameObject {

    public Rarity rarity;

    public Item(String objectName, Rarity rarity) {
        super(0.0f, 0.0f, objectName);
        this.rarity = rarity;
    }

    public Item(float x, float y, String objectName, Rarity rarity) {
        super(x,y, objectName);
        this.rarity = rarity;
    }

    public abstract void act(GameObject object);

    public enum Rarity {
        COMMON(0),
        UNCOMMON(1),
        RARE(2),
        EPIC(3),
        UNIQUE(4);

        public int id;

        Rarity(int id) {
            this.id = id;
        }
    }
}
