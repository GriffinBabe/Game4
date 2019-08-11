package be.haraka.game4.Graphics;

import java.util.Comparator;

/**
 * Custom collection comparator to order our {@link Window#renderInstances} list.
 */
public class RenderOrderComparator implements Comparator<ObjectInstance> {

    /**
     * First will be compared the priority of the model.
     * Some Models will always be under others
     * (eg. mobs will always be over grass).
     *
     * If the priority is the same then the x+y coordinates are directly
     * compared, so we check wich classes are "closer to the camera".
     *
     * For some reasons the result must be reversed.
     *
     * @param o1, an ObjectInstance from our list
     * @param o2, another objectInstance we want to compare with the first.
     * @return returns 1 if o1 has priority on o2, 0 else.
     */
    @Override
    public int compare(ObjectInstance o1, ObjectInstance o2) {
        if (o1.getRenderPriority() > o2.getRenderPriority()) {
            return 1;
        }
        if (o1.getRenderPriority() < o2.getRenderPriority()) {
            return -1;
        }

        float xy1 = o1.getX() + o1.getY();
        float xy2 = o2.getX() + o2.getY();
        return -1 * Float.compare(xy1, xy2);

    }
}
