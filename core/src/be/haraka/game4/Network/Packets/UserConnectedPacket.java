package be.haraka.game4.Network.Packets;

/**
 * Packet sent by the server to all connected clients
 * to say a new user has connected.
 */
public class UserConnectedPacket {
    public String username;
}
