package be.haraka.game4.desktop;

import be.haraka.game4.Client;
import be.haraka.game4.Game;
import be.haraka.game4.Server;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {

	private static int FPS_CAP = 60;

	private static String SERVER_MODE = "-server";

	public static void main (String[] arg) {
		if (arg[0].equals(SERVER_MODE)) {
            Server server = new Server();
            server.start();
		} else {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.foregroundFPS = FPS_CAP;
			new LwjglApplication(new Game(), config);
		}
	}
}
