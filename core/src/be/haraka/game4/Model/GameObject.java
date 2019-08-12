package be.haraka.game4.Model;

import be.haraka.game4.Model.Map.World;

import java.util.Observable;

public abstract class GameObject extends Observable {

    public float x, y;

    // Helpful to find which render do we need
    public String objectName;

    public GameObject(float x, float y, String objectName) {
        this.x = x;
        this.y = y;
        this.objectName = objectName;
    }

    public abstract void update(World world, float delta);


}
