package be.haraka.game4.desktop;

import be.haraka.game4.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {

	private static int FPS_CAP = 60;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.foregroundFPS = FPS_CAP;
		new LwjglApplication(new Game(), config);
	}
}
