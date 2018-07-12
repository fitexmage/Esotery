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
     * @param dialogID the dialogID to set
     */
    public void setDialogID(int dialogID) {
        this.dialogID = dialogID;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the speaker
     */
    public String getSpeaker() {
        return speaker;
    }

    /**
     * @param speaker the speaker to set
     */
    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    /**
     * @return the choiceID
     */
    public ArrayList<Integer> getChoiceID() {
        return choiceID;
    }

    /**
     * @param choiceID the choiceID to set
     */
    public void setChoiceID(ArrayList<Integer> choiceID) {
        this.choiceID = choiceID;
    }
}
