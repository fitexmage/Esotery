/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

import java.io.*;
import javafx.scene.control.*;

/**
 *
 * @author fitexmage
 */
public class Attribute extends Character implements Serializable {

    private int playerID; //玩家ID
    private int gender; //性别 1: 男, 2: 女
    private int role; //职业 1: 战士 2: 刺客 3:法师
    private int location; //当前位置
    private int level; //等级,因为有get,所以必须要
    private int exp; //经验值
    private int neededExp; //下一级需要达到的经验值,因为有get,所以必须要

    public Attribute(int playerID, Character theCharacter, int gender, int role, int location, int exp) {
        super(theCharacter.getName(), theCharacter.getRace(), theCharacter.getHp(), theCharacter.getMaxHp(), theCharacter.getMp(), theCharacter.getMaxMp(), theCharacter.getStr(), theCharacter.getDef(), theCharacter.getIntl(), theCharacter.getAgi());
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
        super.setName(newAttribute.getName());
        super.setRace(newAttribute.getRace());
        super.setHp(newAttribute.getHp());
        super.setMaxHp(newAttribute.getMaxHp());
        super.setMp(newAttribute.getMp());
        super.setMaxMp(newAttribute.getMaxMp());
        super.setStr(newAttribute.getStr());
        super.setDef(newAttribute.getDef());
        super.setIntl(newAttribute.getIntl());
        super.setAgi(newAttribute.getAgi());
        this.gender = newAttribute.getGender();
        this.role = newAttribute.getRole();
        this.location = newAttribute.getLocation();
        this.exp = newAttribute.getExp();
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
     * @param neededExp the neededExp to set
     */
    public void setNeededExp(int neededExp) {
        this.neededExp = neededExp;
    }
}
