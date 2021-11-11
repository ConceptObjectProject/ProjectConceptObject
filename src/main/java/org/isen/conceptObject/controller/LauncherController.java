package org.isen.conceptObject.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.isen.conceptObject.App;
import org.isen.conceptObject.controller.models.ModelBoardController;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LauncherController implements Initializable {

    @FXML
    private AnchorPane anchorPaneLauncher;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initializeBackground();

    }

    public void playButtonPressed(){
        try {
            App.showView("board");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initializeBackground(){
        var image = new Image(Objects.requireNonNull(App.class.getResource("img/main-background.jpg")).toString(), true);
        var bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        anchorPaneLauncher.setBackground(new Background(bgImage));
    }

}
