package be.haraka.game4.Graphics;

import be.haraka.game4.Game;
import be.haraka.game4.Graphics.Instances.MobInstance;
import be.haraka.game4.Graphics.Instances.ObjectInstance;
import be.haraka.game4.Graphics.Models.Model;
import be.haraka.game4.Graphics.Models.ModelList;
import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.Tile;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.Mob.Mob;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Main graphics class. Contains a list of {@link ObjectInstance} to render.
 * It also contains a reference to the {@link be.haraka.game4.Model.Map.World}
 * object.
 *
 * The objective of this is to isolate as much as possible the Model from the Graphics
 * part, as we want to run the server from the same Model codebase.
 *
 * @author GriffinBabe
 */

public class Window {

    // Initial window size. Can be resized.
    private static int WIDTH = 1280;
    private static int HEIGHT = 720;


    // Our comparator for sorting the renderInstances
    private static RenderOrderComparator sorter = new RenderOrderComparator();

    // List containing all the objects instances to render
    private List<ObjectInstance> renderInstances = new ArrayList<>();


    // Main batch used to render the map and the players.
    private SpriteBatch batch;

    private Camera camera;

    public Window() {
        init();
    }

    /**
     * Initialize the window by resizing the gdx window and loading the
     * model list.
     */
    private void init() {
        Gdx.graphics.setWindowedMode(WIDTH, HEIGHT);
        Gdx.graphics.setResizable(true);

        batch = new SpriteBatch();
        camera = new Camera();

        // Initializes the modellist while loading the game, not during runtime.
        ModelList.getInstance();
    }

    /**
     * Part of the {@link Game#render()} game loop.
     * Renders all the object instances and the tiles.
     *
     * @param deltaTime the elapsed time since the last
     *                  render call. Used mainly for
     *                  animations.
     */
    public void render(float deltaTime) {
        // TODO: Give the right localplayer instance.
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update(deltaTime, batch);

        batch.begin();

        sortRenderInstances();

        for (ObjectInstance instance : renderInstances) {
            instance.render(deltaTime, batch);
        }

        batch.end();
    }

    /**
     * Called by {@link Game}, alerts the Graphic part that
     * a new {@link GameObject} has been created.
     *
     * Will create a new GameInstance.
     *
     * @param o, the new GameObject.
     */
    public void newObject(GameObject o) {
        // TODO: Create new object instance
        Model model = ModelList.getInstance().getModel(o.getName());
        ObjectInstance instace;
        if (o instanceof Mob) {
            instace = new MobInstance((Mob)o);
        } else {
            instace = new ObjectInstance(o, model);
        }
        this.renderInstances.add(instace);
    }

    /**
     * Same as {@link #newObject(GameObject)}, but when a
     * {@link GameObject} gets deleted.
     *
     * Will delete the corresponding GameInstance.
     *
     * @param o, the deleted GameObject.
     */
    public void deleteObject(GameObject o) {
        // TODO: Remove the respective object instance.
    }

    /**
     * Initializes the Gameobject instances from the world
     * tiles.
     *
     * @param world
     */
    public void setTilesInstances(World world) {
        List<Tile> tiles = world.gatherTiles();
        for (Tile tile : tiles) {
            Model model = ModelList.getInstance().getModel(tile.getName());
            renderInstances.add(new ObjectInstance(tile, model));
        }
    }

    /**
     * Sorts the render Instances by they're position.
     *
     */
    public void sortRenderInstances() {
        // TODO: Improve the algorithm
        // https://gamedev.stackexchange.com/questions/103442/
        // how-do-i-determine-the-draw-order-of-isometric-2d-objects-occupying-multiple-til
        Collections.sort(renderInstances, sorter);
    }

    /**
     * Libgdx feature to unproject the view from the camera.
     * Used to get where we clicked.
     *
     * @param screenPos, click position on the screen, will be modified.
     */
    public void unproject(Vector3 screenPos) {
        camera.unproject(screenPos);
    }

    /**
     * Calls {@link Camera#zoomIn()}.
     */
    public void zoomIn() {
        camera.zoomIn();
    }

    /**
     * Calls {@link Camera#zoomOut()}.
     */
    public void zoomOut() {
        camera.zoomOut();
    }

    /**
     * Calls {@link Camera#toggleLock()}.
     */
    public void toggleCameraLock() {
        camera.toggleLock();
    }
}
