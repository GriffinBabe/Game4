package be.haraka.game4.Network;

import be.haraka.game4.Log;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;


/**
 * ServerApp is the main server class, extends the {@link Listener}
 * class.
 *
 * {@link #received(Connection, Object)} will handle all the received packets.
 *
 * The UDP and TCP ports are defined by default.
 */
public class ServerApp extends Listener {

    Server server = new Server();

    public static int TCP_PORT = 2049;
    public static int UDP_PORT = 2050;
    public static String LOCAL_IP = "localhost";

    private static String LOG_PREFIX = "[Server]";
    public static Log log = new Log(LOG_PREFIX);

    /**
     * Starts a {@link com.esotericsoftware.kryonet.Server}
     * class and links this class as a listener.
     */
    public void start() {
        try {
            server.start();
            server.bind(TCP_PORT, UDP_PORT);
        } catch (IOException e) {
            log.addMessage(e.getMessage());
            System.exit(-1);
        }
        server.addListener(this);
    }

    /**
     * Will be called upon each new message received.
     * @param connection, the address of our client.
     * @param object, the given request.
     */
    @Override
    public void received(Connection connection, Object object) {
        // TODO: Handle requestes
    }

    /**
     * Will be called upon new connection before
     * {@link #received(Connection, Object)}.
     *
     * @param connection, the address of our new client.
     */
    @Override
    public void connected(Connection connection) {
        log.addMessage("New client connected from address: "+connection.toString());
        // TODO: Handle new connection.
    }

    /**
     * Called upon client disconnection.
     * @param connection, the disconnecting client.
     */
    @Override
    public void disconnected(Connection connection) {
        log.addMessage("Client from address: "+connection.toString()+" disconnected.");
        super.disconnected(connection);
    }
}
