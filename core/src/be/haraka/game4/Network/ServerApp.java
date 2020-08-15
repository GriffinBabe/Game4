package be.haraka.game4.Network;

import be.haraka.game4.Game;
import be.haraka.game4.Log;
import be.haraka.game4.Network.Packets.*;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;


/**
 * ServerApp is the main server class, extends the {@link Listener}
 * class.
 *
 * Contrary to {@link ClientApp}, ServerApp will run by itself the game.
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

    /** Number of times the game is updated per second server side */
    private static int TICK_RATE = 30;
    private static float TIME_PER_TICK = 1000.0f/((float) TICK_RATE);

    private static String LOG_PREFIX = "[Server]";
    public static Log log = new Log(LOG_PREFIX);

    /** Reference to the game */
    private Game game;

    private HashMap<String, User> userMap;

    public ServerApp(Game game) {
        this.game = game;
        game.create();
    }

    /**
     * Main game.
     */
    public void run() {
        float begin, end, delta = 0.0f;
        while (true) {
            // TODO: Find another way as Game is using Gdx.graphics.getDeltaTime();
            // https://stackoverflow.com/questions/30789626/how-can-i-run-a-libgdx-application-on-a-non-gui-server-environment
            begin = System.currentTimeMillis();

            game.render(delta);

            end = System.currentTimeMillis();
            delta = end - begin;
            if (delta< TIME_PER_TICK) {
                try {
                    Thread.sleep((long) (TIME_PER_TICK - delta));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                log.addMessage("Game render takes too long!");
            }
        }
    }

    /**
     * Starts a {@link com.esotericsoftware.kryonet.Server}
     * class and links this class as a listener.
     */
    public void start() {
        try {
            server.start();
            log.addMessage("Server started");
            server.bind(TCP_PORT, UDP_PORT);
            log.addMessage("Server bind to ports: "
                    +TCP_PORT+"/"+UDP_PORT);
            registerClasses();
        } catch (IOException e) {
            log.addMessage(e.getMessage());
            System.exit(-1);
        }
        server.addListener(this);
    }


    /**
     * Class packets that will be sent trought the
     * network needs to be registered before communicating,
     * according to the KryoNet's documentation.
     *
     * This function will register all the packet classes,
     * and is very identical to {@link ClientApp#registerClasses()}
     * method. Classes must be registered both in the same order.
     */
    @SuppressWarnings("Duplicates")
    private void registerClasses() {
        Kryo kryo = server.getKryo();
        kryo.register(Packet.class);
        kryo.register(ObjectPacket.class);
        kryo.register(MovePacket.class);
        kryo.register(IdlePacket.class);
        kryo.register(ConnectPacket.class);
        kryo.register(DisconnectionPacket.class);
        kryo.register(AcceptConnectPacket.class);
        kryo.register(DenyConnectPacket.class);
        kryo.register(UserConnectedPacket.class);
        kryo.register(LoadMapPacket.class);
    }

    /**
     * Will be called upon each new message received.
     * @param connection, the address of our client.
     * @param object, the given request.
     */
    @Override
    public void received(Connection connection, Object object) {
        // TODO: Handle requestes
        if (object instanceof ConnectPacket) {
            handleConnection(connection, (ConnectPacket) object);
        }
    }

    /**
     * Checks if the given username exists in the hashmap.
     * If it doesn't exists, we have a new connecting username.
     * If it does exists and the status in connected then the
     * connection is refused.
     * If it does exists and the status in disconnected then
     * we have a reconnection.
     *
     * @param connection, the connection address
     * @param packet, the {@link ConnectPacket} containing
     *                the username.
     */
    private void handleConnection(Connection connection, ConnectPacket packet) {
        User user = userMap.get(packet.username);
        if (user == null) {
            User newuser = new User(connection, packet.username);
            userMap.put(packet.username, newuser);
            newuser.setConnected();
            updateGame(connection, newuser);
        } else if (user.getStatus() == NetStatus.CONNECTED) {
            DenyConnectPacket denyPacket = new DenyConnectPacket();
            denyPacket.message = "An user is already connected with this username.";
            connection.sendTCP(denyPacket);
        } else if (user.getStatus() == NetStatus.DISCONNECTED) {
            AcceptConnectPacket acceptPacket = new AcceptConnectPacket();
            acceptPacket.message = "You reconnected.";
            connection.sendTCP(acceptPacket);
            user.setConnected();
            updateGame(connection, user);
        }
    }

    /**
     * Used to a new connecting, or reconnecting player to
     * update all the world's GameObjects.
     * @param connection
     * @param user
     */
    private void updateGame(Connection connection, User user) {
        // TODO: write that method
    }

    /**
     * Will be called upon new connection before
     * {@link #received(Connection, Object)}.
     *
     * @param connection, the address of our new client.
     */
    @Override
    public void connected(Connection connection) {
        log.addMessage("New client connected from address: "+connection.getRemoteAddressTCP());
    }

    /**
     * Called upon client disconnection.
     * @param connection, the disconnecting client.
     */
    @Override
    public void disconnected(Connection connection) {
        log.addMessage("Client from address: "+connection.getRemoteAddressTCP()+" disconnected.");
        // Disconnecting user
        User user = getUserByConnection(connection);
        if (user != null) {
            user.setDisconnected();
        }
        super.disconnected(connection);
    }

    /**
     * Searches into the hashmap for a user with the given
     * {@link Connection}.
     *
     * @param connection, the connection of the user we
     *                    want to search.
     * @return the user, null if no match.
     */
    private User getUserByConnection(Connection connection) {
        Iterator it = userMap.entrySet().iterator();
        while (it.hasNext()) {
            User user = (User) it.next();
            if (user.matchConnection(connection)) {
                return user;
            }
        }
        return null;
    }

}
