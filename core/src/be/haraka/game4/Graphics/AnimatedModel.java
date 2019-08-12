package be.haraka.game4.Graphics;

import be.haraka.game4.Exceptions.WrongModelType;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class AnimatedModel extends Model {

    HashMap<String,Animation> animations;

    public AnimatedModel(String name, int renderpriority) {
        super(name, renderpriority);
    }

    @Override
    public Texture getTexture() {
        throw new WrongModelType("This is an animated model. Only Animated instances" +
                "can acces it.");
    }

    public Texture getTexture(char direction) {
        return null;
    }
}
