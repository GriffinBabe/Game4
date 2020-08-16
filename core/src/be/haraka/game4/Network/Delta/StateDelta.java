package be.haraka.game4.Network.Delta;

import be.haraka.game4.Model.GameObject;

/**
 * Represents a change of a {@link GameObject} property during time.
 * Usually this is contained by a {@link be.haraka.game4.Network.Packets.DeltaSnapshotPacket}.
 */
public abstract class StateDelta {

    /** Reference {@link be.haraka.game4.Model.GameObject} ID */
    protected long ID;

    StateDelta(long id) {
        this.ID = id;
    }
}
