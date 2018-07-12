/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

import java.util.*;

/**
 *
 * @author fitexmage
 */
public class Skill {

    private int skillID; //技能ID
    private String name; //技能名字
    private String description; //技能描述
    private int cost; //技能消耗
    private ArrayList<SkillEffect> skillEffectList; //技能效果列表

    public Skill(int skillID, String name, String description, int cost, ArrayList<SkillEffect> skillEffectList) {
        this.skillID = skillID;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.skillEffectList = skillEffectList;
    }
    
    public Skill(){
        
    }

    /**
     * @return the skillID
     */
    public int getSkillID() {
        return skillID;
    }

    /**
     * @param skillID the skillID to set
     */
    public void setSkillID(int skillID) {
        this.skillID = skillID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return the skillEffectList
     */
    public ArrayList<SkillEffect> getSkillEffectList() {
        return skillEffectList;
    }

    /**
     * @param skillEffectList the skillEffectList to set
     */
    public void setSkillEffectList(ArrayList<SkillEffect> skillEffectList) {
        this.skillEffectList = skillEffectList;
    }
}
