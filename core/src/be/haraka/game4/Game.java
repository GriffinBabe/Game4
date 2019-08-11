package be.haraka.game4;

import be.haraka.game4.Graphics.Window;
import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import com.badlogic.gdx.ApplicationAdapter;

/**
 * Main model class. Entry point from LIBGDX.
 *
 * @author GriffinBabe
 */

public class Game extends ApplicationAdapter {

    // Server mode disable all the graphics
    public boolean serverMode = false;

    private static String MAP_PATH = "assets/map/map1.json";

    private World world;

    private Window window = null;

    /**
     * Called when the game is started.
     */
	@Override
	public void create () {
		world = new World(this, MAP_PATH);

		if (!serverMode) {
            window = new Window();
        }
	}

    /**
     * Main Loop of the Game.
     * Game logic update and graphics render.
     */
	@Override
	public void render () {
		this.window.render(0.0f);
	}

    /**
     * Called when the game is closing.
     */
	@Override
	public void dispose () {

	}

    /**
     * Called when a new object is created on the game.
     * This will directly call a function on the window
     * to create a new instance.
     * @param o the created GameObject
     */
	public void newObject(GameObject o) {
	    window.newObject(o);
    }

    /**
     * Same as {@link #newObject}, but when a GameObject
     * gets deleted.
     * @param o
     */
    public void deleteObject(GameObject o) {window.deleteObject(o);}
}
