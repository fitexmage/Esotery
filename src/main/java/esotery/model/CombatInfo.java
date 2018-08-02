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
public class CombatInfo {

    int status; //状态
    int statusTurn; //状态轮数

    Character target; //目标
    int usedSkillID; //使用的技能

    public CombatInfo(int status, int statusTurn, Character target, int usedSkillID) {
        this.status = status;
        this.statusTurn = statusTurn;
        this.target = target;
        this.usedSkillID = usedSkillID;
    }
    
    //新的回合结果信息
    public static CombatInfo newCombatInfo(){
        CombatInfo newCombatInfo = new CombatInfo(0, 0, null, 0);
        return newCombatInfo;
    }
}
