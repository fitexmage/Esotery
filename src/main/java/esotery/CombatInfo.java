/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

/**
 *
 * @author fitexmage
 */
public class CombatInfo {

    private int status; //状态
    private int statusTurn; //状态轮数

    private Character target; //目标
    private int usedSkillID; //使用的技能

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

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the statusTurn
     */
    public int getStatusTurn() {
        return statusTurn;
    }

    /**
     * @param statusTurn the statusTurn to set
     */
    public void setStatusTurn(int statusTurn) {
        this.statusTurn = statusTurn;
    }

    /**
     * @return the target
     */
    public Character getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(Character target) {
        this.target = target;
    }

    /**
     * @return the usedSkillID
     */
    public int getUsedSkillID() {
        return usedSkillID;
    }

    /**
     * @param usedSkillID the usedSkillID to set
     */
    public void setUsedSkillID(int usedSkillID) {
        this.usedSkillID = usedSkillID;
    }
}
