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
public class DialogList{

    private ArrayList<Dialog> dialogList;
    final String dialogFileName = "database/dialog.json";

    public DialogList() {
        readFile();
    }

    //读取
    private void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            dialogList = mapper.readValue(new File(dialogFileName), new TypeReference<ArrayList<Dialog>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
