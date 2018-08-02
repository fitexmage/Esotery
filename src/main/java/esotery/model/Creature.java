/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.model;

import java.util.*;

/**
 *
 * @author fitexmage
 */
public class Creature extends Character {

    private int creatureID; //怪物ID
    private int dialogEventID; //对话事件ID
    private int combatEventID; //战斗事件ID
    private int level; //等级
    private int exp; //经验值
    private ArrayList<Integer> skill; //技能列表
    private HashMap<Integer, Integer> item; //物品列表

    public Creature(int creatureID, Character theCharacter, int dialogEventID, int combatEventID, int level, int exp, ArrayList<Integer> skill, HashMap<Integer, Integer> item) {
        super(theCharacter.name, theCharacter.race, theCharacter.hp, theCharacter.maxHp, theCharacter.mp, theCharacter.maxMp, theCharacter.str, theCharacter.def, theCharacter.intl, theCharacter.agi);
        this.creatureID = creatureID;
        this.dialogEventID = dialogEventID;
        this.combatEventID = combatEventID;
        this.level = level;
        this.exp = exp;
        this.skill = skill;
        this.item = item;
    }

    public Creature() {

    }

    //怪物随机选择技能
    public void autoChooseSkill() {
        if (skill.size() == 1) { //只有一个技能
            combatInfo.setUsedSkillID(1);
        } else if (skill.size() == 2) { //有两个技能
            int r = (int) (Math.random() * 10);
            if (r < 5) {
                combatInfo.usedSkillID = skill.get(0);
            }else{
                getCombatInfo().setUsedSkillID(skill.get(1));
            }
        } else { //有三个技能
            int r = (int) (Math.random() * 10);
            if (r < 5) {
                getCombatInfo().setUsedSkillID(skill.get(0));
            } else if (r >= 5 && r < 8) {
                getCombatInfo().setUsedSkillID(skill.get(1));
            } else {
                getCombatInfo().setUsedSkillID(skill.get(2));
            }
        }
    }

    /**
     * @return the creatureID
     */
    public int getCreatureID() {
        return creatureID;
    }

    /**
     * @param creatureID the creatureID to set
     */
    public void setCreatureID(int creatureID) {
        this.creatureID = creatureID;
    }

    /**
     * @return the dialogEventID
     */
    public int getDialogEventID() {
        return dialogEventID;
    }

    /**
     * @param dialogEventID the dialogEventID to set
     */
    public void setDialogEventID(int dialogEventID) {
        this.dialogEventID = dialogEventID;
    }

    /**
     * @return the combatEventID
     */
    public int getCombatEventID() {
        return combatEventID;
    }

    /**
     * @param combatEventID the combatEventID to set
     */
    public void setCombatEventID(int combatEventID) {
        this.combatEventID = combatEventID;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the exp
     */
    public int getExp() {
        return exp;
    }

    /**
     * @param exp the exp to set
     */
    public void setExp(int exp) {
        this.exp = exp;
    }

    /**
     * @return the skill
     */
    public ArrayList<Integer> getSkill() {
        return skill;
    }

    /**
     * @param skill the skill to set
     */
    public void setSkill(ArrayList<Integer> skill) {
        this.skill = skill;
    }

    /**
     * @return the item
     */
    public HashMap<Integer, Integer> getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(HashMap<Integer, Integer> item) {
        this.item = item;
    }
}
