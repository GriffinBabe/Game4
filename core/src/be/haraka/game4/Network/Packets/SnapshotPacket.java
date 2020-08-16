package be.haraka.game4.Network.Packets;

/**
 * Base of all snapshot updates.
 * Snapshots are sent by the server to the clients.
 * The snapshots are packets send over the UDP protocol.
 */
public abstract class SnapshotPacket extends Packet {

    /**
     * A tick is a whole server simulation, running by default at 40 ticks/sec.
     * This tick variable says in which tick this packet has been generated.
     */
    public int tick;
}
