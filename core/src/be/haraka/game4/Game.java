package be.haraka.game4;

import be.haraka.game4.Controls.Controller;
import be.haraka.game4.Graphics.Window;
import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.MobSpawner;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.Mob.Mob;
import be.haraka.game4.Model.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;

/**
 * Main model class. Entry point from LIBGDX.
 *
 * @author GriffinBabe
 */

public class Game extends ApplicationAdapter {

    // Server mode disable all the graphics
    public static boolean SERVER_MODE = false;

    // Used by several classes, mostly graphical
    public static int LOCAL_PLAYER_TEAM = 1;
    public static Player LOCAL_PLAYER = null;

    private static String MAP_PATH = "assets/map/map2.json";

    private World world;
    private Controller controller = null;
    private Window window = null;

    private List<Player> players = new ArrayList<>();

    /**
     * Called when the game is started.
     */
	@Override
	public void create () {
		world = new World(this, MAP_PATH);

		if (!SERVER_MODE) {
		    // TODO: Give local mob to player.
            window = new Window();
            window.setTilesInstances(world);

            MobSpawner spawner = new MobSpawner();
            Mob human = spawner.spawnMob("mob-human");
            human.setX(5); human.setY(5);
            world.newObject(human);
            LOCAL_PLAYER = new Player("GriffinBabe", human);
            players.add(LOCAL_PLAYER);

            Mob human2 = spawner.spawnMob("mob-human");
            human2.setX(1);
            human2.setY(1);
            world.newObject(human2);

            controller = new Controller(this, window, LOCAL_PLAYER);
            Gdx.input.setInputProcessor(controller);
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
