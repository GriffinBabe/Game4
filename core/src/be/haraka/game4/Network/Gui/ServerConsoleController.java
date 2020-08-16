package be.haraka.game4.Network.Gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ServerConsoleController implements Initializable, Observer {

    @FXML
    private TextArea consoleArea;

    @FXML
    private TextField entryBar;

    @FXML
    private ListView userMenu;

    @FXML
    private MenuItem quitButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
