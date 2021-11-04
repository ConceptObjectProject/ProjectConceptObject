package org.isen.conceptObject;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import org.isen.conceptObject.misc.Constant;
import org.isen.conceptObject.models.*;
import org.isen.conceptObject.models.container.Pair;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class BoardController implements Initializable {

    @FXML
    private GridPane grid;


    ModelBoardController model;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        model = new ModelBoardController();
        createBoard();
    }


    public ImageView getImageViewMaster(Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(Constant.MAP_SIZE_CELL - 5);
        imageView.setFitWidth(Constant.MAP_SIZE_CELL - 5);
        return imageView;
    }


    public void createBoard() {


        for (int i = 0; i < Constant.MAP_SIZE_X; i++) {
            ColumnConstraints column = new ColumnConstraints(Constant.MAP_SIZE_CELL);
            grid.getColumnConstraints().add(column);
        }
        for (int i = 0; i < Constant.MAP_SIZE_Y; i++) {
            RowConstraints row = new RowConstraints(Constant.MAP_SIZE_CELL);
            grid.getRowConstraints().add(row);
        }
        grid.getStyleClass().add("grid");
        for (int i = 0; i < Constant.MAP_SIZE_X; i++) {
            for (int j = 0; j < Constant.MAP_SIZE_Y; j++) {
                StackPane pane = new StackPane();
                pane.setAlignment(Pos.BASELINE_CENTER);
                if (i < Constant.SAFE_ZONE_SIZE && j < Constant.SAFE_ZONE_SIZE) {
                    if (i == Constant.MASTER_HUMAN_POS_X && j == Constant.MASTER_HUMAN_POS_Y) {
                        Image image = new Image(Objects.requireNonNull(App.class.getResource("img/human-master.png")).toString());
                        pane.getChildren().add(getImageViewMaster(image));
                    }
                    pane.getStyleClass().add("human-zone");
                } else if (i < Constant.SAFE_ZONE_SIZE && j > Constant.MAP_SIZE_Y - Constant.SAFE_ZONE_SIZE - 1) {
                    if (i == Constant.MASTER_GOBLINS_POS_X && j == Constant.MASTER_GOBLINS_POS_Y) {
                        Image image = new Image(Objects.requireNonNull(App.class.getResource("img/goblin-master.png")).toString());
                        pane.getChildren().add(getImageViewMaster(image));
                    }
                    pane.getStyleClass().add("goblin-zone");
                } else if (i > Constant.MAP_SIZE_X - Constant.SAFE_ZONE_SIZE - 1 && j > Constant.MAP_SIZE_Y - Constant.SAFE_ZONE_SIZE - 1) {
                    if (i == Constant.MASTER_ELVE_POS_X && j == Constant.MASTER_ELVE_POS_Y) {
                        Image image = new Image(Objects.requireNonNull(App.class.getResource("img/elve-master.png")).toString());
                        pane.getChildren().add(getImageViewMaster(image));
                    }
                    pane.getStyleClass().add("elve-zone");
                } else if (i > Constant.MAP_SIZE_X - Constant.SAFE_ZONE_SIZE - 1 && j < Constant.SAFE_ZONE_SIZE) {
                    if (i == Constant.MASTER_ORC_POS_X && j == Constant.MASTER_ORC_POS_Y) {
                        Image image = new Image(Objects.requireNonNull(App.class.getResource("img/orc-master.png")).toString());
                        pane.getChildren().add(getImageViewMaster(image));
                    }
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

        model.setAllPawn();
        for (Alive alive : model.getAllAlivesElement()) {
            Pane pane = (Pane) getNodeByRowColumnIndex(alive.getPosX(), alive.getPosY());

            if (alive.getClass().equals(Orc.class)) {
                Image image = new Image(Objects.requireNonNull(App.class.getResource("img/orc-pawn.png")).toString());
                pane.getChildren().add(getImageViewMaster(image));
            } else if (alive.getClass().equals(Elve.class)) {
                Image image = new Image(Objects.requireNonNull(App.class.getResource("img/elve-pawn.png")).toString());
                pane.getChildren().add(getImageViewMaster(image));
            }
            else if (alive.getClass().equals(Goblins.class)) {
                Image image = new Image(Objects.requireNonNull(App.class.getResource("img/goblin-pawn.png")).toString());
                pane.getChildren().add(getImageViewMaster(image));
            } else if (alive.getClass().equals(Human.class)) {
                Image image = new Image(Objects.requireNonNull(App.class.getResource("img/human-pawn.png")).toString());
                pane.getChildren().add(getImageViewMaster(image));
            }

        }

    }

    public Node getNodeByRowColumnIndex(final int row, final int column) {
        Node result = null;
        ObservableList<Node> childrens = grid.getChildren();

        for (Node node : childrens) {
            if (grid.getColumnIndex(node) == row && grid.getRowIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }
}
