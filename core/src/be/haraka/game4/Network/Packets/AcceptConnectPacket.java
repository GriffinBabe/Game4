package be.haraka.game4.Network.Packets;

/**
 * Sent from the server to the client when a connection is accepeted.
 */
public class AcceptConnectPacket extends Packet {

    /** The welcoming message */
    public String message;

    /** Server update rate information */
    public int tickrate;

    /** Server snapshot rate information */
    public int snaprate;
}
