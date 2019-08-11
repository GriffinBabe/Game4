package be.haraka.game4.Model.Map;

import be.haraka.game4.Exceptions.MapFormatException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Class with static members that loads a json map file and sets
 * the world's size values and tiles.
 *
 * @author GriffinBabe
 */
public class MapLoader {

    // Constant keyword names expected in Json document.
    private static String WIDTH = "width";
    private static String HEIGHT = "height";
    private static String LAYER = "layers";
    private static String TILEDATA = "data";

    /**
     * Starts the JSON parser and sets the World's size.
     * Continues by setting each layer on the {@link #LoadLayer(String, World)}
     * method.
     *
     * @param jsonPath, path to the Json path containing
     *                  the map info.
     * @param world, reference to the world we want to set.
     */
    public static void LoadMap(String jsonPath, World world) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(jsonPath)) {

            JSONObject document = (JSONObject) parser.parse(reader);
            int width = (int) (long) document.get(WIDTH);
            int height = (int) (long) document.get(HEIGHT);

            world.setDimensions(width, height);

            JSONArray array = (JSONArray) document.get(LAYER);
            for (Object layer : array) {
                LoadLayer((JSONObject) layer, world, width, height);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Follows {@link #LoadMap(String, World)}. Will read trough each map layers
     * and sets the tiles in the world's map ({@link World#map}).
     *
     * Throws an unchecked exception if the dimensions of the layers in the JSON
     * document doesn't match the dimensions given by the the same document.
     *
     * @param layer, a {@link JSONArray} object containing all the tile IDs.
     * @param world, reference to the {@link World}.
     * @param width, width of the world.
     * @param height, height of the world.
     */
    private static void LoadLayer(JSONObject layer, World world, int width, int height) {
        // Checks if the data array is correctly sized.
        JSONArray tileData = (JSONArray) layer.get(TILEDATA);
        if (tileData.size() != width * height) {
            throw new MapFormatException("Map layer has the wrong size. (Expected: " + width * height +
                    "but has: " + tileData.size());
        }

        int index;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                index = y * width + x;
                TileType type = TileType.getById((int) (long) tileData.get(index));
                world.setTile(x, y, new Tile(x, y, type));
            }
        }
    }
}
