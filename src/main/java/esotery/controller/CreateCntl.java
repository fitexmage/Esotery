/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.controller;

import esotery.model.Attribute;
import esotery.model.ConditionList;
import esotery.model.Data;
import esotery.model.Player;
import java.util.ArrayList;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 *
 * @author fitexmage
 */
public class CreateCntl {

    private Stage theStage;
    private static CreateCntl theCreateCntl;
    private int playerID;

    public CreateCntl(Stage theExistingStage, int playerID) {
        theStage = theExistingStage;
        this.playerID = playerID;
    }

    public void setUpScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/CreateUI.fxml"));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //选择性别
    public void selectGender(ActionEvent event, CheckBox male, CheckBox female) {
        CheckBox theCheckBox = (CheckBox) event.getSource();
        //确保至少有一个被选
        if (!theCheckBox.isSelected()) {
            theCheckBox.setSelected(true);
        }
        if (theCheckBox.getId().equals("male")) {
            female.setSelected(false);
        } else if (theCheckBox.getId().equals("female")) {
            male.setSelected(false);
        }
    }
    
    //选择职业
    public void selectRole(ActionEvent event, CheckBox warrior, CheckBox assassin, CheckBox mage) {
        CheckBox theCheckBox = (CheckBox) event.getSource();
        //确保至少有一个被选
        if (!theCheckBox.isSelected()) {
            theCheckBox.setSelected(true);
        }
        if (theCheckBox.getId().equals("warrior")) {
            assassin.setSelected(false);
            mage.setSelected(false);
        } else if (theCheckBox.getId().equals("assassin")) {
            warrior.setSelected(false);
            mage.setSelected(false);
        } else if (theCheckBox.getId().equals("mage")) {
            warrior.setSelected(false);
            assassin.setSelected(false);
        }
    }

    //创建角色并进入导航页
    public void getNavCntl(TextField name, CheckBox male, CheckBox female, CheckBox warrior, CheckBox assassin, CheckBox mage, Text nameAlert) {
        if (name.getText().isEmpty()) { //未输入角色名
            nameAlert.setText("请输入角色名!");
        } else {
            if (Player.getThePlayer() == null) { //以前没创建过角色
                //添加新的信息
                Data.getTheData().getTheAttributeListClass().addNewAttribute(playerID, name, male, female, warrior, assassin, mage);
                Data.getTheData().getTheSkillListClass().addNewSkillPackage(playerID);
                Data.getTheData().getTheConditionListClass().addNewConditionPackage(playerID);

                Player.setThePlayer(new Player(playerID)); //初始化个人信息
            } else { //以前创建过角色
                //替换为新的信息
                int playerID = Player.getThePlayer().getTheAccount().getPlayerID();
                Data.getTheData().getTheAttributeListClass().updateTheAttribute(Attribute.newAttribute(playerID, name, male, female, warrior, assassin, mage));
                Data.getTheData().getTheSkillListClass().updateTheSkillPackage(playerID, new ArrayList<>());
                Data.getTheData().getTheConditionListClass().updateTheConditionPackage(playerID, ConditionList.newConditionPackage());
                
                Player.setThePlayer(new Player(playerID)); //初始化个人信息
            }
            //开始游戏
            EventCntl.getTheEventCntl(theStage).startEvent(20001);
        }
    }

    /**
     * @return the theCreateCntl
     */
    public static CreateCntl getTheCreateCntl() {
        return theCreateCntl;
    }

    public static CreateCntl getTheCreateCntl(Stage theStage, int playerID) {
        theCreateCntl = new CreateCntl(theStage, playerID);
        return theCreateCntl;
    }
}
