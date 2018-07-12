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
public class CombatUICntl implements Initializable {
    
    @FXML
    private Text name;
    @FXML
    private Text description;
    @FXML
    private ProgressBar playerHpBar;
    @FXML
    private Text playerHpText;
    @FXML
    private ProgressBar playerMpBar;
    @FXML
    private Text playerMpText;
    @FXML
    private Text player;
    @FXML
    private ProgressBar enemyHpBar;
    @FXML
    private Text enemyHpText;
    @FXML
    private ProgressBar enemyMpBar;
    @FXML
    private Text enemyMpText;
    @FXML
    private Text enemy;
    @FXML
    private Text result;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CombatCntl.getTheCombatCntl().initialize(name, description, playerHpBar, playerMpBar, playerHpText, playerMpText, player, enemyHpBar, enemyMpBar, enemyHpText, enemyMpText, enemy);
    }
    
    @FXML
    private void attack(ActionEvent event) {
        CombatCntl.getTheCombatCntl().attack(result);
        CombatCntl.getTheCombatCntl().initialize(name, description, playerHpBar, playerMpBar, playerHpText, playerMpText, player, enemyHpBar, enemyMpBar, enemyHpText, enemyMpText, enemy);
    }
    
    @FXML
    private void run(ActionEvent event) {
        CombatCntl.getTheCombatCntl().run();
    }
}
