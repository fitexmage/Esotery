/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.text.*;

/**
 *
 * @author fitexmage
 */
public class MapUICntl implements Initializable {

    @FXML
    private Text name;
    @FXML
    private Text description;
    @FXML
    private Button forward;
    @FXML
    private Button back;
    @FXML
    private Button left;
    @FXML
    private Button right;
    @FXML
    private Text npc1;
    @FXML
    private Text npc2;
    @FXML
    private Text npc3;
    @FXML
    private Button npc1Interaction;
    @FXML
    private Button npc2Interaction;
    @FXML
    private Button npc3Interaction;
    @FXML
    private Text monster1;
    @FXML
    private Text monster2;
    @FXML
    private Text monster3;
    @FXML
    private Button monster1Interaction;
    @FXML
    private Button monster2Interaction;
    @FXML
    private Button monster3Interaction;
    @FXML
    private Text noNpc;
    @FXML
    private Text noMonster;
    @FXML
    private Text creatureInfo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MapCntl.getTheMapCntl().initialize(name, description, forward, back, left, right, npc1, npc2, npc3, npc1Interaction, npc2Interaction, npc3Interaction, monster1, monster2, monster3, monster1Interaction, monster2Interaction, monster3Interaction, noNpc, noMonster, creatureInfo);
    }

    @FXML
    private void menu(ActionEvent event) {
    }

    @FXML
    private void forward(ActionEvent event) {
        MapCntl.getTheMapCntl().forward();
    }

    @FXML
    private void back(ActionEvent event) {
        MapCntl.getTheMapCntl().back();
    }

    @FXML
    private void left(ActionEvent event) {
        MapCntl.getTheMapCntl().left();
    }

    @FXML
    private void right(ActionEvent event) {
        MapCntl.getTheMapCntl().right();
    }

    @FXML
    private void hideInfo(MouseEvent event) {
        MapCntl.getTheMapCntl().hideInfo(creatureInfo);
    }
}
