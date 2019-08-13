package be.haraka.game4.Model.States;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.Mob.Event;

public class MobIdleState extends MobState {

    private static StateType STATE_TYPE = StateType.IDLE;

    public MobIdleState() {
        super(STATE_TYPE);
    }

    @Override
    public State updateState(float delta, GameObject object, World world) {
        return null;
    }

    @Override
    public void enter(GameObject object, World world) {
        Object arguments[] = {Event.CHANGED_STATE, this};
        object.notifyObservers(arguments);
    }

    @Override
    public void exit(GameObject object, World world) {

    }

}
