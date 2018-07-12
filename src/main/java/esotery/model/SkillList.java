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
import java.util.Map.*;

/**
 *
 * @author fitexmage
 */
public class SkillList extends dataList{

    private HashMap<Integer, ArrayList<Skill>> skillPackageList;
    private String skillFileName = "database/skill.json";
    private static String originalSkillFileName = "database/originalSkill.json";

    public SkillList() {
        readFile();
        if (skillPackageList == null) {
            skillPackageList = new HashMap<>();
        }
    }

    //读取
    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            skillPackageList = mapper.readValue(new File(skillFileName), new TypeReference<HashMap<Integer, ArrayList<Skill>>>() {
            });
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    //写入
    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(skillFileName), skillPackageList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //查找指定技能包
    public ArrayList<Skill> getTheSkillPackage(int thePlayerID) {
        for (Entry<Integer, ArrayList<Skill>> theSkillPackage : skillPackageList.entrySet()) {
            if (theSkillPackage.getKey() == thePlayerID) {
                return theSkillPackage.getValue();
            }
        }
        return null;
    }

    //查找指定技能
    public static Skill getTheSkill(int theSkillID) {
        ArrayList<Skill> theSkillPackage = getAllSkill();
        for (Skill theSkill : theSkillPackage) {
            if (theSkill.getSkillID() == theSkillID) {
                return theSkill;
            }
        }
        return null;
    }

    //获取所有技能
    public static ArrayList<Skill> getAllSkill() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Skill> originalSkillPackage;
        try {
            originalSkillPackage = mapper.readValue(new File(originalSkillFileName), new TypeReference<ArrayList<Skill>>() {
            });
            return originalSkillPackage;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //添加新的技能包
    public void addNewSkillPackage(int playerID) {
        updateTheSkillPackage(playerID, new ArrayList<>());
    }
    
    //更新技能包
    public void updateTheSkillPackage(int thePlayerID, ArrayList<Skill> newSkillPackage){
        skillPackageList.put(thePlayerID, newSkillPackage);
    }
}
