package be.haraka.game4.Model.States;

public abstract class MobState implements State {

    protected String name;
    protected StateType type;

    public MobState(StateType type) {
        this.type = type;
    }

    @Override
    public State.StateType getStateType() {
        return type;
    }
}
