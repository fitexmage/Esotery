/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.text.*;

/**
 *
 * @author fitexmage
 */
public class NavUICntl implements Initializable {

    @FXML
    private Text name;
    @FXML
    private Text gender;
    @FXML
    private Text level;
    @FXML
    private Text role;
    @FXML
    private Text position;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NavCntl.getTheNavCntl().initialize(name, gender, level, role, position);
    }

    @FXML
    private void play(ActionEvent event) {
        NavCntl.getTheNavCntl().getMapCntl();
    }

    @FXML
    private void restart(ActionEvent event) {
        NavCntl.getTheNavCntl().getCreateCntl();
    }

}
