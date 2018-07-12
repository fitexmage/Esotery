/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

/**
 *
 * @author fitexmage
 */
public class Data {

    //初始化所有数据
    private static Data theData;
    
    private AccountList theAccountListClass;
    private AttributeList theAttributeListClass;
    private SkillList theSkillListClass;
    private ConditionList theConditionListClass;
    private MapList theMapListClass;
    private EventList theEventListClass;
    private DialogList theDialogListClass;
    private CreatureList theCreatureListClass;

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
     * @param theAccountListClass the theAccountListClass to set
     */
    public void setTheAccountListClass(AccountList theAccountListClass) {
        this.theAccountListClass = theAccountListClass;
    }

    /**
     * @return the theAttributeListClass
     */
    public AttributeList getTheAttributeListClass() {
        return theAttributeListClass;
    }

    /**
     * @param theAttributeListClass the theAttributeListClass to set
     */
    public void setTheAttributeListClass(AttributeList theAttributeListClass) {
        this.theAttributeListClass = theAttributeListClass;
    }

    /**
     * @return the theSkillListClass
     */
    public SkillList getTheSkillListClass() {
        return theSkillListClass;
    }

    /**
     * @param theSkillListClass the theSkillListClass to set
     */
    public void setTheSkillListClass(SkillList theSkillListClass) {
        this.theSkillListClass = theSkillListClass;
    }

    /**
     * @return the theConditionListClass
     */
    public ConditionList getTheConditionListClass() {
        return theConditionListClass;
    }

    /**
     * @param theConditionListClass the theConditionListClass to set
     */
    public void setTheConditionListClass(ConditionList theConditionListClass) {
        this.theConditionListClass = theConditionListClass;
    }

    /**
     * @return the theMapListClass
     */
    public MapList getTheMapListClass() {
        return theMapListClass;
    }

    /**
     * @param theMapListClass the theMapListClass to set
     */
    public void setTheMapListClass(MapList theMapListClass) {
        this.theMapListClass = theMapListClass;
    }

    /**
     * @return the theEventListClass
     */
    public EventList getTheEventListClass() {
        return theEventListClass;
    }

    /**
     * @param theEventListClass the theEventListClass to set
     */
    public void setTheEventListClass(EventList theEventListClass) {
        this.theEventListClass = theEventListClass;
    }

    /**
     * @return the theDialogListClass
     */
    public DialogList getTheDialogListClass() {
        return theDialogListClass;
    }

    /**
     * @param theDialogListClass the theDialogListClass to set
     */
    public void setTheDialogListClass(DialogList theDialogListClass) {
        this.theDialogListClass = theDialogListClass;
    }

    /**
     * @return the theCreatureListClass
     */
    public CreatureList getTheCreatureListClass() {
        return theCreatureListClass;
    }

    /**
     * @param theCreatureListClass the theCreatureListClass to set
     */
    public void setTheCreatureListClass(CreatureList theCreatureListClass) {
        this.theCreatureListClass = theCreatureListClass;
    }
}
