package be.haraka.game4.Math;

/**
 * Coordinate systems convertion class.
 *
 * @author GriffinBabe
 */
public class Translations {


    // Map informations
    private static int MAP_WIDTH;
    private static int MAP_HEIGHT;

    // Hardcoded for the moment
    private static int TILE_WIDTH = 64;
    private static int TILE_HEIGHT = 64;

    /**
     * Set map informations to get the
     */
    public static void setValues(int width, int height) {
        TILE_WIDTH = width;
        TILE_HEIGHT = height;
    }

    /**
     * Converts orthographic position to screen (batch) position.
     * (model to graphics)
     *
     * @param x, model x value
     * @param y, model y value
     * @return a vector containing both batch coordinates
     */
    public static Vec2i orthoToScreen(float x, float y) {
        Vec2i position = new Vec2i();
        position.x = (int) (x*(float)TILE_WIDTH);
        position.y = (int) (y*(float)TILE_HEIGHT);
        return position;
    }

    /**
     * Converts screen position to orthographic position.
     * (graphics and input to model)
     *
     * @param screenX, screen X value
     * @param screenY, screen Y value
     * @return a vector containing both model coordinates
     */
    public static Vec2f screenToOrtho(int screenX, int screenY) {
        Vec2f position = new Vec2f();
        position.x = ((float)screenX/(float)TILE_WIDTH);
        position.y = ((float)screenY/(float)TILE_HEIGHT);
        return position;
    }
}
