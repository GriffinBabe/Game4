package be.haraka.game4.Network.Packets;

import be.haraka.game4.Network.Delta.StateDelta;

import java.util.ArrayList;

/**
 * Is a {@link SnapshotPacket} that gives the state changes by filling a list
 * of {@link StateDelta} objects.
 */
public class DeltaSnapshotPacket extends SnapshotPacket {

    /**
     * Represents the server tick that this snapshot is comparing with.
     */
    public int lastTick;

    /**
     * List of changes that must be applied to the game state.
     */
    public ArrayList<StateDelta> stateChanges = new ArrayList<>();

}
