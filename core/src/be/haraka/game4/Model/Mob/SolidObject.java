package be.haraka.game4.Model.Mob;

import be.haraka.game4.Game;
import be.haraka.game4.Model.GameObject;

public abstract class SolidObject extends GameObject {

    protected float width, height;

    public SolidObject(float x, float y, float width, float height, String objectName) {
        super(x, y, objectName);
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
