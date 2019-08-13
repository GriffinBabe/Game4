package be.haraka.game4.Model.Mob;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * MobList, just like {@link be.haraka.game4.Graphics.Models.ModelList},
 * contains an HashedMap linking mobs to a name. The mob list is also
 * implements the prototype algorithm.
 *
 * @author GriffinBabe
 */
public class MobList {

    private HashMap<String, Mob> mobList;

    private static String MOB_LIST = "mobs";
    private static String MOBS_NAME = "name";
    private static String MOBS_ONAME = "objectName";
    private static String MOBS_HEALTH = "health";
    private static String MOBS_MANA = "mana";
    private static String MOBS_SPEED = "speed";
    private static String MOBS_ARMOR = "armor";


    private static String MOBS_PATH = "assets/mobs.json";

    public MobList() {
        init();

    }

    /**
     * Starts the json parsing. Initializing the HashMap.
     * And proceed by calling {@link #parseMobs(JSONObject)}}.
     */
    private void init() {
        mobList = new HashMap<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(MOBS_PATH)) {
            JSONObject document = (JSONObject) parser.parse(reader);
            parseMobs(document);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * Starts parsing the json file element by element.
     * Elements are mobs
     * @param document, the parsed json document.
     */
    private void parseMobs(JSONObject document) {
        JSONArray mobs = (JSONArray) document.get(MOB_LIST);
        for (int i = 0; i < mobs.size(); i++) {
            JSONObject mobJSON = (JSONObject)mobs.get(i);
            String name = (String) mobJSON.get(MOBS_NAME);
            String objectName = (String) mobJSON.get(MOBS_ONAME);
            int maxHealth = (int)(float)mobJSON.get(MOBS_HEALTH);
            int maxMana = (int) (float) mobJSON.get(MOBS_MANA);
            float speed = (float) mobJSON.get(MOBS_SPEED);
            int armor = (int)(float)mobJSON.get(MOBS_ARMOR);
            Mob mob = new Mob(0,0, objectName);
            mob.setStats(maxHealth, maxMana, armor, speed);
            mobList.put(name, mob);
        }
    }


    /**
     * Get's the right mob from the right mobname.
     * @param name, the mob name, key in our {@link #mobList}.
     * @return the corresponding mob.
     */
    public Mob getMob(String name) {
        return mobList.get(name);
    }


}
