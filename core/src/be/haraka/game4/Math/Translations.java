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
    private static int TILE_HEIGHT = 128;

    /**
     * Set map informations to get the
     */
    public static void setValues(int width, int height) {
        TILE_WIDTH = width;
        TILE_HEIGHT = height;
    }

    /**
     * Converts isometric position to screen (batch) position.
     * (model to graphics)
     *
     * @param x, model x value
     * @param y, model y value
     * @return a vector containing both batch coordinates
     */
    public static Vec2i isoToScreen(float x, float y) {
        Vec2i position = new Vec2i();
        float posX = ( x - y ) * (float)TILE_WIDTH;
        float posY = ( x + y ) * (float)TILE_HEIGHT/2.0f;

        position.x = (int) (posX + 0.5f); // Round to the closest integer
        position.y = (int) (posY + 0.5f);
        return position;
    }

    /**
     * Converts screen position to isometric position.
     * (graphics and input to model)
     *
     * @param screenX, screen X value
     * @param screenY, screen Y value
     * @return a vector containing both model coordinates
     */
    public static Vec2f screenToIso(int screenX, int screenY) {
        Vec2f position = new Vec2f();
        float isoX = (float)screenY / (float)TILE_HEIGHT
                + (float) screenX / ((float)TILE_WIDTH*2);
        float isoY = (float) screenY / (float)TILE_HEIGHT
                - (float) screenX / ((float)TILE_WIDTH*2);

        position.x = isoX;
        position.y = isoY;
        return position;
    }
}
