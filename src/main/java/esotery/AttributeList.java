/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;
import javafx.scene.control.*;

/**
 *
 * @author fitexmage
 */
public class AttributeList extends dataList {

    private ArrayList<Attribute> attributeList;
    private String attributeFileName = "database/attribute.json";

    public AttributeList() {
        readFile();

        //防止无文件可读导致的报错
        if (attributeList == null) {
            attributeList = new ArrayList<>();
        }
    }

    //读取
    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            attributeList = mapper.readValue(new File(attributeFileName), new TypeReference<ArrayList<Attribute>>() {
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //写入
    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(attributeFileName), attributeList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //查找指定属性
    public Attribute getTheAttribute(int thePlayerID) {
        for (Attribute theAttribute : attributeList) {
            if (theAttribute.getPlayerID() == thePlayerID) {
                return theAttribute;
            }
        }
        return null;
    }

    //更新指定属性
    public void updateTheAttribute(Attribute newAttribute) {
        for (Attribute theAttribute : attributeList) {
            if (theAttribute.getPlayerID() == newAttribute.getPlayerID()) {
                theAttribute.update(newAttribute);
            }
        }
    }

    //添加新的属性
    public void addNewAttribute(int playerID, TextField name, CheckBox male, CheckBox female, CheckBox warrior, CheckBox assassin, CheckBox mage) {
        attributeList.add(Attribute.newAttribute(playerID, name, male, female, warrior, assassin, mage));
    }

    /**
     * @return the attributeList
     */
    public ArrayList<Attribute> getAttributeList() {
        return attributeList;
    }

    /**
     * @param attributeList the attributeList to set
     */
    public void setAttributeList(ArrayList<Attribute> attributeList) {
        this.attributeList = attributeList;
    }

    /**
     * @return the attributeFileName
     */
    public String getAttributeFileName() {
        return attributeFileName;
    }

    /**
     * @param attributeFileName the attributeFileName to set
     */
    public void setAttributeFileName(String attributeFileName) {
        this.attributeFileName = attributeFileName;
    }
}
