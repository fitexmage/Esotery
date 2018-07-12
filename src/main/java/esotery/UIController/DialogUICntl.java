/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.UIController;

import esotery.controller.DialogCntl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.text.*;

/**
 *
 * @author fitexmage
 */
public class DialogUICntl implements Initializable {

    @FXML
    private Text name;
    @FXML
    private Text description;
    @FXML
    private TitledPane speaker;
    @FXML
    private Text dialog;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DialogCntl.getTheDialogCntl().initialize(name, description, speaker, dialog);
    }

    @FXML
    private void menu(ActionEvent event) {

    }

    @FXML
    private void next(ActionEvent event) {
        DialogCntl.getTheDialogCntl().next();
    }
}
