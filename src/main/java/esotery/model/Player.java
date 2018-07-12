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
public class Player {

    //单一玩家所有信息
    private static Player thePlayer;
    
    private Account theAccount;
    private Attribute theAttribute;
    private ArrayList<Condition> conditionPackage;
    private ArrayList<Skill> skillPackage;

    public Player(int playerID) {
        theAccount = Data.getTheData().getTheAccountListClass().getTheAccount(playerID);
        theAttribute = Data.getTheData().getTheAttributeListClass().getTheAttribute(playerID);
        skillPackage = Data.getTheData().getTheSkillListClass().getTheSkillPackage(playerID);
        conditionPackage = Data.getTheData().getTheConditionListClass().getTheConditionPackage(playerID);
    }

    /**
     * @return the thePlayer
     */
    public static Player getThePlayer() {
        return thePlayer;
    }

    /**
     * @param aThePlayer the thePlayer to set
     */
    public static void setThePlayer(Player aThePlayer) {
        thePlayer = aThePlayer;
    }

    /**
     * @return the theAccount
     */
    public Account getTheAccount() {
        return theAccount;
    }

    /**
     * @param theAccount the theAccount to set
     */
    public void setTheAccount(Account theAccount) {
        this.theAccount = theAccount;
    }

    /**
     * @return the theAttribute
     */
    public Attribute getTheAttribute() {
        return theAttribute;
    }

    /**
     * @param theAttribute the theAttribute to set
     */
    public void setTheAttribute(Attribute theAttribute) {
        this.theAttribute = theAttribute;
    }

    /**
     * @return the conditionPackage
     */
    public ArrayList<Condition> getConditionPackage() {
        return conditionPackage;
    }

    /**
     * @param conditionPackage the conditionPackage to set
     */
    public void setConditionPackage(ArrayList<Condition> conditionPackage) {
        this.conditionPackage = conditionPackage;
    }

    /**
     * @return the skillPackage
     */
    public ArrayList<Skill> getSkillPackage() {
        return skillPackage;
    }

    /**
     * @param skillPackage the skillPackage to set
     */
    public void setSkillPackage(ArrayList<Skill> skillPackage) {
        this.skillPackage = skillPackage;
    }
}
