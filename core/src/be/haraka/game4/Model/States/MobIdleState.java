package be.haraka.game4.Model.States;

import be.haraka.game4.Controls.Command;
import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Map.World;
import be.haraka.game4.Model.Mob.Event;

public class MobIdleState extends MobState {

    private static String STATE_NAME = "idle";

    public MobIdleState() {
        super(STATE_NAME);
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

    @Override
    public State handleCommand(Command command) {
        return null;
    }

    @Override
    public String getStateName() {
        return name;
    }
}
