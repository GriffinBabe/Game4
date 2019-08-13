package be.haraka.game4.Model.States;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;

/**
 * Implementation of the Finite State Machines
 * algorithm. The state defines the behaviour
 * of the mob on update time.
 */
public interface State {

    /**
     * Called on the main game loop, will update
     * the GameObject state.
     *
     * @param object, the updated GameObject
     * @param world
     */
    State updateState(float delta, GameObject object, World world);

    /**
     * Called when the gameobject just entered the state.
     * @param object
     * @param world
     */
    void enter(GameObject object, World world);

    /**
     * Called when the gameobject exits the state.
     * @param object
     * @param world
     */
    void exit(GameObject object, World world);

    StateType getStateType();

    enum StateType {

        IDLE(0, "idle"),
        WALK(1, "walk");

        public int stateId;
        public String stateName;

        StateType(int stateId, String stateName) {
            this.stateId = stateId;
            this.stateName = stateName;
        }
    }
}
