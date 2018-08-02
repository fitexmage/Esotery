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
public class Map {

    private int mapID; //地图ID
    private String name; //地图名字
    private String description; //地图描述
    private int forwardEventID; //向前走所引发的事件
    private int backEventID; //向后走所引发的事件
    private int leftEventID; //向左走所引发的事件
    private int rightEventID; //向右走所引发的事件
    private ArrayList<Integer> npc; //NPC列表
    private ArrayList<Integer> monster; //怪物列表

    public Map(int mapID, String name, String description, int forwardEventID, int backEventID, int leftEventID, int rightEventID, ArrayList<Integer> npc, ArrayList<Integer> monster) {
        this.mapID = mapID;
        this.name = name;
        this.description = description;
        this.forwardEventID = forwardEventID;
        this.backEventID = backEventID;
        this.leftEventID = leftEventID;
        this.rightEventID = rightEventID;
        this.npc = npc;
        this.monster = monster;
    }

    public Map() {

    }

    /**
     * @return the mapID
     */
    public int getMapID() {
        return mapID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the forwardEventID
     */
    public int getForwardEventID() {
        return forwardEventID;
    }

    /**
     * @return the backEventID
     */
    public int getBackEventID() {
        return backEventID;
    }

    /**
     * @return the leftEventID
     */
    public int getLeftEventID() {
        return leftEventID;
    }

    /**
     * @return the rightEventID
     */
    public int getRightEventID() {
        return rightEventID;
    }

    /**
     * @return the npc
     */
    public ArrayList<Integer> getNpc() {
        return npc;
    }

    /**
     * @return the monster
     */
    public ArrayList<Integer> getMonster() {
        return monster;
    }
}
