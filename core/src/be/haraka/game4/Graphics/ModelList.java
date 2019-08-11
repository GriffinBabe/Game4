package be.haraka.game4.Graphics;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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

    private DocumentBuilder builder;
    private HashMap<String, Model> modelList;

    public ModelList(String jsonFile) {
        init(jsonFile);
    }

    /**
     * Starts the json parsing. Initializing the HashMap.
     * And proceed by calling {@link #parseModels(String)}.
     * @param jsonFile, the path to the model linking json
     *                  file.
     */
    private void init(String jsonFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ignored) {
            ignored.printStackTrace();
            return;
        }

        modelList = new HashMap<>();
        parseModels(jsonFile);
    }

    /**
     * Starts parsing the json file element by element.
     * Elements can be: - Tiles
     *                  - Mobs (with they're animations)
     *                  - Other elements
     * @param jsonFile
     */
    private void parseModels(String jsonFile) {

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
