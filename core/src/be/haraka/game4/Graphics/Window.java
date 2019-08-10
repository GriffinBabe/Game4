package be.haraka.game4.Graphics;

import be.haraka.game4.Model.GameObject;
import com.badlogic.gdx.Gdx;

import java.util.ArrayList;
import java.util.List;

public class Window {

    // Window size
    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    public static String modelsPath = "assets/models.json";

    // List containing all the objects to render
    public static List<ObjectInstance> renderInstances = new ArrayList<>();

    public static ModelList modelList = null;


    public static void Init() {
        Gdx.graphics.setWindowedMode(WIDTH, HEIGHT);
        Gdx.graphics.setResizable(false);

        modelList = new ModelList(modelsPath);
    }

    public static void render(float deltaTime) {
        for (ObjectInstance instance : renderInstances) {
            instance.render();
        }
    }

    public static void newObject(GameObject o) {
        // TODO: Create new object instance
    }
}
