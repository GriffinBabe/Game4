package be.haraka.game4.Network.Packets;

/**
 * Extends the {@link Packet} class.
 * Class that inherit from this one will
 * be packets related to gameobjects, and
 * not utility packet such as connection,
 * messages, etc...
 *
 */
public abstract class ObjectPacket extends Packet {

    /** The ID of the related GameObject */
    public int id;
}
