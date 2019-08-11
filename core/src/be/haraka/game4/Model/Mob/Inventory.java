package be.haraka.game4.Model.Mob;

import be.haraka.game4.Model.Item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Inventory class that every mob and character owns.
 *
 * @author GriffinBabe.
 */
public class Inventory {

    private int maxSize;

    public List<Item> items = new ArrayList<>();

    public Inventory(int size) {
        this.maxSize = size;
    }

    public Item itemAt(int index) {
        return items.get(index);
    }

    public boolean addItem(Item newItem) {
        if (items.size() < maxSize) {
            items.add(newItem);
            return true;
        }
        return false;
    }

    public Item deleteItem(int index) {
        if (items.size() >= index) {
            Item deletedItem = items.get(index);
            items.remove(index);
            return deletedItem;
        }
        return null;
    }


}
