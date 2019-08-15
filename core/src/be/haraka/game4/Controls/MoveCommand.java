package be.haraka.game4.Controls;

import be.haraka.game4.Math.Vec2f;
import be.haraka.game4.Model.Mob.Mob;
import be.haraka.game4.Model.States.MobWalkState;
import be.haraka.game4.Model.States.State;

public class MoveCommand extends Command {

    private static Command.CommandType COMMAND_TYPE = Command.CommandType.MOVE;

    private Mob mob;
    private Vec2f destination;

    public MoveCommand(Mob mob, Vec2f dest) {
        super(COMMAND_TYPE);
        this.mob = mob;
        this.destination = dest;
    }

    @Override
    public State applyTo(State state) {
        switch (state.getStateType()) {
            case IDLE:
                return new MobWalkState(destination);
            case WALK:
                ((MobWalkState) state).changeDestination(destination);
                break;
        }
        return null;
    }
}
