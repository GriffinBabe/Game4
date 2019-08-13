package be.haraka.game4.Controls;

import be.haraka.game4.Model.States.MobIdleState;
import be.haraka.game4.Model.States.State;

/**
 * InterruptCommand, extends {@link Command}.
 *
 * Interrupt command will interrupt some states,
 * setting the player's new state to {@link MobIdleState}.
 */
public class InterruptCommand extends Command {

    private static CommandType COMMAND_TYPE = CommandType.INTERRUPT;

    public InterruptCommand() {
        super(COMMAND_TYPE);
    }

    @Override
    public State applyTo(State state) {
        switch (state.getStateType()) {
            case WALK:
                return new MobIdleState();
        }
        return null;
    }
}
