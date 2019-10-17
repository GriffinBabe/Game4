package be.haraka.game4.Network.Packets;

import be.haraka.game4.Model.PlayerRole;

import java.util.ArrayList;
import java.util.List;

/**
 * Will be sent from the server to the client
 * when the round starts. It will give information
 * on users and their role.
 */
public class StartRoundPacket {

    /**
     * This internal class will describe what each player will
     * play as a role.
     */
    class PlayerRoundInfo {
        String username;
        PlayerRole role;

        public PlayerRoundInfo(String username, PlayerRole role) {
            this.username = username;
            this.role = role;
        }
    }

    List<PlayerRoundInfo> informations = new ArrayList<>();
}
