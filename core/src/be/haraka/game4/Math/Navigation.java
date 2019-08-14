package be.haraka.game4.Math;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Util navigation class.
 */
public class Navigation {

    /**
     * Computes the path between the object and the destination using pathfinding
     * algorithms.
     *
     * @param world the world where our object needs to move
     * @param object the object that we want to move
     * @param destination the destination point of our object
     * @return
     */
    public static List<Vec2f> ComputePath(World world, GameObject object, Vec2f destination) {
        // TODO: Calculate the list
        return new ArrayList<Vec2f>();
    }

    /**
     * Calculates if there is no obstacles in the line between the given gameobject and
     * the given destination.
     *
     * @param world the world we check our obstacles.
     * @param object the object where the line starts.
     * @param destination the point where the line ends.
     * @return true if there is no obstacle, false if there is an obstacle.
     */
    public static boolean lineOfSight(World world, GameObject object, Vec2f destination) {
        // TODO : finish the line of sight
        List<GameObject> obstacles = world.getObstacles();
        return true;
    }

}
