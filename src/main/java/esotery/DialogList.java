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

/**
 *
 * @author fitexmage
 */
public class DialogList extends dataList{

    private ArrayList<Dialog> dialogList;
    private String dialogFileName = "database/dialog.json";

    public DialogList() {
        readFile();
    }

    //读取
    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            dialogList = mapper.readValue(new File(dialogFileName), new TypeReference<ArrayList<Dialog>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //写入
    public void writeFile(){

    }

    //查找指定对话
    public Dialog getTheDialog(int theDialogID) {
        for (Dialog theDialog : dialogList) {
            if (theDialog.getDialogID() == theDialogID) {
                return theDialog;
            }
        }
        return null;
    }

    /**
     * @return the dialogList
     */
    public ArrayList<Dialog> getDialogList() {
        return dialogList;
    }

    /**
     * @param dialogList the dialogList to set
     */
    public void setDialogList(ArrayList<Dialog> dialogList) {
        this.dialogList = dialogList;
    }

    /**
     * @return the dialogFileName
     */
    public String getDialogFileName() {
        return dialogFileName;
    }

    /**
     * @param dialogFileName the dialogFileName to set
     */
    public void setDialogFileName(String dialogFileName) {
        this.dialogFileName = dialogFileName;
    }
}
