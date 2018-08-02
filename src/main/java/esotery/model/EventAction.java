/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.model;

/**
 *
 * @author fitexmage
 */
public class EventAction {

    private int type; //类型 1: 前往地图(mapID) 2: 显示对话(dialogID) 3: 进行对战(creatureID) 4: 添加物品(itemID) 5: 添加技能(skillID) 6: 移除物品(itemID) 7: 改变种族(raceID) 8: 改变开关(conditionID) 9: 满血满蓝 10:判断下一个事件(conditionID, event0ID(true), event1ID(false))
    private int actionID; //动作ID

    public EventAction(int type, int actionID) {
        this.type = type;
        this.actionID = actionID;
    }

    public EventAction() {

    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @return the actionID
     */
    public int getActionID() {
        return actionID;
    }
}
