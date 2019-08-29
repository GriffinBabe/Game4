package be.haraka.game4.Network;

/**
 * Enum class for net status, such as connected, disconnected etc...
 */
public enum NetStatus {

    CONNECTED(1),
    DISCONNECTED(2),
    UNKNOWN(3);

    public int id;

    NetStatus(int id) {
        this.id = id;
    }
}
