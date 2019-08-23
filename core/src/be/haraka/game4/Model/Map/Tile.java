package be.haraka.game4.Model.Map;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Mob.SolidObject;

/**
 * Tile class. The tile position are an integer value but the
 * tile still extends the GameObject for rendering purposes.
 *
 * @author GriffinBabe
 */
public class Tile extends SolidObject {

    private static String TILE_NAME = "tile";

    private static float TILE_DIMENSIONS = 1.0f;


    // Ranges from 0 to 1.0 modifies the movement speed on it
    private float speedModifier = 1.0f;

    // TileID, used mainly for rendering
    private int id;

    private boolean walkable = true;

    // Tile is a GameObject but position is an integer
    public Tile(int x, int y, int id, boolean walkable, float speedModifier) {
        super(x,y,TILE_DIMENSIONS,TILE_DIMENSIONS,TILE_NAME+"-"+id);
        this.id = id;
        this.speedModifier = speedModifier;
        this.walkable = walkable;
    }

    /**
     * Called when a GameObject walks on the tile, most
     * of the time does nothing.
     * @param o
     */
    public void walkOn(GameObject o) {

    }

    /**
     * Tells if the tile si isWalkable or not.
     *
     * @return boolean value.
     */
    public boolean isWalkable() {
        return walkable;
    }

    /**
     * Get's the speed modifier.
     * Used for the {@link be.haraka.game4.Model.Mob.Mob} walking on the tile.
     *
     * @return float value ranging from 0.0 to 1.0
     */
    public float getSpeedModifier() {return speedModifier;}

    /**
     * Update method, does nothing as a regular tile.
     * @param delta, elapsed time since last loop
     */
    @Override
    public void update(World world, float delta) {

    }

    @Override
    public GameObject clone() {
        Tile nTile = new Tile((int)x, (int)y, this.id, this.walkable, this.speedModifier);
        return nTile;
    }


    /**
     * Get's the tile ID, mainly used by the Graphics.
     * @return the tile ID.
     */
    public int getId() {
        return id;
    }
}