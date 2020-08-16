package be.haraka.game4.Network.Packets;

/**
 * Packet sent by the server to all connected clients
 * to say a user has disconnected.
 */
public class UserDisconnectedPacket {
    public String username;
}
