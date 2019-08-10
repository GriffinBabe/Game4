package be.haraka.game4;

import be.haraka.game4.Graphics.Window;
import be.haraka.game4.Model.GameObject;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {

    // Server mode disable all the graphics
    public boolean serverMode = false;

	@Override
	public void create () {
		Window.Init();
	}

	@Override
	public void render () {
		Window.render(0.0f);
	}
	
	@Override
	public void dispose () {

	}

    /**
     * Called when a new object is created on the game.
     * This will directly call a function on the window
     * to create a new instance.
     * @param o
     */
	public static void newObject(GameObject o) {
	    Window.newObject(o);
    }
}
