/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.model;

import java.io.*;

/**
 *
 * @author fitexmage
 */
public class Condition implements Serializable {

    private int conditionID; //状态ID
    private  String content; //内容
    private boolean condition; //状态

    public Condition(int conditionID, String content, boolean condition) {
        this.conditionID = conditionID;
        this.content = content;
        this.condition = condition;
    }

    public Condition() {

    }

    /**
     * @return the conditionID
     */
    public int getConditionID() {
        return conditionID;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the condition
     */
    public boolean isCondition() {
        return condition;
    }
}
