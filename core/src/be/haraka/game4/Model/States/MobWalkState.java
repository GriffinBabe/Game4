package be.haraka.game4.Model.States;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.Mob.Mob;
import be.haraka.game4.Model.Mob.SolidObject;


/**
 * Walk state, extends {@link MobState}, will
 * update the position of the mob.
 */
public class MobWalkState extends MobState {

    private GameObject.Direction direction;
    private float speed = 0.0f;

    // If we already changed the direction of the moving mob.
    private boolean mobNoticed = false;

    private static StateType STATE_TYPE = StateType.WALK;

    public MobWalkState(GameObject.Direction direction) {
        super(STATE_TYPE);
        this.direction = direction;

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
        if (!mobNoticed) {
            object.changeDirection(direction);
        }
        float oldX = object.x();
        float oldY = object.y();
        walk((Mob) object, world, delta);
        if (world.isColliding((SolidObject)object) != null) {
            object.setX(oldX);
            object.setY(oldY);
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
    private void walk(Mob mob, World world, float delta) {
        float tileSpeed = world.speedAt((int)mob.x(), (int)mob.y());
        float tempMaxSpeed = tileSpeed * mob.getMaxMovementSpeed();
        float acceleration = mob.getAcceleration();

        if (speed + acceleration >= tempMaxSpeed) {
            speed = tempMaxSpeed;
        } else {
            speed += acceleration;
        }

        switch (direction) {
            case N:
                mob.move(speed,0);
                break;
            case S:
                mob.move(-speed, 0);
                break;
            case E:
                mob.move(0, speed);
                break;
            case W:
                mob.move(0, -speed);
                break;
        }
    }

    @Override
    public void enter(GameObject object, World world) {

    }

    @Override
    public void exit(GameObject object, World world) {

    }

}
