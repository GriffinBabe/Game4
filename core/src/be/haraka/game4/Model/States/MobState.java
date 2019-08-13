package be.haraka.game4.Model.States;

public abstract class MobState implements State {

    protected String name;

    public MobState(String stateName) {
        this.name = stateName;
    }

    @Override
    public String getStateName() {
        return name;
    }
}
