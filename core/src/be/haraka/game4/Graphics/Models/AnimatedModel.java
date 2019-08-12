package be.haraka.game4.Graphics.Models;

import be.haraka.game4.Exceptions.WrongModelType;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


public class AnimatedModel extends Model {

    private TextureAtlas atlas;
    private Animation<TextureAtlas.AtlasRegion> animation;
    private boolean repeat = true;

    public AnimatedModel(String name, String path, int renderPriority, float duration, boolean repeat) {
        super(name, renderPriority);
        this.repeat = repeat;
        atlas = new TextureAtlas(path);

        // Number of frames of the animation, used for the animation lenght
        int frames = atlas.getRegions().size;

        animation = new Animation<>(duration/(float)frames, atlas.getRegions());
    }

    @Override
    public Texture getTexture() {
        throw new WrongModelType("This is an animated model. Only Animated instances" +
                "can acces it.");
    }

    public TextureAtlas.AtlasRegion getFrame(float elapsedTime, char direction) {
        return animation.getKeyFrame(elapsedTime,repeat);
    }
}
