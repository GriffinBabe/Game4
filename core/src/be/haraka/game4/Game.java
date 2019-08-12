package be.haraka.game4;

import be.haraka.game4.Controls.Controller;
import be.haraka.game4.Graphics.Window;
import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

/**
 * Main model class. Entry point from LIBGDX.
 *
 * @author GriffinBabe
 */

public class Game extends ApplicationAdapter {

    // Server mode disable all the graphics
    public boolean serverMode = false;

    private static String MAP_PATH = "assets/map/map1.json";

    private static float FPS_CAP = 60.0f;
    private static float MS_PER_FRAME = 1.0f/FPS_CAP * 1000.0f;

    private World world;

    private Window window = null;

    /**
     * Called when the game is started.
     */
	@Override
	public void create () {
		world = new World(this, MAP_PATH);

		if (!serverMode) {
            Controller controller = new Controller();
            Gdx.input.setInputProcessor(controller);
            window = new Window();
            window.setTilesInstances(world);
        }
	}

    /**
     * Main Loop of the Game.
     * Game logic update and graphics render.
     */
	@Override
	public void render () {
        float delta = Gdx.graphics.getDeltaTime();
        this.world.updateLogic(delta);
        this.window.render(delta);
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
