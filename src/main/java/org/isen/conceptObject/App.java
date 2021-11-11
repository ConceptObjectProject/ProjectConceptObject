package org.isen.conceptObject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private static AnchorPane main;

    @Override
    public void start(Stage stage) throws IOException {

        stage.setTitle("Battle in middle earth");
        main = (AnchorPane) loadFXML("main");

        main.getChildren().add(loadFXML("launcher"));

        scene = new Scene(main);
        stage.setScene(scene);
        scene.getStylesheets().add(String.valueOf(App.class.getResource("css/main.css")));
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNIFIED);
        stage.getIcons().add(new Image(App.class.getResource("img/sauron-eye.png").toString()));
        stage.show();
    }



    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/"+fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Show view.
     *
     * @param rootElement the root element
     */
    public static void showView(String rootElement) {
        try {

            main.getChildren().clear();
            main.getChildren().add(loadFXML(rootElement));

        } catch (IOException e) {

            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}

