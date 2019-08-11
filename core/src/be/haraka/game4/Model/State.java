package be.haraka.game4.Model;

/**
 * State pattern base class.
 *
 * @author GriffinBabe
 */
public enum State {

    IDLE(0),
    WALK(1),
    AUTOATTACK(2);

    private int stateID;

    State(int i) {
        this.stateID = i;
    }
}
