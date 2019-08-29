package be.haraka.game4.Network;

import be.haraka.game4.Model.Player;
import com.esotericsoftware.kryonet.Connection;

/**
 * Class used by the ServerApp, will contain the player class with connection informations
 */
public class User {

    private Player player;
    private Connection connection;

    private NetStatus status = NetStatus.UNKNOWN;

    public User(Connection connection, String username) {
        this.connection = connection;
        this.player = new Player(username);
    }

    public void setConnected() {
        this.status = NetStatus.CONNECTED;
    }

    public void setDisconnected() {
        this.status = NetStatus.DISCONNECTED;
    }

    public NetStatus getStatus() {
        return status;
    }

    /**
     * Returns true if the given connection is the current's
     * user connection.
     *
     * Returns false otherwhise.
     * @param connection, the connection we want to compare.
     * @return true if equals else false.
     */
    public boolean matchConnection(Connection connection) {
        return this.connection == connection;
    }
}
