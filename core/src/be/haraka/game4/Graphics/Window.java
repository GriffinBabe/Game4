package be.haraka.game4.Graphics;

import be.haraka.game4.Game;
import be.haraka.game4.Model.GameObject;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
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
    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    public static String modelsPath = "assets/models.json";

    // List containing all the objects instances to render
    public List<ObjectInstance> renderInstances = new ArrayList<>();

    // Check ModelList doc.
    public ModelList modelList = null;

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

        modelList = new ModelList(modelsPath);
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
        for (ObjectInstance instance : renderInstances) {
            instance.render();
        }
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
}
