package be.haraka.game4.Graphics;

import com.badlogic.gdx.graphics.Texture;

/**
 * Class containing render behaviour of an appropriate
 * {@link be.haraka.game4.Model.GameObject} trough the
 * {@link ObjectInstance} class.
 *
 * Each {@link be.haraka.game4.Model.GameObject } will be
 * linked to the right Model trough the ModelList hashmap
 * and the GameObject string name.
 *
 * @author GriffinBabe
 */
public class Model {

    // Model name used for linking.
    public String name;

    private Texture texture;
    private int renderPriority ;

    public Model(String name, String textureFile, int renderPriority) {
        this.name = name;
        this.renderPriority = renderPriority;
        texture = new Texture(textureFile);
    }
}
