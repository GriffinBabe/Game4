package be.haraka.game4.Controls;

import be.haraka.game4.Model.States.State;

/**
 * Command pattern used by networking and player's input.
 * Will act on the player's character {@link be.haraka.game4.Model.Mob.Mob#actionState}, or directly
 * on the {@link be.haraka.game4.Model.Mob.Character}.
 *
 * @author GriffinBabe
 */
public abstract class Command {

    protected CommandType type;

    public Command(CommandType type) {
        this.type = type;
    }

    public abstract State applyTo(State state);

    public enum CommandType {

        MOVE(0),
        INTERRUPT(1);

        public int commandID;

        CommandType(int id) {
            commandID = id;
        }
    }
}
