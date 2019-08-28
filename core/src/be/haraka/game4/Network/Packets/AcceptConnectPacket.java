package be.haraka.game4.Network.Packets;

/**
 * Sent from the server to the client when a connection is accepeted.
 */
public class AcceptConnectPacket extends Packet {

    /** The team of the player */
    public char team;
}
