package be.haraka.game4.Network.Packets;

/**
 * Packet sent from the server to the client
 * to order the client to load a specific map.
 */
public class LoadMapPacket {

    /** Map file path */
    public String mapPath;
}
