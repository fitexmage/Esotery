/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.controller;

import esotery.model.Map;
import esotery.model.Data;
import esotery.model.Player;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 *
 * @author fitexmage
 */
public class DialogCntl {

    private Stage theStage;
    private static DialogCntl theDialogCntl;
    private int dialogID;
    private String tempSpeaker; //自定义说话者
    private String tempText; //自定义内容

    public DialogCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene(int dialogID) {
        this.dialogID = dialogID;
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/DialogUI.fxml"));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(Text name, Text description, TitledPane speaker, Text dialog) {
        Map theMap = Data.getTheData().getTheMapListClass().getTheMap(Player.getThePlayer().getTheAttribute().getLocation()); //获取当前地图
        name.setText(theMap.getName()); //显示地图名字
        description.setText(theMap.getDescription()); //显示地图描述
        showDialog(speaker, dialog); //显示对话
    }

    //显示对话
    public void showDialog(TitledPane speaker, Text dialog) {
        if (dialogID != 0) { //数据库中拥有的对话
            if (Data.getTheData().getTheDialogListClass().getTheDialog(dialogID).getSpeaker().equals("player")) { //玩家自己说的
                speaker.setText(Player.getThePlayer().getTheAttribute().getName());
            } else { //其他人说的
                speaker.setText(Data.getTheData().getTheDialogListClass().getTheDialog(dialogID).getSpeaker());
            }
            dialog.setText(Data.getTheData().getTheDialogListClass().getTheDialog(dialogID).getContent());
        } else { //自定义对话
            speaker.setText(tempSpeaker);
            dialog.setText(tempText);
            tempSpeaker = "";
            tempText = "";
        }
    }

    //进入下一个事件步骤
    public void next() {
        EventCntl.getTheEventCntl(theStage).startEvent(0);
    }

    /**
     * @return the theDialogCntl
     */
    public static DialogCntl getTheDialogCntl() {
        return theDialogCntl;
    }

    public static DialogCntl getTheDialogCntl(Stage theStage) {
        theDialogCntl = new DialogCntl(theStage);
        return theDialogCntl;
    }

    /**
     * @return the tempSpeaker
     */
    public String getTempSpeaker() {
        return tempSpeaker;
    }

    /**
     * @param tempSpeaker the tempSpeaker to set
     */
    public void setTempSpeaker(String tempSpeaker) {
        this.tempSpeaker = tempSpeaker;
    }

    /**
     * @return the tempText
     */
    public String getTempText() {
        return tempText;
    }

    /**
     * @param tempText the tempText to set
     */
    public void setTempText(String tempText) {
        this.tempText = tempText;
    }
}
