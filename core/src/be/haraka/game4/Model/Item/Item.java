package be.haraka.game4.Model.Item;

import be.haraka.game4.Model.GameObject;

public abstract class Item extends GameObject {

    public Item() {
        super(0.0f, 0.0f);
    }

    public abstract void act();
}
