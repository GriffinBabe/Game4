package be.haraka.game4.Graphics;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.HashMap;

/**
 * This class contains a hashmap loaded from a JSON File.
 * The hashmap consits of Model with String as a string and
 * is used as a way to get the right model from the right
 * GameObject.
 *
 * @author GriffinBabe
 */
public class ModelList {

    private DocumentBuilder builder;
    private HashMap<String, Model> modelList;

    public ModelList(String jsonFile) {
        Init(jsonFile);
    }

    private void Init(String jsonFile) {
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

    private void parseModels(String jsonFile) {

    }

    public Model getModel(String name) {
        return modelList.get(name);
    }

}
