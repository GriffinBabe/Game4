package be.haraka.game4.Graphics;

import be.haraka.game4.Game;
import be.haraka.game4.Math.Translations;
import be.haraka.game4.Math.Vec2i;
import be.haraka.game4.Model.Mob.Mob;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Camera manager class. Will update the camera position,
 * set the projection matrix to the batch, and act on zoom in,
 * zoom out.
 *
 * If the camera is locked, it will simply follow the player.
 *
 * @author GriffinBabe.
 */
public class Camera {

    // Zoom constants
    private static float INIT_ZOOM = 2.0f;
    private static float MAX_ZOOM = 4.0f;
    private static float MIN_ZOOM = 1.0f;
    private static float ZOOM_STEP = 0.1f;

    // Screen edges constants
    private static int EDGE_MARGIN = 50;

    // TODO: Update them relatively to the map dimensions.
    private static int MIN_X = 0;
    private static int MAX_X = 1000;
    private static int MIN_Y = -800;
    private static int MAX_Y = 800;

    // Camera speed constant
    private static float CAM_SPEED = 1000.0f;

    // If locked it will follow the player
    private boolean locked = false;

    // Libgdx camera class, used for opengl.
    private OrthographicCamera camera;

    public Camera() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.zoom = INIT_ZOOM;

    }

    /**
     * Update method, called on game loop. Will update the position and
     * set the projection view matrix to the batch.
     *
     * localPlayer instance is also given to make the camera follow the player.
     *
     * @param deltaTime, elapsed time since last loop.
     * @param batch, LibGDX batch used fot opengl as a render layer.
     */
    public void update(float deltaTime, SpriteBatch batch) {
        // Camera is programmed to follow the localPlayer when locked.

        if (locked) {
            // TODO: Something to follow the player around.
            Mob mob = Game.LOCAL_PLAYER.getMob();
            Vec2i position = Translations.orthoToScreen(mob.x(), mob.y());
            camera.position.set(position.toGdxVector2(), 0);
        } else {
            if (Gdx.input.getX() < EDGE_MARGIN & camera.position.x > MIN_X)
                camera.translate(-CAM_SPEED*deltaTime,0,0);

            else if (Gdx.input.getX() > Gdx.graphics.getWidth() - EDGE_MARGIN & camera.position.x < MAX_X)
                camera.translate(CAM_SPEED*deltaTime,0,0);

            if (Gdx.input.getY() < EDGE_MARGIN & camera.position.y < MAX_Y)
                camera.translate(0,CAM_SPEED*deltaTime,0);

            else if (Gdx.input.getY() > Gdx.graphics.getHeight() - EDGE_MARGIN & camera.position.y > MIN_Y)
                camera.translate(0,-CAM_SPEED*deltaTime,0);
        }
        batch.setProjectionMatrix(camera.combined);
        camera.update();
    }

    /**
     * Toggles the camera lock on the player.
     */
    public void toggleLock() {
        locked = !locked;
    }

    /**
     * Zooms in. Maxium and minimum values are
     * set as constants.
     */
    public void zoomIn() {
        if (camera.zoom <= MAX_ZOOM) {
            camera.zoom += ZOOM_STEP;
        }
    }

    /**
     * Zooms out. Maximum and minimum values are
     * set as constants.
     */
    public void zoomOut() {
        if (camera.zoom >= MIN_ZOOM) {
            camera.zoom -= ZOOM_STEP;
        }
    }

    /**
     * Libgdx feature to unproject the view from the camera.
     * Used to get where we clicked.
     *
     * @param screenPos, click position on the screen, will be modified.
     */
    public void unproject(Vector3 screenPos) {
        camera.unproject(screenPos);
    }
}
