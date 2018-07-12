/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

import java.io.*;

/**
 *
 * @author fitexmage
 */
public class Character implements Serializable, Cloneable {

    private String name; //游戏名
    private int race; //种族 1: 人类 2: 野兽
    private int hp; //生命
    private int maxHp; //最大生命
    private int mp; //魔法
    private int maxMp; //最大魔法
    private int str; //力量
    private int def; //防御
    private int intl; //智力
    private int agi; //敏捷

    private CombatInfo combatInfo; //战斗信息

    public Character(String name, int race, int hp, int maxHp, int mp, int maxMp, int str, int def, int intl, int agi) {
        this.name = name;
        this.race = race;
        this.hp = hp;
        this.maxHp = maxHp;
        this.mp = mp;
        this.maxMp = maxMp;
        this.str = str;
        this.def = def;
        this.intl = intl;
        this.agi = agi;
    }

    public Character() {

    }

    //新的角色
    public static Character getNewCharacter(String name, int role) {

        Character newCharacter;
        switch (role) {
            case 1:
                newCharacter = new Character(name, 1, 25, 25, 3, 3, 5, 5, 2, 3); //战士
                break;
            case 2:
                newCharacter = new Character(name, 1, 15, 15, 5, 5, 10, 3, 2, 8); //刺客
                break;
            case 3:
                newCharacter = new Character(name, 1, 15, 15, 10, 10, 2, 2, 10, 2); //法师
                break;
            default:
                newCharacter = null;
                break;
        }
        return newCharacter;
    }

    //攻击
    public String fight(Character target) {
        String record = ""; //战斗信息
        Skill usedSkill = SkillList.getTheSkill(combatInfo.getUsedSkillID()); //使用的技能
        for (SkillEffect theSkillEffect : usedSkill.getSkillEffectList()) {
            //该效果的目标
            Character tempTarget;
            if (theSkillEffect.getTarget() == 1) {
                tempTarget = target;
            } else {
                tempTarget = this;
            }

            int originalValue; //原本数值
            int realValue; //真实数值
            if (theSkillEffect.getAttributeTarget() == 1) { //攻击技能
                originalValue = (int) (ability(theSkillEffect.getAttributeBased()) * theSkillEffect.getValue());
                if (originalValue > tempTarget.def) {
                    realValue = originalValue - tempTarget.def;
                } else {
                    realValue = 1;
                }
                target.hp -= realValue;
                if (realValue > 0) {
                    record += "对" + tempTarget.name + "造成了" + realValue + "点伤害!\n";
                } else {
                    record += "为" + tempTarget.name + "恢复了" + realValue + "点血量!\n";
                }
            } 
            else { //降低能力技能
                originalValue = (int) (ability(theSkillEffect.getAttributeBased()) * theSkillEffect.getValue());
                int targetValue = tempTarget.ability(theSkillEffect.getAttributeTarget());
                if (originalValue >= targetValue) {
                    realValue = targetValue - 1;
                } else {
                    realValue = originalValue;
                }
                tempTarget.changeAbility(theSkillEffect.getAttributeTarget(), targetValue - realValue);
                if (realValue > 0) {
                    record += "使" + tempTarget.name + "的" + abilityName(theSkillEffect.getAttributeTarget()) + "下降了" + realValue + "!\n";
                } else {
                    record += "使" + tempTarget.name + "的" + abilityName(theSkillEffect.getAttributeTarget()) + "上升了" + realValue + "!\n";
                }
            }
        }
        return record;
    }

    //根据编号返回能力数值
    public int ability(int i) {
        if (i == 1) {
            return hp;
        } else if (i == 2) {
            return mp;
        } else if (i == 3) {
            return str;
        } else if (i == 4) {
            return def;
        } else if (i == 5) {
            return intl;
        } else if (i == 6) {
            return agi;
        }
        return 0;
    }

    //根据编号返回文字
    public String abilityName(int i) {
        if (i == 1) {
            return "生命值";
        } else if (i == 2) {
            return "魔法值";
        } else if (i == 3) {
            return "力量";
        } else if (i == 4) {
            return "防御";
        } else if (i == 5) {
            return "智力";
        } else if (i == 6) {
            return "敏捷";
        }
        return "";
    }

    //根据编号改变能力数值
    public void changeAbility(int i, int value) {
        if (i == 1) {
            hp = value;
        } else if (i == 2) {
            mp = value;
        } else if (i == 3) {
            str = value;
        } else if (i == 4) {
            def = value;
        } else if (i == 5) {
            intl = value;
        } else if (i == 6) {
            agi = value;
        }
    }

    //升级后能力提升
    public void levelUp(int role) {
        switch (role) {
            case 1:
                hp += 5;
                maxHp += 5;
                mp += 1;
                maxMp += 1;
                str += 2;
                def += 3;
                intl += 1;
                agi += 1;
                break;
            case 2:
                hp += 2;
                maxHp += 2;
                mp += 2;
                maxMp += 2;
                str += 5;
                def += 1;
                intl += 1;
                agi += 3;
                break;
            case 3:
                hp += 3;
                maxHp += 3;
                mp += 5;
                maxMp += 5;
                str += 1;
                def += 1;
                intl += 6;
                agi += 1;
                break;
        }
    }

    @Override
    public Object clone() {
        Character theCharacter = null;
        try {
            theCharacter = (Character) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return theCharacter;
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
     * @return the race
     */
    public int getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public void setRace(int race) {
        this.race = race;
    }

    /**
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * @param hp the hp to set
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * @return the maxHp
     */
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * @param maxHp the maxHp to set
     */
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    /**
     * @return the mp
     */
    public int getMp() {
        return mp;
    }

    /**
     * @param mp the mp to set
     */
    public void setMp(int mp) {
        this.mp = mp;
    }

    /**
     * @return the maxMp
     */
    public int getMaxMp() {
        return maxMp;
    }

    /**
     * @param maxMp the maxMp to set
     */
    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    /**
     * @return the str
     */
    public int getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(int str) {
        this.str = str;
    }

    /**
     * @return the def
     */
    public int getDef() {
        return def;
    }

    /**
     * @param def the def to set
     */
    public void setDef(int def) {
        this.def = def;
    }

    /**
     * @return the intl
     */
    public int getIntl() {
        return intl;
    }

    /**
     * @param intl the intl to set
     */
    public void setIntl(int intl) {
        this.intl = intl;
    }

    /**
     * @return the agi
     */
    public int getAgi() {
        return agi;
    }

    /**
     * @param agi the agi to set
     */
    public void setAgi(int agi) {
        this.agi = agi;
    }

    /**
     * @return the combatInfo
     */
    public CombatInfo getCombatInfo() {
        return combatInfo;
    }

    /**
     * @param combatInfo the combatInfo to set
     */
    public void setCombatInfo(CombatInfo combatInfo) {
        this.combatInfo = combatInfo;
    }
}
