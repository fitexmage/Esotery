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
            combatInfo.usedSkillID = 1;
        } else if (skill.size() == 2) { //有两个技能
            int r = (int) (Math.random() * 10);
            if (r < 5) {
                combatInfo.usedSkillID = skill.get(0);
            }else{
                combatInfo.usedSkillID = skill.get(1);
            }
        } else { //有三个技能
            int r = (int) (Math.random() * 10);
            if (r < 5) {
                combatInfo.usedSkillID = skill.get(0);
            } else if (r >= 5 && r < 8) {
                combatInfo.usedSkillID = skill.get(1);
            } else {
                combatInfo.usedSkillID = skill.get(2);
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
     * @return the dialogEventID
     */
    public int getDialogEventID() {
        return dialogEventID;
    }

    /**
     * @return the combatEventID
     */
    public int getCombatEventID() {
        return combatEventID;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the exp
     */
    public int getExp() {
        return exp;
    }

    /**
     * @return the skill
     */
    public ArrayList<Integer> getSkill() {
        return skill;
    }

    /**
     * @return the item
     */
    public HashMap<Integer, Integer> getItem() {
        return item;
    }
}
