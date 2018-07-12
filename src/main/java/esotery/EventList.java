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
public class EventList extends dataList{

    private ArrayList<Event> eventList;
    private String eventFileName = "database/event.json";

    public EventList() {
        readFile();
    }

    //读取
    public void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            eventList = mapper.readValue(new File(eventFileName), new TypeReference<ArrayList<Event>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //写入
    public void writeFile(){
        
    }

    //查找指定事件
    public Event getTheEvent(int theEventID) {
        for (Event theEvent : eventList) {
            if (theEvent.getEventID() == theEventID) {
                return theEvent;
            }
        }
        return null;
    }

    //打印事件列表
    public void printEventList() {
        for (Event theEvent : eventList) {
            System.out.println(theEvent.getEventID() + " " 
                    + theEvent.getDescription());
            
            for (EventAction theAction : theEvent.getEventActionList()) {
                System.out.print(theAction.getType() + " " + theAction.getActionID() + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    /**
     * @return the eventList
     */
    public ArrayList<Event> getEventList() {
        return eventList;
    }

    /**
     * @param eventList the eventList to set
     */
    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }

    /**
     * @return the eventFileName
     */
    public String getEventFileName() {
        return eventFileName;
    }

    /**
     * @param eventFileName the eventFileName to set
     */
    public void setEventFileName(String eventFileName) {
        this.eventFileName = eventFileName;
    }
}
