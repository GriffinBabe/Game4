package be.haraka.game4.Model;

public abstract class GameObject {

    public float x, y;

    // Helpful to find which render do we need
    String objectName;

    public GameObject(float x, float y) {
        this.x = x;
        this.y = y;
    }

}
