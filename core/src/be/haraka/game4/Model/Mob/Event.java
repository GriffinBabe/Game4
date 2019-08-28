package be.haraka.game4.Model.Mob;

public enum Event {

    CHANGED_STATE(0),
    CHANGED_DIRECTION(1),
    STATE_WALK(2),
    STATE_IDLE(4);

    public int id;

    Event(int id) {
        this.id = id;
    }
}
