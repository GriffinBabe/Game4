package be.haraka.game4.Network.Packets;

/**
 * Packet sent over connection.
 * Teams and position are decided by the server.
 */
public class ConnectPacket extends Packet {

    /** Chosen username from the player */
    public static String username;
}
