package be.haraka.game4.Model;

/**
 * This class describes the role of the player
 * in the current round.
 */
public enum PlayerRole {

    HUMAN(1),
    WOLF(2),
    SPECTATOR(0);

    int id;
    PlayerRole(int id) {
        this.id = id;
    }
}
