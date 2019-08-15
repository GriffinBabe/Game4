package be.haraka.game4.Graphics.Instances;

import be.haraka.game4.Model.Player;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayerInstance extends MobInstance {

    Player player;
    boolean isLocalPlayer = false;

    public PlayerInstance(Player player) {
        super(player.getMob());
    }

    public PlayerInstance(Player player, boolean isLocalPlayer) {
        super(player.getMob());
        this.isLocalPlayer = isLocalPlayer;
    }

    @Override
    public void render(float delta, SpriteBatch batch) {
        // Render HP bar.
        super.render(delta, batch);
    }
}
