package be.haraka.game4.Model.States;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.Mob.Event;

public class MobIdleState extends MobState {

    private static StateType STATE_TYPE = StateType.IDLE;

    private boolean mobNoticed = false;

    public MobIdleState() {
        super(STATE_TYPE);
    }

    @Override
    public State updateState(float delta, GameObject object, World world) {
        if (!mobNoticed) {
            // Notifies observers that the mob switched to a IDLE STATE
            object.notifyObservers(Event.STATE_IDLE);
            mobNoticed = true;
        }
        return null;
    }

    @Override
    public void enter(GameObject object, World world) {
    }

    @Override
    public void exit(GameObject object, World world) {

    }

}
