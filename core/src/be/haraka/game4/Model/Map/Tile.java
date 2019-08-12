package be.haraka.game4.Model.Map;

import be.haraka.game4.Model.GameObject;

/**
 * Tile class. The tile position are an integer value but the
 * tile still extends the GameObject for rendering purposes.
 *
 * The Tile properties directly come from the Enum attribute {@link #type}.
 * The properties will be hardcoded for the moment.
 *
 * @author GriffinBabe
 */
public class Tile extends GameObject {

    // Ranges from 0 to 1.0 modifies the movement speed on it
    private float speedModifier = 1.0f;

    // TileType, all the properties of the tile come from that.
    private TileType type;

    // Tile is a GameObject but position is an integer
    public Tile(int x, int y, TileType type) {
        super(x,y, type.objectName);
        this.type = type;
    }

    /**
     * Called when a GameObject walks on the tile, most
     * of the time does nothing.
     * @param o
     */
    public void walkOn(GameObject o) {

    }

    /**
     * Tells if the tile si walkable or not, looking directly
     * at the {@link #type}.
     *
     * @return boolean value.
     */
    public boolean walkable() {
        switch (type) {
            case GRASS:
                return true;
            case WALL:
                return false;
            case WATER:
                return false;
        }
        return false;
    }

    /**
     * Get's the speed modifier.
     * Used for the {@link be.haraka.game4.Model.Mob.Mob} walking on the tile.
     *
     * @return float value ranging from 0.0 to 1.0
     */
    public float getSpeedModifier() {return speedModifier;}

    /**
     * Returns the tile {@link TileType}.
     * @return
     */
    public TileType getType() {return type;}

    /**
     * Update method, does nothing as a regular tile.
     * @param delta, elapsed time since last loop
     */
    @Override
    public void update(World world, float delta) {

    }

}