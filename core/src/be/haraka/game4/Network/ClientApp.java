package be.haraka.game4.Network;

import be.haraka.game4.Game;
import be.haraka.game4.Log;
import be.haraka.game4.Model.Mob.Event;
import be.haraka.game4.Network.Packets.*;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class ClientApp extends Listener implements Observer {

    private Client client = new Client();
    // 5 sec connection timeout.
    private static int TIME_OUT = 5000;

    private static String LOG_PREFIX = "[Network] ";
    public static Log networkLog = new Log(LOG_PREFIX);

    /** Reference to the game. */
    private Game game;

    public ClientApp(Game game) {
        this.game = game;
    }

    public void start() {
        try {
            client.start();
            registerClasses();
            client.connect(TIME_OUT, ServerApp.LOCAL_IP,
                    ServerApp.TCP_PORT, ServerApp.UDP_PORT);
            ConnectPacket packet = new ConnectPacket();
            packet.username = "GriffinBabe";
            client.sendTCP(packet);
        } catch (IOException e) {
            networkLog.addMessage(e.getMessage());
            // TODO: couldn't connect to server message.
        }

    }

    /**
     * Class packets that will be sent trought the
     * network needs to be registered before communicating,
     * according to the KryoNet's documentation.
     *
     * This function will register all the packet classes,
     * and is very identical to {@link ServerApp#registerClasses()}
     * method. Classes must be registered both in the same order.
     */
    @SuppressWarnings("Duplicates")
    private void registerClasses() {
        Kryo kryo = client.getKryo();
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

    @Override
    public void connected(Connection connection) {
        super.connected(connection);
    }

    @Override
    public void disconnected(Connection connection) {
        super.disconnected(connection);
    }


    /**
     * Called when a GameObject is performing an action, as moving,
     * changing state, etc... Will then act on the server.
     *
     * @param o, the observable.
     * @param arg, Event from the observable.
     */
    @Override
    public void update(Observable o, Object arg) {
        switch ((Event) arg) {
            case CHANGED_STATE:

        }
    }
}