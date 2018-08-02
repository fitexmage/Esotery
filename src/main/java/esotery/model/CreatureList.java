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
public class CreatureList{

    private ArrayList<Creature> theCreatureList;
    final String creatureFileName = "database/creature.json";

    public CreatureList() {
        readFile();
    }

    //读取
    private void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            theCreatureList = mapper.readValue(new File(creatureFileName), new TypeReference<ArrayList<Creature>>(){});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查找指定怪物
    public Creature getTheCreature(int theCreatureID) {
        for (Creature theCreature : theCreatureList) {
            if (theCreature.getCreatureID() == theCreatureID) {
                return theCreature;
            }
        }
        return null;
    }
}
