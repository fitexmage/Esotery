/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.controller;

import esotery.model.Data;
import esotery.model.Player;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 *
 * @author fitexmage
 */
public class NavCntl {

    private Stage theStage;
    private static NavCntl theNavCntl;

    public NavCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/NavUI.fxml"));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(Text name, Text gender, Text level, Text role, Text position) {
        //显示角色信息
        name.setText("角色名: " + Player.getThePlayer().getTheAttribute().getName());
        gender.setText("性别: " + Player.getThePlayer().getTheAttribute().getGender());
        level.setText("等级: " + Player.getThePlayer().getTheAttribute().getLevel());
        role.setText("职业: " + Player.getThePlayer().getTheAttribute().getRole());
        position.setText("位置: " + Data.getTheData().getTheMapListClass().getTheMap(Player.getThePlayer().getTheAttribute().getLocation()).getName());
    }

    //进入地图界面
    public void getMapCntl() {
        MapCntl.getTheMapCntl(theStage).setUpScene();
    }

    //进入创建角色界面
    public void getCreateCntl() {
        CreateCntl.getTheCreateCntl(theStage, Player.getThePlayer().getTheAccount().getPlayerID()).setUpScene();
    }

    /**
     * @return the theStage
     */
    public Stage getTheStage() {
        return theStage;
    }

    /**
     * @param theStage the theStage to set
     */
    public void setTheStage(Stage theStage) {
        this.theStage = theStage;
    }

    /**
     * @return the theNavCntl
     */
    public static NavCntl getTheNavCntl() {
        return theNavCntl;
    }

    public static NavCntl getTheNavCntl(Stage theStage) {
        theNavCntl = new NavCntl(theStage);
        return theNavCntl;
    }

    /**
     * @param aTheNavCntl the theNavCntl to set
     */
    public static void setTheNavCntl(NavCntl aTheNavCntl) {
        theNavCntl = aTheNavCntl;
    }
}
