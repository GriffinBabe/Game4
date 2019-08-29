package be.haraka.game4.Network.Packets;

/**
 * Sent from the server to the client when a connection is denied.
 */
public class DenyConnectPacket extends Packet {

    /** The reason of the deny */
    public String message;
}
