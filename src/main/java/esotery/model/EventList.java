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
public class EventList{

    private ArrayList<Event> eventList;
    final String eventFileName = "database/event.json";

    public EventList() {
        readFile();
    }

    //读取
    private void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            eventList = mapper.readValue(new File(eventFileName), new TypeReference<ArrayList<Event>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
