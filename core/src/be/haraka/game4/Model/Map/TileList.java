package be.haraka.game4.Model.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TileList {

    private static HashMap<String,Tile> tileList = null;
    private static TileList instance = null;

    private static String TILE_PATH = "assets/tiles.json";
    private static String TILE_IDS = "id";
    private static String TILE_LIST = "tiles";
    private static String TILE_NAME = "tile";
    private static String TILE_MOVEMENT = "movement";
    private static String TILE_WALKABLE = "walkable";

    private TileList() {
        init();
    }

    public static TileList getInstance() {
        if (instance == null) {
            instance = new TileList();
        }
        return instance;
    }

    private static void init() {
        tileList = new HashMap<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(TILE_PATH)) {
            JSONObject document = (JSONObject) parser.parse(reader);
            parseTiles(document);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseTiles(JSONObject document) {
        JSONArray tiles = (JSONArray) document.get(TILE_LIST);
        for (int i = 0; i < tiles.size(); i++) {
            JSONObject tile = (JSONObject) tiles.get(i);
            JSONArray ids = (JSONArray) tile.get(TILE_IDS);
            float movement = (float)(double)tile.get(TILE_MOVEMENT);
            boolean walkable = (boolean) tile.get(TILE_WALKABLE);
            for (int j = 0; j < ids.size(); j++) {
                int id = (int)(long) ids.get(j);
                Tile objectTile = new Tile(0,0, id, walkable, movement);
                tileList.put(TILE_NAME+"-"+id, objectTile);
            }

        }
    }

    public Tile getTile(int id) {
        Tile prototype = tileList.get(TILE_NAME+"-"+id);
        if (prototype == null) {
            System.out.println();
        }
        return (Tile)prototype.clone();
    }

}
