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
import javafx.scene.text.*;

/**
 *
 * @author fitexmage
 */
public class CreateUICntl implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private CheckBox male;
    @FXML
    private CheckBox female;
    @FXML
    private CheckBox warrior;
    @FXML
    private CheckBox assassin;
    @FXML
    private CheckBox mage;
    @FXML
    private Text nameAlert;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void selectGender(ActionEvent event) {
        CreateCntl.getTheCreateCntl().selectGender(event, male, female);
    }

    @FXML
    private void selectRole(ActionEvent event) {
        CreateCntl.getTheCreateCntl().selectRole(event, warrior, assassin, mage);
    }

    @FXML
    private void confirm(ActionEvent event) {
        CreateCntl.getTheCreateCntl().getNavCntl(name, male, female, warrior, assassin, mage, nameAlert);
    }
}
