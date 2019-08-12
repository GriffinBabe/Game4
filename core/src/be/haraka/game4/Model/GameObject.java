package be.haraka.game4.Model;

import be.haraka.game4.Model.Map.World;

import java.util.Observable;

public abstract class GameObject extends Observable {

    public float x, y;
    public Direction direction = Direction.VOID;

    // Helpful to find which render do we need
    public String objectName;

    public GameObject(float x, float y, String objectName) {
        this.x = x;
        this.y = y;
        this.objectName = objectName;
    }

    /**
     * Update called on the Game's main loop.
     * This one is empty as a GameObject is an abstract class.
     * @param world
     * @param delta
     */
    public abstract void update(World world, float delta);


    public Direction getDirection() {
        return direction;
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
