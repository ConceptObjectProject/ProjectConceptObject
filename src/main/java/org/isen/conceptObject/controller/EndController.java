package org.isen.conceptObject.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.isen.conceptObject.App;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.*;
import org.isen.conceptObject.models.master.MasterElve;
import org.isen.conceptObject.models.master.MasterGoblins;
import org.isen.conceptObject.models.master.MasterHuman;
import org.isen.conceptObject.models.master.MasterOrc;

public class EndController implements Initializable {


    @FXML
    private Text numberMsgElve;

    @FXML
    private JFXButton menuButton;

    @FXML
    private Text numberMsgGoblins;

    @FXML
    private Text numberMsgHuman;

    @FXML
    private Text numberMsgOrc;

    @FXML
    void menu() {
        Stage stage = (Stage) menuButton.getScene().getWindow();
        stage.close();
        App.showView("launcher");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        printTxtMsg();
    }

    public void printTxtMsg(){
        MasterGoblins masterGoblins = MasterGoblins.getInstance();
        MasterElve masterElve = MasterElve.getInstance();
        MasterOrc masterOrc = MasterOrc.getInstance();
        MasterHuman masterHuman = MasterHuman.getInstance();

        numberMsgOrc.setText(String.valueOf(masterOrc.getAllMessages().size()));
        numberMsgHuman.setText(String.valueOf(masterHuman.getAllMessages().size()));
        numberMsgElve.setText(String.valueOf(masterElve.getAllMessages().size()));
        numberMsgGoblins.setText(String.valueOf(masterGoblins.getAllMessages().size()));
    }
}
