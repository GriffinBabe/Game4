package be.haraka.game4.Controls;

import be.haraka.game4.Model.GameObject;
import be.haraka.game4.Model.Mob.Mob;
import be.haraka.game4.Model.States.MobWalkState;
import be.haraka.game4.Model.States.State;

public class MoveCommand extends Command {

    private static Command.CommandType COMMAND_TYPE = Command.CommandType.MOVE;

    private Mob mob;
    private GameObject.Direction direction;

    public MoveCommand(Mob mob, GameObject.Direction direction) {
        super(COMMAND_TYPE);
        this.mob = mob;
        this.direction = direction;
    }

    @Override
    public State applyTo(State state) {
        switch (state.getStateType()) {
            case IDLE:
                return new MobWalkState(direction);
            case WALK:
                return new MobWalkState(direction);
        }
        return null;
    }
}
