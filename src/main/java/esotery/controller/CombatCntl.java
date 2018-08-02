/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.controller;

import esotery.model.Character;
import esotery.model.Attribute;
import esotery.model.CombatInfo;
import esotery.model.Map;
import esotery.model.Creature;
import esotery.model.Data;
import esotery.model.Player;
import esotery.model.SkillList;
import java.util.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.*;

/**
 *
 * @author fitexmage
 */
public class CombatCntl {

    private Stage theStage;
    private static CombatCntl theCombatCntl;
    private Attribute rawPlayer; //玩家本体
    private Attribute combatPlayer; //玩家复制体,可防止战斗中的数值变化影响本体
    private Creature rawEnemy; //怪物本体
    private Creature combatEnemy; //怪物复制体,可防止战斗中的数值变化影响本体
    private int turn; //回合
    
    private String record; //回合结果信息

    public CombatCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene(int creatureID) {
        try {
            combatBegin(creatureID);
            Parent root = FXMLLoader.load(getClass().getResource("/CombatUI.fxml"));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //战斗开始
    public void combatBegin(int creatureID) {
        turn = 1; //初始化回合
        rawPlayer = Player.getThePlayer().getTheAttribute(); //获得本体
        combatPlayer = (Attribute) rawPlayer.clone(); //获得复制体
        rawEnemy = Data.getTheData().getTheCreatureListClass().getTheCreature(creatureID); //获得本体
        combatEnemy = (Creature) rawEnemy.clone(); //获得复制体

        combatPlayer.setCombatInfo(CombatInfo.newCombatInfo()); //初始化玩家战斗信息
        combatPlayer.getCombatInfo().setTarget(combatEnemy); //设置目标
        combatEnemy.setCombatInfo(CombatInfo.newCombatInfo()); //初始化怪物战斗信息
        combatEnemy.getCombatInfo().setTarget(combatPlayer); //设置目标
        
        record = ""; //初始化回合结果信息
    }

    public void initialize(Text name, Text description, ProgressBar playerHpBar, ProgressBar playerMpBar, Text playerHpText, Text playerMpText, Text player, ProgressBar enemyHpBar, ProgressBar enemyMpBar, Text enemyHpText, Text enemyMpText, Text enemy) {
        Map theMap = Data.getTheData().getTheMapListClass().getTheMap(Player.getThePlayer().getTheAttribute().getLocation()); //获取当前地图
        name.setText(theMap.getName()); //显示地图名字
        description.setText(theMap.getDescription()); //显示地图描述
        showPlayer(playerHpBar, playerMpBar, playerHpText, playerMpText, player); //显示玩家信息
        showEnemy(enemyHpBar, enemyMpBar, enemyHpText, enemyMpText, enemy); //显示怪物信息
    }

    //显示玩家信息
    public void showPlayer(ProgressBar playerHpBar, ProgressBar playerMpBar, Text playerHpText, Text playerMpText, Text player) {
        double playerHpProgress = combatPlayer.getHp() * 1.0 / combatPlayer.getMaxHp();
        double playerMpProgress = combatPlayer.getMp() * 1.0 / combatPlayer.getMaxMp();
        playerHpBar.setProgress(playerHpProgress); //显示生命值进度条
        playerMpBar.setProgress(playerMpProgress); //显示魔法值进度条
        playerHpText.setText("生命: " + combatPlayer.getHp() + "/" + combatPlayer.getMaxHp()); //显示生命值
        playerMpText.setText("魔法: " + combatPlayer.getMp() + "/" + combatPlayer.getMaxMp()); //显示魔法值

        player.setText(combatPlayer.getName() + "\n"
                + "等级: Lv. " + combatPlayer.getLevel() + "\n\n"
                + "力量: " + combatPlayer.getStr() + "\n"
                + "防御: " + combatPlayer.getDef() + "\n"
                + "智力: " + combatPlayer.getIntl() + "\n"
                + "敏捷: " + combatPlayer.getAgi()); //显示各项能力
    }

    //显示怪物信息
    public void showEnemy(ProgressBar enemyHpBar, ProgressBar enemyMpBar, Text enemyHpText, Text enemyMpText, Text enemy) {
        double enemyHpProgress = combatEnemy.getHp() * 1.0 / combatEnemy.getMaxHp();
        double enemyMpProgress = combatEnemy.getMp() * 1.0 / combatEnemy.getMaxMp();
        enemyHpBar.setProgress(enemyHpProgress); //显示生命值进度条
        enemyMpBar.setProgress(enemyMpProgress); //显示魔法值进度条
        enemyHpText.setText("生命: " + combatEnemy.getHp() + "/" + combatEnemy.getMaxHp()); //显示生命值
        enemyMpText.setText("魔法: " + combatEnemy.getMp() + "/" + combatEnemy.getMaxMp()); //显示魔法值

        enemy.setText(combatEnemy.getName() + "\n"
                + "等级: Lv. " + combatEnemy.getLevel() + "\n\n"
                + "力量: " + combatEnemy.getStr() + "\n"
                + "防御: " + combatEnemy.getDef() + "\n"
                + "智力: " + combatEnemy.getIntl() + "\n"
                + "敏捷: " + combatEnemy.getAgi()); //显示各项能力
    }

    //攻击选项
    public void attack(Text result) {
        combatPlayer.getCombatInfo().setUsedSkillID(1);
        turnBegin(result); //回合开始
    }

    //法术选项
    public void skill(Text result) {

    }

    //物品选项
    public void item(Text result) {
        combatPlayer.getCombatInfo().setUsedSkillID(0);
    }

    //逃跑选项
    public void run() {
        rawPlayer.setHp(combatPlayer.getHp()); //更新生命
        rawPlayer.setMp(combatPlayer.getMp()); //更新魔法
        DialogCntl.getTheDialogCntl(theStage).setUpScene(2); //显示信息
    }

    //回合开始
    public void turnBegin(Text result) {
        beforeAction(); //回合前
        onAction(); //回合中
        afterAction(result); //回合后
    }

    //回合前
    public void beforeAction() {
        combatEnemy.autoChooseSkill(); //怪物随机选择技能
    }

    //回合中
    public void onAction() {

        if (combatPlayer.getCombatInfo().getUsedSkillID() != 0) { //攻击

            ArrayList<Character> ActionList = new ArrayList<Character>(); //行动顺序列表
            if (combatPlayer.getAgi() >= combatEnemy.getAgi()) {
                ActionList.add(combatPlayer);
                ActionList.add(combatEnemy);
            } else {
                ActionList.add(combatEnemy);
                ActionList.add(combatPlayer);
            }

            //根据顺序行动
            for (Character theCharacter : ActionList) {
                String fightRecord = theCharacter.fight(theCharacter.getCombatInfo().getTarget()); //获取对战信息
                //记录回合结果信息
                record += theCharacter.getName() + "使用" + SkillList.getTheSkill(theCharacter.getCombatInfo().getUsedSkillID()).getName() + "\n";
                record += fightRecord;
                record += "\n";
                checkCombatEnd(); //检验对战是否已结束
            }
        } else { //物品

        }
    }

    //回合后
    public void afterAction(Text result) {
        turn++; //回合数加一
        combatPlayer.getCombatInfo().setUsedSkillID(0); //法术初始化
        result.setText(record); //显示回合结果信息
        record = ""; //初始化回合结果信息
    }

    //检验对战是否已结束
    public void checkCombatEnd() {
        if (combatEnemy.getHp() <= 0) { //玩家获胜
            rawPlayer.setHp(combatPlayer.getHp()); //更新生命
            rawPlayer.setMp(combatPlayer.getMp()); //更新魔法
            
            DialogCntl.getTheDialogCntl(theStage).setTempSpeaker("战斗结果");
            int levelDifference = rawPlayer.getLevelDifference(rawPlayer.getExp() + rawEnemy.getExp()); //获得升级前后等级差异
            rawPlayer.gainExp(rawEnemy.getExp()); //获得经验值
            
            if (levelDifference != 0) { //如果升级
                DialogCntl.getTheDialogCntl().setTempText("战斗胜利!" + "\n"
                        + "获得了" + rawEnemy.getExp() + "点经验值!" + "\n"
                        + "你升到了" + rawPlayer.getLevel() + "级!" + "\n"); //结算信息
                for (int i = 0; i < levelDifference; i++) {
                    rawPlayer.levelUp(); //升级后能力提升
                }
                //满血满蓝
                rawPlayer.setHp(rawPlayer.getMaxHp());
                rawPlayer.setMp(rawPlayer.getMaxMp());
            } else { //如果未升级
                DialogCntl.getTheDialogCntl().setTempText("战斗胜利!" + "\n"
                        + "获得了" + rawEnemy.getExp() + "点经验值!"); //结算信息
            }
            DialogCntl.getTheDialogCntl().setUpScene(0); //显示结算信息
        } else if (combatPlayer.getHp() <= 0) { //怪物获胜
            rawPlayer.setHp(1); //保留玩家一点生命
            rawPlayer.setMp(combatPlayer.getMp()); //更新魔法
            DialogCntl.getTheDialogCntl(theStage).setUpScene(1); //显示结算信息
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
     * @return the theCombatCntl
     */
    public static CombatCntl getTheCombatCntl() {
        return theCombatCntl;
    }

    public static CombatCntl getTheCombatCntl(Stage theStage) {
        theCombatCntl = new CombatCntl(theStage);
        return theCombatCntl;
    }

    /**
     * @param aTheCombatCntl the theCombatCntl to set
     */
    public static void setTheCombatCntl(CombatCntl aTheCombatCntl) {
        theCombatCntl = aTheCombatCntl;
    }

    /**
     * @return the rawPlayer
     */
    public Attribute getRawPlayer() {
        return rawPlayer;
    }

    /**
     * @param rawPlayer the rawPlayer to set
     */
    public void setRawPlayer(Attribute rawPlayer) {
        this.rawPlayer = rawPlayer;
    }

    /**
     * @return the combatPlayer
     */
    public Attribute getCombatPlayer() {
        return combatPlayer;
    }

    /**
     * @param combatPlayer the combatPlayer to set
     */
    public void setCombatPlayer(Attribute combatPlayer) {
        this.combatPlayer = combatPlayer;
    }

    /**
     * @return the rawEnemy
     */
    public Creature getRawEnemy() {
        return rawEnemy;
    }

    /**
     * @param rawEnemy the rawEnemy to set
     */
    public void setRawEnemy(Creature rawEnemy) {
        this.rawEnemy = rawEnemy;
    }

    /**
     * @return the combatEnemy
     */
    public Creature getCombatEnemy() {
        return combatEnemy;
    }

    /**
     * @param combatEnemy the combatEnemy to set
     */
    public void setCombatEnemy(Creature combatEnemy) {
        this.combatEnemy = combatEnemy;
    }

    /**
     * @return the turn
     */
    public int getTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * @return the record
     */
    public String getRecord() {
        return record;
    }

    /**
     * @param record the record to set
     */
    public void setRecord(String record) {
        this.record = record;
    }
}
