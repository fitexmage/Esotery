/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.model;

import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author fitexmage
 */
public class ConditionList{

    private HashMap<Integer, ArrayList<Condition>> conditionPackageList;
    final String conditionFileName = "database/condition.json";
    final static String originalConditionFileName = "database/originalCondition.json";

    public ConditionList() {
        readFile();
        //防止无文件可读导致的报错
        if (conditionPackageList == null) {
            conditionPackageList = new HashMap<>();
        }
    }

    //读取
    private void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            conditionPackageList = mapper.readValue(new File(conditionFileName), new TypeReference<HashMap<Integer, ArrayList<Condition>>>() {
            });
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    //写入
    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(conditionFileName), conditionPackageList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //获取指定状态包
    public ArrayList<Condition> getTheConditionPackage(int thePlayerID) {
        return conditionPackageList.get(thePlayerID);
    }

    //获取指定状态
    public Condition getTheCondition(int thePlayerID, int theConditionID) {
        ArrayList<Condition> theConditionPackage = getTheConditionPackage(thePlayerID);
        for (Condition theCondition : theConditionPackage) {
            if (theCondition.getConditionID() == theConditionID) {
                return theCondition;
            }
        }
        return null;
    }

    //新的状态包
    public static ArrayList<Condition> newConditionPackage() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Condition> originalConditionPackage;
        try {
            originalConditionPackage = mapper.readValue(new File(originalConditionFileName), new TypeReference<ArrayList<Condition>>() {
            });
            return originalConditionPackage;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //添加新的状态包
    public void addNewConditionPackage(int playerID) {
        updateTheConditionPackage(playerID, newConditionPackage());
    }
    
    //更新指定状态包
    public void updateTheConditionPackage(int thePlayerID, ArrayList<Condition> newConditionPackage){
        conditionPackageList.put(thePlayerID, newConditionPackage);
    }
}
