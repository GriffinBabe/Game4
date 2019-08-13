package be.haraka.game4.Model;

import be.haraka.game4.Model.Map.World;

import java.util.Observable;

public abstract class GameObject extends Observable {

    protected float x, y;
    protected Direction direction = Direction.VOID;

    // Helpful to find which render do we need
    protected String objectName;

    public GameObject(float x, float y, String objectName) {
        this.x = x;
        this.y = y;
        this.objectName = objectName;
    }

    /**
     * Changes the
     * @param angle
     */
    public void changeDirection(float angle) {

    }

    /**
     * Updates the position with the given dx and dy
     * parameters.
     *
     * @param dx x axis increase/decrease
     * @param dy y axis increase/decrease
     */
    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    /**
     * X position setter.
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Y Position setter.
     * @param y
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Update called on the Game's main loop.
     * This one is empty as a GameObject is an abstract class.
     * @param world
     * @param delta
     */
    public abstract void update(World world, float delta);


    /**
     * Returns the direction that the GameObject is facing.
     * @return
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Returns the X position of the GameObject.
     * This value is kept private, as some object just
     * 'follows' others. When the graphics ask for the position,
     * the getter function will return the x value of the
     * followed GameObject.
     *
     * Nevertheless, most of the GameObject have their own X,Y value.
     *
     * @return the X value of the GameObject.
     */
    public float x() {
        return x;
    }

    /**
     * Returns the X position of the GameObject.
     * This value is kept private, as some object just
     * 'follows' others. When the graphics ask for the position,
     * the getter function will return the x value of the
     * followed GameObject.
     *
     * Nevertheless, most of the GameObject have their own X,Y value.
     *
     * @return the Y value of the GameObject.
     */
    public float y() {
        return y;
    }

    /**
     * GameObject orientation, {@link GameObject} default's direction
     * is VOID, just like {@link be.haraka.game4.Model.Map.Tile}.
     * While {@link be.haraka.game4.Model.Mob.Mob} default's
     * direction is SOUTH.
     */
    public enum Direction {

        VOID(0,'V'),
        N(1,'N'),
        NE(2,'A'),
        E(3,'E'),
        SE(4,'B'),
        S(5,'S'),
        SW(6,'C'),
        W(7,'W'),
        NW(8,'D');

        public int dirID;
        public char dirC;

        Direction(int dirID, char dirC) {
            this.dirID = dirID;
            this.dirC = dirC;
        }

    }
}
