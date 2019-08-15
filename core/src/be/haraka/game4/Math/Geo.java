package be.haraka.game4.Math;

/**
 * Game Geometry util class
 */
public class Geo {

    /**
     * Get's the angle between the x axis and the line connecting
     * the point p1 to the point p2. The returned angle is in radiants
     * and ranges from 0 to 2pi
     *
     * @param p1 begin of line
     * @param p2 end of line
     * @return the angle
     */
    public static float getAngle(Vec2f p1, Vec2f p2) {
        float angle = (float) Math.atan((p2.y - p1.y)/(p2.x - p1.x));
        // p2 is behind p1
        if (p1.x > p2.x) {
            angle += Math.PI;
        }
        /*
        if (p1.y > p2.y) {
            angle = (float) (2* Math.PI - Math.abs(angle));
        }
        */
        return angle;
        // P1 is behind p2
    }

    /**
     * Gets the distance between two points with Pythagoras equation.
     * @param p1, first point
     * @param p2, second point
     * @return the distance between the two given points.
     */
    public static float getDistance(Vec2f p1, Vec2f p2) {
        return (float) Math.sqrt(Math.pow(p2.x - p1.x, 2)
                + Math.pow(p2.y - p1.y, 2));
    }
}
