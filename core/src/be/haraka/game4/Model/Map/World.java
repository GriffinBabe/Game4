package be.haraka.game4.Model.Map;

import be.haraka.game4.Game;
import be.haraka.game4.Model.GameObject;

import java.util.*;

/**
 * One of the Model's main classes. Will contain
 * all the map informations such as mobs, the items
 * laying around, characters (players) and tiles.
 *
 * The world listen to each mob trough the observer
 * pattern.
 *
 * @author GriffinBabe
 */

public class World implements Observer {

    // World size in tiles
    private int width;
    private int height;

    private Game game;

    /**
     * Map tiles of width, height dimensions. Loaded from
     * JSON file in the {@link MapLoader} static methods.
     */
    private Tile map[][];

    /**
     * Contains all the GameObjects of the map except the tiles.
     */
    private List<GameObject> objectList = new ArrayList<>();

    public World(Game game, String mapFile) {
        this.game = game;
        MapLoader.LoadMap(mapFile, this);
    }

    /**
     * Called from the game main loop before
     * the graphics update.
     *
     * This will update the state of each GameObject
     * in the game.
     *
     * Uses an iterator as some objects can be deleted
     * from the list while iterating over it.
     *
     * @param delta, the elapsed time since last loop.
     */
    public void updateLogic(float delta) {
        ListIterator<GameObject> iter = objectList.listIterator();
        while (iter.hasNext()) {
            GameObject object = iter.next();
            object.update(this, delta);
        }
    }

    /**
     * Java implementation of the observer pattern.
     * Do not mix it with updateLogic which is called
     * from the main game loop.
     *
     * @param o, the observable with a new event
     * @param arg, an event.
     */
    @Override
    public void update(Observable o, Object arg) {

    }

    /**
     * Called from the {@link MapLoader} to set the map
     * dimensions and to initialises the tile array with
     * those new informations.
     *
     * @param width
     * @param height
     */
    void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
        map = new Tile[width][height];
    }

    /**
     * Sets the tile on the given position.
     * VOID Tiles will not overwrite non-VOID tiles.
     *
     * @param x
     * @param y
     * @param tile, new Tile Object.
     */
    void setTile(int x, int y, Tile tile) {
        // Prevent that upper layers override downer layers with void tiles.
        if (tile.getType()== TileType.VOID && map[x][y]!=null) {
            return;
        }
        map[x][y] = tile;
    }

    /**
     * Gathers all the tiles into a list from an outside class.
     * Used mainly for the Graphics to instantiate each tile.
     * @return
     */
    public List<Tile> gatherTiles() {
        List<Tile> tiles = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles.add(map[x][y]);
            }
        }
        return tiles;
    }

    /**
     * Called during game logic, will add the GameObject in
     * the objectList and tell the {@link Game} calling
     * {@link Game#newObject(GameObject)}
     *
     * @param object, the new created object.
     */
    public void newObject(GameObject object) {
        this.objectList.add(object);
        game.newObject(object);
    }


    /**
     * Called during game logic, will delete the GameObject from
     * the objectList and tell the {@link Game} calling
     * {@link Game#deleteObject(GameObject)}}
     *
     * @param object, the deleted object.
     */
    public void deleteObject(GameObject object) {
        this.objectList.remove(object);
        game.deleteObject(object);
    }

}
