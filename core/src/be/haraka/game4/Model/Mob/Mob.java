package be.haraka.game4.Model.Mob;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.State;

public class Mob extends GameObject {

    private State state = State.IDLE;

    public Mob(float x, float y) {
        super(x,y);
    }
}
