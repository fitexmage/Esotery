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
public class Event {

    private int eventID; //事件ID
    private String description; //事件描述
    private ArrayList<EventAction> eventActionList; //事件动作列表

    public Event(int eventID, String description, ArrayList<EventAction> eventActionList) {
        this.eventID = eventID;
        this.description = description;
        this.eventActionList = eventActionList;
    }

    public Event() {

    }

    /**
     * @return the eventID
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the eventActionList
     */
    public ArrayList<EventAction> getEventActionList() {
        return eventActionList;
    }
}
