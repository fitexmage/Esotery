/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.controller;

import esotery.model.Map;
import esotery.model.Creature;
import esotery.model.Data;
import esotery.model.Player;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 *
 * @author fitexmage
 */
public class MapCntl {

    private Stage theStage;
    private static MapCntl theMapCntl;
    private Map theMap;

    public MapCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/MapUI.fxml"));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize(Text name, Text description, Button forward, Button back, Button left, Button right, Text npc1, Text npc2, Text npc3, Button npcInteraction1, Button npcInteraction2, Button npcInteraction3, Text monster1, Text monster2, Text monster3, Button monsterInteraction1, Button monsterInteraction2, Button monsterInteraction3, Text noNpc, Text noMonster, Text creatureInfo) {
        theMap = Data.getTheData().getTheMapListClass().getTheMap(Player.getThePlayer().getTheAttribute().getLocation()); //获取当前地图
        name.setText(theMap.getName()); //显示地图名字
        description.setText(theMap.getDescription()); //显示地图描述
        showDirection(forward, back, left, right); //显示可选方向
        showNPC(npc1, npc2, npc3, npcInteraction1, npcInteraction2, npcInteraction3, noNpc, creatureInfo); //显示NPC
        showMonster(monster1, monster2, monster3, monsterInteraction1, monsterInteraction2, monsterInteraction3, noMonster, creatureInfo); //显示怪物
    }

    //显示可选方向
    public void showDirection(Button forward, Button back, Button left, Button right) {
        //全部初始化
        forward.setVisible(false);
        back.setVisible(false);
        left.setVisible(false);
        right.setVisible(false);

        //根据实际情况显示
        if (theMap.getForwardEventID() != 0) {
            forward.setVisible(true);
        }
        if (theMap.getBackEventID() != 0) {
            back.setVisible(true);
        }
        if (theMap.getLeftEventID() != 0) {
            left.setVisible(true);
        }
        if (theMap.getRightEventID() != 0) {
            right.setVisible(true);
        }
    }

    //显示NPC
    public void showNPC(Text npc1, Text npc2, Text npc3, Button npcInteraction1, Button npcInteraction2, Button npcInteraction3, Text noNpc, Text creatureInfo) {
        boolean haveNpc = false;
        Text[] npcList = {npc1, npc2, npc3}; //NPC列表
        Button[] npcInteractionList = {npcInteraction1, npcInteraction2, npcInteraction3}; //NPC互动按钮列表

        //初始化所有NPC
        for (int i = 0; i < 3; i++) {
            npcList[i].setVisible(false);
            npcInteractionList[i].setVisible(false);
        }

        for (int i = 0; i < theMap.getNpc().size(); i++) {
            int theNpcID = theMap.getNpc().get(i); //获取NPC ID
            Text npc = npcList[i];
            Button npcInteraction = npcInteractionList[i];

            Creature theNpc = Data.getTheData().getTheCreatureListClass().getTheCreature(theNpcID); //获取当前NPC
            npc.setVisible(true); //显示NPC
            npc.setText("Lv. " + theNpc.getLevel() + "\n" + theNpc.getName()); //显示NPC信息
            npcInteraction.setVisible(true); //显示NPC互动按钮
            if (Player.getThePlayer().getTheAttribute().getRace() == theNpc.getRace() || theNpc.getRace() == 0) { //NPC种族与玩家一样或无种族
                npc.setFill(Color.GREEN); //颜色变为绿色
                npcInteraction.setText("对话"); //互动形式变为对话
                npcInteraction.setOnAction((ActionEvent event) -> {
                    talk(event); //对话
                });
            } else {
                npc.setFill(Color.RED); //颜色变为红色
                npcInteraction.setText("战斗"); //互动形式变为对战
                npcInteraction.setOnAction((ActionEvent event) -> {
                    combat(event); //对战
                });
            }

            //鼠标指向时显示详细信息
            npc.setOnMouseEntered((MouseEvent event) -> {
                Creature theCreature = getCreatureFromText(event);
                showInfo(theCreature, creatureInfo);
            });
            npcInteraction.setOnMouseEntered((MouseEvent event) -> {
                Creature theCreature = getCreatureFromButton(event);
                showInfo(theCreature, creatureInfo);
            });

            //鼠标离开时隐藏详细信息
            npc.setOnMouseExited((MouseEvent event) -> {
                hideInfo(creatureInfo);
            });
            npcInteraction.setOnMouseExited((MouseEvent event) -> {
                hideInfo(creatureInfo);
            });
            haveNpc = true;
        }

        if (haveNpc == false) { //没有NPC
            noNpc.setVisible(true);
        } else {
            noNpc.setVisible(false);
        }
    }

    public void showMonster(Text monster1, Text monster2, Text monster3, Button monsterInteraction1, Button monsterInteraction2, Button monsterInteraction3, Text noMonster, Text creatureInfo) {
        boolean haveMonster = false;
        Text[] monsterList = {monster1, monster2, monster3}; //怪物列表
        Button[] monsterInteractionList = {monsterInteraction1, monsterInteraction2, monsterInteraction3}; //怪物互动按钮列表

        //初始化所有怪物
        for (int i = 0; i < 3; i++) {
            monsterList[i].setVisible(false);
            monsterInteractionList[i].setVisible(false);
        }

        for (int i = 0; i < theMap.getMonster().size(); i++) {
            int monsterID = theMap.getMonster().get(i); //获取怪物ID
            Text monster = monsterList[i];
            Button monsterInteraction = monsterInteractionList[i];

            Creature theMonster = Data.getTheData().getTheCreatureListClass().getTheCreature(monsterID); //获取当前怪物
            monster.setVisible(true); //显示怪物
            monster.setText("Lv. " + theMonster.getLevel() + "\n" + theMonster.getName()); //显示怪物信息
            monsterInteraction.setVisible(true); //显示怪物互动按钮
            if (Player.getThePlayer().getTheAttribute().getRace() == theMonster.getRace() || theMonster.getRace() == 0) { //怪物种族与玩家一样或无种族
                monster.setFill(Color.GREEN); //颜色变为绿色
                monsterInteraction.setText("对话"); //互动形式变为对话
                monsterInteraction.setOnAction((ActionEvent event) -> {
                    talk(event); //对话
                });
            } else {
                monster.setFill(Color.RED); //颜色变为红色
                monsterInteraction.setText("战斗"); //互动形式变为对战
                monsterInteraction.setOnAction((ActionEvent event) -> {
                    combat(event); //对战
                });
            }
            
            //鼠标指向时显示详细信息
            monster.setOnMouseEntered((MouseEvent event) -> {
                Creature theCreature = getCreatureFromText(event);
                showInfo(theCreature, creatureInfo);
            });
            monsterInteraction.setOnMouseEntered((MouseEvent event) -> {
                Creature theCreature = getCreatureFromButton(event);
                showInfo(theCreature, creatureInfo);
            });

            //鼠标离开时隐藏详细信息
            monster.setOnMouseExited((MouseEvent event) -> {
                hideInfo(creatureInfo);
            });
            monsterInteraction.setOnMouseExited((MouseEvent event) -> {
                hideInfo(creatureInfo);
            });
            haveMonster = true;
        }

        if (haveMonster == false) { //没有NPC
            noMonster.setVisible(true);
        } else {
            noMonster.setVisible(false);
        }
    }

    //向前
    public void forward() {
        if (theMap.getForwardEventID() != 0) {
            EventCntl.getTheEventCntl(theStage).startEvent(theMap.getForwardEventID());
        }
    }

    //向后
    public void back() {
        if (theMap.getBackEventID() != 0) {
            EventCntl.getTheEventCntl(theStage).startEvent(theMap.getBackEventID());
        }
    }

    //向左
    public void left() {
        if (theMap.getLeftEventID() != 0) {
            EventCntl.getTheEventCntl(theStage).startEvent(theMap.getLeftEventID());
        }
    }

    //向右
    public void right() {
        if (theMap.getRightEventID() != 0) {
            EventCntl.getTheEventCntl(theStage).startEvent(theMap.getRightEventID());
        }
    }

    //对话
    public void talk(ActionEvent event) {
        Creature theCreature = getCreature(event);
        int eventID = theCreature.getDialogEventID();
        EventCntl.getTheEventCntl(theStage).startEvent(eventID);
    }

    //对战
    public void combat(ActionEvent event) {
        Creature theCreature = getCreature(event);
        int eventID = theCreature.getCombatEventID();
        EventCntl.getTheEventCntl(theStage).startEvent(eventID);
    }

    //显示详细信息
    public void showInfo(Creature theCreature, Text creatureInfo) {
        if (theCreature.getRace() != 0) { //生物有种族
            creatureInfo.setText(theCreature.getName() + "\n"
                    + "生命: " + theCreature.getMaxHp() + "\n"
                    + "魔法: " + theCreature.getMaxMp() + "\n"
                    + "力量: " + theCreature.getStr() + "\n"
                    + "防御: " + theCreature.getDef() + "\n"
                    + "智力: " + theCreature.getIntl() + "\n"
                    + "敏捷: " + theCreature.getAgi() + "\n");
        }
    }

    //隐藏详细信息
    public void hideInfo(Text creatureInfo) {
        creatureInfo.setText("");
    }

    //获取鼠标点击的生物
    public Creature getCreature(ActionEvent event) {
        Button theButton = (Button) event.getSource();
        int creatureID = 0;
        switch (theButton.getId()) {
            case "npc1Interaction":
                creatureID = theMap.getNpc().get(0);
                break;
            case "npc2Interaction":
                creatureID = theMap.getNpc().get(1);
                break;
            case "npc3Interaction":
                creatureID = theMap.getNpc().get(2);
                break;
            case "monster1Interaction":
                creatureID = theMap.getMonster().get(0);
                break;
            case "monster2Interaction":
                creatureID = theMap.getMonster().get(1);
                break;
            case "monster3Interaction":
                creatureID = theMap.getMonster().get(2);
                break;
            default:
                break;
        }
        Creature theCreature = Data.getTheData().getTheCreatureListClass().getTheCreature(creatureID);
        return theCreature;
    }

    //获取鼠标指向的生物的名字
    public Creature getCreatureFromText(MouseEvent event) {
        Text theText = (Text) event.getSource();
        int creatureID = 0;
        switch (theText.getId()) {
            case "npc1":
                creatureID = theMap.getNpc().get(0);
                break;
            case "npc2":
                creatureID = theMap.getNpc().get(1);
                break;
            case "npc3":
                creatureID = theMap.getNpc().get(2);
                break;
            case "monster1":
                creatureID = theMap.getMonster().get(0);
                break;
            case "monster2":
                creatureID = theMap.getMonster().get(1);
                break;
            case "monster3":
                creatureID = theMap.getMonster().get(2);
                break;
            default:
                break;
        }
        Creature theCreature = Data.getTheData().getTheCreatureListClass().getTheCreature(creatureID);
        return theCreature;
    }

    //获取鼠标指向的生物的按钮
    public Creature getCreatureFromButton(MouseEvent event) {
        Button theButton = (Button) event.getSource();
        int creatureID = 0;
        switch (theButton.getId()) {
            case "npc1Interaction":
                creatureID = theMap.getNpc().get(0);
                break;
            case "npc2Interaction":
                creatureID = theMap.getNpc().get(1);
                break;
            case "npc3Interaction":
                creatureID = theMap.getNpc().get(2);
                break;
            case "monster1Interaction":
                creatureID = theMap.getMonster().get(0);
                break;
            case "monster2Interaction":
                creatureID = theMap.getMonster().get(1);
                break;
            case "monster3Interaction":
                creatureID = theMap.getMonster().get(2);
                break;
            default:
                break;
        }
        Creature theCreature = Data.getTheData().getTheCreatureListClass().getTheCreature(creatureID);
        return theCreature;
    }

    /**
     * @return the theMapCntl
     */
    public static MapCntl getTheMapCntl() {
        return theMapCntl;
    }

    public static MapCntl getTheMapCntl(Stage theStage) {
        theMapCntl = new MapCntl(theStage);
        return theMapCntl;
    }
}
