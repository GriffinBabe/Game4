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
	private static String CLIENT_TEST_MODE = "-client";

	public static void main (String[] arg) {
		if (arg.length > 0) {
			if (arg[0].equals(SERVER_MODE)) {
				ServerApp server = new ServerApp();
				server.start();
			} else if (arg[0].equals(CLIENT_TEST_MODE)) {
				ClientApp clientApp = new ClientApp();
				clientApp.start();
			} else {
				System.out.println("Unknown parameter");
			}
		} else {
			LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
			config.foregroundFPS = FPS_CAP;
			new LwjglApplication(new Game(), config);
		}
	}
}
