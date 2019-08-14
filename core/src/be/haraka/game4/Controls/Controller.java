package be.haraka.game4.Controls;

import be.haraka.game4.Game;
import be.haraka.game4.Graphics.Window;
import be.haraka.game4.Math.Translations;
import be.haraka.game4.Math.Vec2f;
import be.haraka.game4.Model.Player;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

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

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    private void moveLocalCharacter(int screenX, int screenY) {
        Vec2f position = Translations.screenToIso(screenX, screenY);
        System.out.println(position.x+" "+position.y);
        /*
        Command command = new MoveCommand(localPlayer.getMob(), position);
        localPlayer.getMob().addCommand(command);
        // TODO: Maybe there is a better solution, as this violate Demeter's law.
        */
    }

    private void interruptLocalPlayer() {
        Command command = new InterruptCommand();
        localPlayer.getMob().addCommand(command);
    }

}
