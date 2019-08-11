package be.haraka.game4.Graphics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * This class contains a hashmap loaded from a JSON File.
 *
 * The hashmap consists of {@link Model} with String as a key and
 * is needed to link the right model to the right {@link be.haraka.game4.Model.GameObject}
 * from the GameObject's {@link be.haraka.game4.Model.GameObject#objectName}.
 *
 * @author GriffinBabe
 */
public class ModelList {

    // JSON parsing key names, constants
    private static String TILE_LIST = "tiles";
    private static String TILE_NAME = "name";
    private static String TILE_PRIORITY = "priority";
    private static String TILE_PATH = "path";


    // The hashmap containing models corresponding to gameobject names.
    private HashMap<String, Model> modelList;

    public ModelList(String jsonFile) {
        init(jsonFile);
    }

    /**
     * Starts the json parsing. Initializing the HashMap.
     * And proceed by calling {@link #parseTiles(JSONObject)}}.
     * @param jsonPath, the path to the model linking json
     *                  file.
     */
    private void init(String jsonPath) {
        modelList = new HashMap<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(jsonPath)) {
            JSONObject document = (JSONObject) parser.parse(reader);
            parseTiles(document);
            // TODO: Load animations, items, etc...
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts parsing the json file element by element.
     * Elements can be: - Tiles
     *                  - Mobs (with they're animations)
     *                  - Other elements
     * @param document
     */
    private void parseTiles(JSONObject document) {
        JSONArray tiles = (JSONArray) document.get(TILE_LIST);
        for (int i = 0; i < tiles.size(); i++) {
            // For each tile in the json document, loads the values
            JSONObject tile = (JSONObject)tiles.get(i);
            String name = (String) tile.get(TILE_NAME);
            int priority = (int)(long) tile.get(TILE_PRIORITY);
            String path = (String) tile.get(TILE_PATH);

            // Loads the model and sets it to the hashmap with the loaded values
            Model model = new Model(name, path, priority);
            modelList.put(name, model);
        }
    }

    /**
     * Gets the right model from the {@link be.haraka.game4.Model.GameObject#objectName}.
     * @param name, {@link be.haraka.game4.Model.GameObject#objectName}
     * @return model, the right model.
     */
    public Model getModel(String name) {
        return modelList.get(name);
    }

}
