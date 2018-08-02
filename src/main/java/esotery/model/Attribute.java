/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.model;

import java.io.*;
import javafx.scene.control.*;

/**
 *
 * @author fitexmage
 */
public class Attribute extends Character implements Serializable {

    int playerID; //玩家ID
    int gender; //性别 1: 男, 2: 女
    int role; //职业 1: 战士 2: 刺客 3:法师
    int location; //当前位置
    int level; //等级,因为有get,所以必须要
    int exp; //经验值
    int neededExp; //下一级需要达到的经验值,因为有get,所以必须要

    public Attribute(int playerID, Character theCharacter, int gender, int role, int location, int exp) {
        super(theCharacter.name, theCharacter.race, theCharacter.hp, theCharacter.maxHp, theCharacter.mp, theCharacter.maxMp, theCharacter.str, theCharacter.def, theCharacter.intl, theCharacter.agi);
        this.playerID = playerID;
        this.gender = gender;
        this.role = role;
        this.location = location;
        this.exp = exp;
    }

    public Attribute() {

    }

    //更新属性
    public void update(Attribute newAttribute) {
        super.name = newAttribute.name;
        super.race = newAttribute.race;
        super.hp = newAttribute.hp;
        super.maxHp = newAttribute.maxHp;
        super.mp = newAttribute.mp;
        super.maxMp = newAttribute.maxMp;
        super.str = newAttribute.str;
        super.def = newAttribute.def;
        super.intl = newAttribute.intl;
        super.agi = newAttribute.agi;
        this.gender = newAttribute.gender;
        this.role = newAttribute.role;
        this.location = newAttribute.location;
        this.exp = newAttribute.exp;
    }

    //新的属性
    public static Attribute newAttribute(int playerID, TextField name, CheckBox male, CheckBox female, CheckBox warrior, CheckBox assassin, CheckBox mage) {
        int race = 1;
        int gender = 1;
        int role = 1;
        int location = 1;
        int exp = 0;

        //判断性别
        if (male.isSelected()) {
            gender = 1;
        } else if (female.isSelected()) {
            gender = 2;
        }

        //判断职业
        if (warrior.isSelected()) {
            role = 1;
        } else if (assassin.isSelected()) {
            role = 2;
        } else if (mage.isSelected()) {
            role = 3;
        }

        Attribute newAttribute = new Attribute(playerID, Character.getNewCharacter(name.getText(), race), gender, role, location, exp);
        return newAttribute;
    }

    //得到等级
    public int getLevel() {
        if (exp == 0) {
            return 1;
        } else {
            return (int) Math.pow(exp, 1.0 / 2);
        }
    }

    //得到需要的经验值
    public int getNeededExp() {
        int nextLevel = getLevel() + 1;
        return (int) Math.pow(nextLevel, 2);
    }

    //给予经验值
    public void gainExp(int enemyExp) {
        exp += enemyExp;
    }

    //得到升级前后等级差异
    public int getLevelDifference(int proExp) {
        return (int) Math.pow(proExp, 1.0 / 2) - getLevel();
    }
    
    //升级后能力提升
    public void levelUp() {
        switch (role) {
            case 1:
                changeAbility(5, 1, 2, 3, 1, 1);
                break;
            case 2:
                changeAbility(2, 2, 5, 1, 1, 3);
                break;
            case 3:
                changeAbility(3, 5, 1, 1, 6, 1);
                break;
        }
    }

    /**
     * @return the playerID
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * @param playerID the playerID to set
     */
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    /**
     * @return the gender
     */
    public int getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * @return the location
     */
    public int getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(int location) {
        this.location = location;
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
}
