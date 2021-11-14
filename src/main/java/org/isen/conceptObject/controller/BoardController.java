package org.isen.conceptObject.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.isen.conceptObject.App;
import org.isen.conceptObject.controller.models.ModelBoardController;
import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.Alive;
import org.isen.conceptObject.models.Element;
import org.isen.conceptObject.models.Obstacle;
import org.isen.conceptObject.models.entities.Elve;
import org.isen.conceptObject.models.entities.Goblins;
import org.isen.conceptObject.models.entities.Human;
import org.isen.conceptObject.models.entities.Orc;
import org.isen.conceptObject.models.master.MasterElve;
import org.isen.conceptObject.models.master.MasterGoblins;
import org.isen.conceptObject.models.master.MasterHuman;
import org.isen.conceptObject.models.master.MasterOrc;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private Text numberMsgOrc;

    @FXML
    private Text numberMsgHuman;

    @FXML
    private Text numberMsgGoblins;

    @FXML
    private Text numberMsgElve;

    @FXML
    private Text numberTurnKeeping;

    @FXML
    private AnchorPane anchorPaneBoard;


    ModelBoardController model;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model = new ModelBoardController();
        initializeBackground();
        createBoard();
    }

    public void cleanAliveElem() {
        for (Alive pawn : model.getAllPawn()) {
            var pane = (Pane) getNodeByRowColumnIndex(pawn.getPosX(), pawn.getPosY());
            pane.getChildren().clear();
        }
    }

    public ImageView getImageViewMaster(Image image) {
        var imageView = new ImageView(image);
        imageView.setFitHeight(Constant.MAP_SIZE_CELL - 5d);
        imageView.setFitWidth(Constant.MAP_SIZE_CELL - 5d);
        return imageView;
    }


    public void createBoard() {
        this.drawTextInfo();
        for (var i = 0; i < Constant.MAP_SIZE_X; i++) {
            var column = new ColumnConstraints(Constant.MAP_SIZE_CELL);
            grid.getColumnConstraints().add(column);
        }
        for (var i = 0; i < Constant.MAP_SIZE_Y; i++) {
            var row = new RowConstraints(Constant.MAP_SIZE_CELL);
            grid.getRowConstraints().add(row);
        }
        grid.getStyleClass().add("grid");        for (var i = 0; i < Constant.MAP_SIZE_X; i++) {
            for (var j = 0; j < Constant.MAP_SIZE_Y; j++) {
                var pane = new StackPane();

                if (i < Constant.SAFE_ZONE_SIZE && j < Constant.SAFE_ZONE_SIZE) {
                    pane.getStyleClass().add("human-zone");
                } else if (i < Constant.SAFE_ZONE_SIZE && j > Constant.MAP_SIZE_Y - Constant.SAFE_ZONE_SIZE - 1) {
                    pane.getStyleClass().add("goblin-zone");
                } else if (i > Constant.MAP_SIZE_X - Constant.SAFE_ZONE_SIZE - 1 && j > Constant.MAP_SIZE_Y - Constant.SAFE_ZONE_SIZE - 1) {
                    pane.getStyleClass().add("elve-zone");
                } else if (i > Constant.MAP_SIZE_X - Constant.SAFE_ZONE_SIZE - 1 && j < Constant.SAFE_ZONE_SIZE) {
                    pane.getStyleClass().add("orc-zone");
                } else {
                    pane.getStyleClass().add("empty-grid-cell");
                }
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }

                grid.add(pane, i, j);
            }
        }

        for (Element alive : model.getAllElements()) {
            var pane = (Pane) getNodeByRowColumnIndex(alive.getPosX(), alive.getPosY());
            if (Alive.class.isAssignableFrom(alive.getClass())) {
                if (alive.getClass().equals(MasterElve.class)) {
                    var image = new Image(Objects.requireNonNull(App.class.getResource("img/elve-master.png")).toString());
                    pane.getChildren().add(getImageViewMaster(image));
                } else if (alive.getClass().equals(MasterGoblins.class)) {
                    var image = new Image(Objects.requireNonNull(App.class.getResource("img/goblin-master.png")).toString());
                    pane.getChildren().add(getImageViewMaster(image));
                } else if (alive.getClass().equals(MasterHuman.class)) {
                    var image = new Image(Objects.requireNonNull(App.class.getResource("img/human-master.png")).toString());
                    pane.getChildren().add(getImageViewMaster(image));
                } else if (alive.getClass().equals(MasterOrc.class)) {
                    var image = new Image(Objects.requireNonNull(App.class.getResource("img/orc-master.png")).toString());
                    pane.getChildren().add(getImageViewMaster(image));
                }

            } else if (alive.getClass().equals(Obstacle.class)) {
                var image = new Image(Objects.requireNonNull(App.class.getResource("img/rock.png")).toString());
                pane.getChildren().add(getImageViewMaster(image));
            }
        }
        drawElement();

    }


    public Node getNodeByRowColumnIndex(final int row, final int column) {
        Node result = null;
        ObservableList<Node> childrens = grid.getChildren();

        for (Node node : childrens) {
            if (GridPane.getColumnIndex(node) == row && GridPane.getRowIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }


    public void drawElement() {

        var orcImage = new Image(Objects.requireNonNull(App.class.getResource("img/orc.png")).toString());
        var elveImage = new Image(Objects.requireNonNull(App.class.getResource("img/elve.png")).toString());
        var humanImage =new Image(Objects.requireNonNull(App.class.getResource("img/human.png")).toString());
        var goblinImage = new Image(Objects.requireNonNull(App.class.getResource("img/goblin.png")).toString());

        for (Alive aliveElem : model.getAllPawn()) {
            var pane = (StackPane) getNodeByRowColumnIndex(aliveElem.getPosX(), aliveElem.getPosY());

            if (aliveElem.getNumbersLives() > 0) {
                Text nbMsg = new Text("(" + aliveElem.getAllMessages().size() + ") ");
                StackPane.setAlignment(nbMsg, Pos.TOP_RIGHT);
                pane.getChildren().add(nbMsg);
                if (aliveElem.getClass().equals(Orc.class)) {
                    pane.getChildren().add(getImageViewMaster(orcImage));
                } else if (aliveElem.getClass().equals(Elve.class)) {
                    pane.getChildren().add(getImageViewMaster(elveImage));
                } else if (aliveElem.getClass().equals(Goblins.class)) {
                    pane.getChildren().add(getImageViewMaster(goblinImage));
                } else if (aliveElem.getClass().equals(Human.class)) {

                    pane.getChildren().add(getImageViewMaster(humanImage));
                }
            } else {
                var image = new Image(Objects.requireNonNull(App.class.getResource("img/grave.png")).toString());
                pane.getChildren().add(getImageViewMaster(image));

            }
        }
    }

    public void drawTextInfo() {
        MasterGoblins masterGoblins = MasterGoblins.getInstance();
        MasterElve masterElve = MasterElve.getInstance();
        MasterOrc masterOrc = MasterOrc.getInstance();
        MasterHuman masterHuman = MasterHuman.getInstance();

        numberMsgOrc.setText(String.valueOf(masterOrc.getAllMessages().size()));
        numberMsgHuman.setText(String.valueOf(masterHuman.getAllMessages().size()));
        numberMsgElve.setText(String.valueOf(masterElve.getAllMessages().size()));
        numberMsgGoblins.setText(String.valueOf(masterGoblins.getAllMessages().size()));

        numberTurnKeeping.setText(String.valueOf(model.getNumberTurn()));
    }

    public void moveAll(ActionEvent actionEvent) throws IOException {
        if (model.getGameFinished()) {
            gameFinished();
        } else {
            this.cleanAliveElem();
            model.moveAllElements();
            this.drawElement();
            drawTextInfo();
        }
    }

    public void moveAllGame(ActionEvent actionEvent) throws IOException {
        this.cleanAliveElem();
        while (!model.getGameFinished()) {
            model.moveAllElements();
        }
        model.setGameFinished(true);
        this.drawElement();
        drawTextInfo();
        gameFinished();
    }

    public void restart() {


        grid.getChildren().clear();
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.setPrefHeight(400.0);
        grid.setPrefWidth(600.0);

        MasterGoblins masterGoblins = MasterGoblins.getInstance();
        MasterElve masterElve = MasterElve.getInstance();
        MasterOrc masterOrc = MasterOrc.getInstance();
        MasterHuman masterHuman = MasterHuman.getInstance();

        masterGoblins.getAllMessages().clear();
        masterElve.getAllMessages().clear();
        masterOrc.getAllMessages().clear();
        masterHuman.getAllMessages().clear();

        model = new ModelBoardController();



        createBoard();
        drawTextInfo();
    }

    public void moveOne(ActionEvent actionEvent) throws IOException {
        if (model.getGameFinished()) {
            gameFinished();
        } else {
            this.cleanAliveElem();
            model.moveOne();
            this.drawElement();
            drawTextInfo();
        }
    }

    private void initializeBackground(){
        var image = new Image(Objects.requireNonNull(App.class.getResource("img/board-background.jpg")).toString(), true);
        var bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.0, true, true, false, false)
        );
        anchorPaneBoard.setBackground(new Background(bgImage));
    }

    public void gameFinished() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("fxml/end.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResource("img/sauron-eye.png").toString()));
        stage.setTitle("Partie terminée");
        stage.setScene(scene);

        stage.initModality(Modality.APPLICATION_MODAL);//Permet de bloquer la page parents lors de l'ouverture de la fenêtre param
        stage.showAndWait();
    }
}
