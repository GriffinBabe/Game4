package be.haraka.game4.Network;

import be.haraka.game4.Log;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;

public class ClientApp extends Listener {

    private Client client = new Client();
    // 5 sec connection timeout.
    private static int TIME_OUT = 5000;

    private static String LOG_PREFIX = "[Network] ";
    public static Log networkLog = new Log(LOG_PREFIX);

    public void start() {
        try {
            client.start();
            client.connect(TIME_OUT, ServerApp.LOCAL_IP,
                    ServerApp.TCP_PORT, ServerApp.UDP_PORT);
        } catch (IOException e) {
            networkLog.addMessage(e.getMessage());
            // TODO: couldn't connect to server message.
        }

    }

    @Override
    public void connected(Connection connection) {
        super.connected(connection);
    }

    @Override
    public void disconnected(Connection connection) {
        super.disconnected(connection);
    }

    @Override
    public void received(Connection connection, Object object) {
        super.received(connection, object);
    }
}
