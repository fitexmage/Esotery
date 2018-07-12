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
     * @param mapID the mapID to set
     */
    public void setMapID(int mapID) {
        this.mapID = mapID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the forwardEventID
     */
    public int getForwardEventID() {
        return forwardEventID;
    }

    /**
     * @param forwardEventID the forwardEventID to set
     */
    public void setForwardEventID(int forwardEventID) {
        this.forwardEventID = forwardEventID;
    }

    /**
     * @return the backEventID
     */
    public int getBackEventID() {
        return backEventID;
    }

    /**
     * @param backEventID the backEventID to set
     */
    public void setBackEventID(int backEventID) {
        this.backEventID = backEventID;
    }

    /**
     * @return the leftEventID
     */
    public int getLeftEventID() {
        return leftEventID;
    }

    /**
     * @param leftEventID the leftEventID to set
     */
    public void setLeftEventID(int leftEventID) {
        this.leftEventID = leftEventID;
    }

    /**
     * @return the rightEventID
     */
    public int getRightEventID() {
        return rightEventID;
    }

    /**
     * @param rightEventID the rightEventID to set
     */
    public void setRightEventID(int rightEventID) {
        this.rightEventID = rightEventID;
    }

    /**
     * @return the npc
     */
    public ArrayList<Integer> getNpc() {
        return npc;
    }

    /**
     * @param npc the npc to set
     */
    public void setNpc(ArrayList<Integer> npc) {
        this.npc = npc;
    }

    /**
     * @return the monster
     */
    public ArrayList<Integer> getMonster() {
        return monster;
    }

    /**
     * @param monster the monster to set
     */
    public void setMonster(ArrayList<Integer> monster) {
        this.monster = monster;
    }
}
