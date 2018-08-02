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
public class MapList{

    private ArrayList<Map> mapList;
    final String mapFileName = "database/map.json";

    public MapList() {
        readFile();
    }

    private void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapList = mapper.readValue(new File(mapFileName), new TypeReference<ArrayList<Map>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map getTheMap(int theMapID) {
        for (Map theMap : mapList) {
            if (theMap.getMapID() == theMapID) {
                return theMap;
            }
        }
        return null;
    }

    /**
     * @return the mapList
     */
    public ArrayList<Map> getMapList() {
        return mapList;
    }

    /**
     * @param mapList the mapList to set
     */
    public void setMapList(ArrayList<Map> mapList) {
        this.mapList = mapList;
    }
}
