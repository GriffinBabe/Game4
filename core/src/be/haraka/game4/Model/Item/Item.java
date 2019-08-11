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

    public Item(String objectName) {
        super(0.0f, 0.0f, objectName);
    }

    public Item(float x, float y, String objectName) {
        super(x,y, objectName);
    }

    public abstract void act();
}
