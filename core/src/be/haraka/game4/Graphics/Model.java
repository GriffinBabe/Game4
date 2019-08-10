package be.haraka.game4.Graphics;

import com.badlogic.gdx.graphics.Texture;

public class Model {

    public String name;

    private Texture texture;

    public Model(String name, String textureFile) {
        this.name = name;
        texture = new Texture(textureFile);
    }
}
