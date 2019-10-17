package be.haraka.game4.desktop;

import be.haraka.game4.Network.ClientApp;
import be.haraka.game4.Game;
import be.haraka.game4.Network.ServerApp;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.lwjgl.Sys;

public class DesktopLauncher {

	private static int FPS_CAP = 60;

	private static String SERVER_MODE = "-server";

	public static void main (String[] arg) {
		if (arg.length > 0) {
			if (arg[0].equals(SERVER_MODE)) {
			    Game game = new Game();
			    Game.SERVER_MODE = true; // sets the game to server mode.
                ServerApp server = new ServerApp(game);
                server.start();
            }
		} else {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.foregroundFPS = FPS_CAP;
			Game game = new Game();
			Game.SERVER_MODE = false; // sets the game to client mode.
			ClientApp client = new ClientApp(game);
			client.start();
			new LwjglApplication(game, config);
		}

	}
}
