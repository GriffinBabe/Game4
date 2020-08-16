package be.haraka.game4.Network.Gui;

import be.haraka.game4.Game;
import be.haraka.game4.Network.ServerApp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * JavaFX window for logging console.
 */
public class ServerConsole extends Application {

    private Stage primaryStage;

    private Pane primaryStageLayout;

    private ServerConsoleController controller;

    private Game game;
    private ServerApp serverApp;

    @Override
    public void start(Stage stage) throws Exception {
        initServerElements();

        this.primaryStage = stage;
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("/menu/console_window.fxml"));
        primaryStageLayout = loader.load();
        controller = loader.getController();

        Scene scene = new Scene(primaryStageLayout);
        primaryStage.setScene(scene);

        primaryStage.sizeToScene();
        primaryStage.show();

        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }

    private void initServerElements() {
        this.game = new Game();
        Game.SERVER_MODE = true; // sets the game to server mode.
        this.serverApp = new ServerApp(game);
        this.serverApp.start();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
