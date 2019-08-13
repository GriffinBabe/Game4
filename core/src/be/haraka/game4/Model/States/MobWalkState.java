package be.haraka.game4.Model.States;

import be.haraka.game4.Controls.Command;
import be.haraka.game4.Math.Geo;
import be.haraka.game4.Math.Vec2f;
import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.Mob.Mob;

import java.util.List;

public class MobWalkState extends MobState {

    /**
     * The steps we need to do to walk.
     * List containing points of our path.
     */
    private List<Vec2f> steps;

    /**
     * Destination (basically where the player "clicked").
     */
    private Vec2f destination;

    private static String STATE_NAME = "walk";

    /**
     * Flag that tracks if the path is valid or not.
     *
     * If not, the state will exit.
     */
    private boolean pathValid = true;
    private boolean pathFinished = false;

    public MobWalkState(Vec2f destination) {
        super(STATE_NAME);
        this.destination = destination;
        computeSteps();

    }

    /**
     * Computes the optimal path with dijkstra's algorithm.
     * If not valid path has been found, it changes the flag
     * {@link #pathValid} to false.
     */
    private void computeSteps() {
        // TODO: Compute the path to destination.
        pathValid = true;
    }

    /**
     * Checks if the previously computed path is still valid.
     *
     * If not, it changes the flag {@link #pathValid} to false.
     */
    private void checkPathValidity() {
        // TODO: Check whole path validity
        pathValid = true;
    }

    /**
     * Checks if the path is valid and unfinished, if yes, walks and
     * then checks again if the path is still unfinished.
     *
     * @param delta, time elapsed since last call.
     * @param object, the updated GameObject.
     * @param world, world our object moves into.
     * @return a new State if the walking step is done/interrupted,
     *          null if the character will still walk.
     */
    @Override
    public State updateState(float delta, GameObject object, World world) {
        // TODO: Entire path completion, not only a single line.
        checkPathValidity();
        if (pathValid && !pathFinished) {
            walk(((Mob) object), delta);
            if (pathFinished) {
                return new MobIdleState();
            }
        }
        else {
            return new MobIdleState();
        }
        return null;
    }

    /**
     * At this point, no obstacle has been found.
     * This method will just simply update the position
     * of the mob.
     *
     * @param mob
     * @param delta
     */
    private void walk(Mob mob, float delta) {
        float angle = Geo.getAngle(new Vec2f(mob.x(), mob.y()), destination);
        float speed = mob.getMovementSpeed() * delta;

        float dx = (float)(speed*Math.cos(angle));
        float dy = (float)(speed*Math.sin(angle));

        // TODO: Check if collided, if finished the path.
        if (Geo.getDistance(new Vec2f(mob.x(), mob.y()), destination) <= speed) {
            mob.setX(destination.x);
            mob.setY(destination.y);
            pathFinished = true;
        } else {
            mob.move(dx, dy);
        }
    }

    @Override
    public void enter(GameObject object, World world) {

    }

    @Override
    public void exit(GameObject object, World world) {

    }

    @Override
    public State handleCommand(Command command) {
        return null;
    }

}
