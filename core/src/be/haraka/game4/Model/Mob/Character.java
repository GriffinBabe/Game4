package be.haraka.game4.Model.Mob;

/**
 * Character class. Attributes will be loaded from JSON File, just like
 * Mobs and items.
 *
 * @author GriffinBabe
 */
public abstract class Character extends Mob {

    // TODO: Implement Prototype pattern.

    public Character(float x, float y) {
        super(x,y);
    }

}
