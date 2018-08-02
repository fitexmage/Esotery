/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery.model;

/**
 *
 * @author fitexmage
 */
public class Data {

    //初始化所有数据
    private static Data theData;
    
    AccountList theAccountListClass;
    AttributeList theAttributeListClass;
    SkillList theSkillListClass;
    ConditionList theConditionListClass;
    MapList theMapListClass;
    EventList theEventListClass;
    DialogList theDialogListClass;
    CreatureList theCreatureListClass;

    public Data() {
        showProcess(10);
        theAccountListClass = new AccountList();
        showProcess(30);
        theAttributeListClass = new AttributeList();
        showProcess(40);
        theSkillListClass = new SkillList();
        showProcess(50);
        theCreatureListClass = new CreatureList();
        showProcess(60);
        theConditionListClass = new ConditionList();
        showProcess(70);
        theMapListClass = new MapList();
        showProcess(80);
        theEventListClass = new EventList();
        showProcess(90);
        theDialogListClass = new DialogList();
        showProcess(100);
    }
    
    //进度显示
    public void showProcess(int process){
        System.out.println("载入中... " + process + "%");
    }

    /**
     * @return the theData
     */
    public static Data getTheData() {
        return theData;
    }

    /**
     * @param aTheData the theData to set
     */
    public static void setTheData(Data aTheData) {
        theData = aTheData;
    }

    /**
     * @return the theAccountListClass
     */
    public AccountList getTheAccountListClass() {
        return theAccountListClass;
    }

    /**
     * @return the theAttributeListClass
     */
    public AttributeList getTheAttributeListClass() {
        return theAttributeListClass;
    }

    /**
     * @return the theSkillListClass
     */
    public SkillList getTheSkillListClass() {
        return theSkillListClass;
    }

    /**
     * @return the theConditionListClass
     */
    public ConditionList getTheConditionListClass() {
        return theConditionListClass;
    }

    /**
     * @return the theMapListClass
     */
    public MapList getTheMapListClass() {
        return theMapListClass;
    }

    /**
     * @return the theEventListClass
     */
    public EventList getTheEventListClass() {
        return theEventListClass;
    }

    /**
     * @return the theDialogListClass
     */
    public DialogList getTheDialogListClass() {
        return theDialogListClass;
    }

    /**
     * @return the theCreatureListClass
     */
    public CreatureList getTheCreatureListClass() {
        return theCreatureListClass;
    }
}
