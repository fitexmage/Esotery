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
public class Dialog {

    private int dialogID; //对话ID
    private String content; //内容
    private String speaker; //说话者
    private ArrayList<Integer> choiceID; //选项

    public Dialog(int dialogID, String content, String speaker, ArrayList<Integer> choiceID) {
        this.dialogID = dialogID;
        this.content = content;
        this.speaker = speaker;
        this.choiceID = choiceID;
    }

    public Dialog() {

    }

    /**
     * @return the dialogID
     */
    public int getDialogID() {
        return dialogID;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the speaker
     */
    public String getSpeaker() {
        return speaker;
    }

    /**
     * @return the choiceID
     */
    public ArrayList<Integer> getChoiceID() {
        return choiceID;
    }
}
