package be.haraka.game4.Controls;

import be.haraka.game4.Game;
import be.haraka.game4.Graphics.Window;
import be.haraka.game4.Math.Translations;
import be.haraka.game4.Math.Vec2f;
import be.haraka.game4.Model.Player;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

/**
 * Controller class, will read user key inputs
 * of keyboard and mouse and will.
 *
 * TODO: Add a JSON Parser to config all the keybindings.
 */
public class Controller implements InputProcessor {


    private Game game;
    private Player localPlayer;
    private Window window;

    public Controller(Game game, Window window, Player localPlayer) {
        this.window = window;
        this.game = game;
        this.localPlayer = localPlayer;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.S:
                interruptLocalPlayer();
                return true;
        }
        return false;
    }


    @Override
    public boolean keyUp(int keycode) {

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        switch (button) {
            case 1: // Left-click
                moveLocalCharacter(screenX, screenY);
                break;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    /**
     * Reads the scroll from the mouse.
     *
     * @param amount, negative if scroll up, positive if
     *                scroll down.
     * @return if the input has been processed.
     */
    @Override
    public boolean scrolled(int amount) {
        if (amount < 0) {
            window.zoomOut();
            return true;
        } else if (amount > 0) {
            window.zoomIn();
            return true;
        }
        return false;
    }

    private void moveLocalCharacter(int screenX, int screenY) {
        Vector3 projected = new Vector3(screenX, screenY, 0);
        window.unproject(projected); // Unprojects with the camera zoom, position matrix.
        Vec2f position = Translations.screenToIso((int)projected.x, (int)projected.y);
        Command command = new MoveCommand(localPlayer.getMob(), position);
        localPlayer.getMob().addCommand(command);
        // TODO: Maybe there is a better solution, as this violate Demeter's law.
    }

    private void interruptLocalPlayer() {
        Command command = new InterruptCommand();
        localPlayer.getMob().addCommand(command);
    }

}
