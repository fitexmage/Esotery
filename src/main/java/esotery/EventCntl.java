/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

import java.util.*;
import javafx.stage.*;

/**
 *
 * @author fitexmage
 */
public class EventCntl {

    private Stage theStage;
    private static EventCntl theEventCntl;
    private int eventID; //事件ID
    private int step; //事件步骤

    public EventCntl(Stage theExistingStage) {
        theStage = theExistingStage;
        step = 0; //初始化步骤
    }

    public void startEvent(int eventID) {
        if (eventID != 0) { //如果不是0,说明是新事件
            this.eventID = eventID;
        }
        Event theEvent = Data.getTheData().getTheEventListClass().getTheEvent(this.eventID); //获取事件
        ArrayList<EventAction> theActionList = theEvent.getEventActionList(); //获取事件动作列表
        EventAction theAction = theActionList.get(step); //获取动作
        switch (theAction.getType()) {
            case 1: //地图
                if (theAction.getActionID() == 0) { //当前位置
                    MapCntl.getTheMapCntl(theStage).setUpScene();
                } else { //其他位置
                    Player.getThePlayer().getTheAttribute().setLocation(theAction.getActionID());
                    MapCntl.getTheMapCntl(theStage).setUpScene();
                }
                break;
            case 2: //对话
                DialogCntl.getTheDialogCntl(theStage).setUpScene(theAction.getActionID());
                break;
            case 3: //对战
                CombatCntl.getTheCombatCntl(theStage).setUpScene(theAction.getActionID());
                break;
            default:
                break;
        }
        step++; //步骤加一

        if (step != theActionList.size()) { //事件未结束
            theAction = theActionList.get(step);
            if (theAction.getType() == 9) { //满血满蓝
                Player.getThePlayer().getTheAttribute().setHp(Player.getThePlayer().getTheAttribute().getMaxHp());
                Player.getThePlayer().getTheAttribute().setMp(Player.getThePlayer().getTheAttribute().getMaxMp());
                step++; //步骤加一
            }
        }

        if (step == theActionList.size()) { //事件结束
            step = 0; //初始化步骤
        }
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
     * @return the theEventCntl
     */
    public static EventCntl getTheEventCntl(Stage theStage) {
        if (theEventCntl == null) {
            theEventCntl = new EventCntl(theStage);
        }
        return theEventCntl;
    }

    /**
     * @return the eventID
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * @param eventID the eventID to set
     */
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     * @return the step
     */
    public int getStep() {
        return step;
    }

    /**
     * @param step the step to set
     */
    public void setStep(int step) {
        this.step = step;
    }
}
