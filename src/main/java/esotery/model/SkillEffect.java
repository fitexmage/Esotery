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
public class SkillEffect{

    private int target; //目标 1: enemy 2: self
    private int attributeBased; //基于此项属性进行加成 1: HP 2: MP 3: str 4: def 5: intl 6: agi
    private int attributeTarget; //加减该项属性 1: HP 2: MP 3: str 4: def 5: intl 6: agi
    private double value;  //伤害百分比

    public SkillEffect(int target, int attributeBased, int attributeTarget, double value) {
        this.target = target;
        this.attributeBased = attributeBased;
        this.attributeTarget = attributeTarget;
        this.value = value;
    }
    
    public SkillEffect(){
        
    }

    /**
     * @return the target
     */
    public int getTarget() {
        return target;
    }

    /**
     * @return the attributeBased
     */
    public int getAttributeBased() {
        return attributeBased;
    }

    /**
     * @return the attributeTarget
     */
    public int getAttributeTarget() {
        return attributeTarget;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }
}
