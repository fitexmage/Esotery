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
public class AccountList{

    private ArrayList<Account> accountList; 
    final String accountFileName = "database/account.json";

    public AccountList() {
        readFile();
        //防止无文件可读导致的报错
        if (accountList == null) {
            accountList = new ArrayList<>();
        }
    }

    //读取
    private void readFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            accountList = mapper.readValue(new File(accountFileName), new TypeReference<ArrayList<Account>>() {
            });
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }
    
    //写入
    public void writeFile() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(accountFileName), accountList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //查找指定账号
    public Account getTheAccount(int thePlayerID) {
        for (Account theAccount : accountList) {
            if (theAccount.getPlayerID() == thePlayerID) {
                return theAccount;
            }
        }
        return null;
    }

    //更新指定账号
    public void updateTheAccount(int thePlayerID, Account newAccount) {
        for (Account theAccount : accountList) {
            if (theAccount.getPlayerID() == thePlayerID) {
                theAccount.update(newAccount);
            }
        }
    }

    //添加新的玩家
    public void addNewPlayer(String newUsername, String newPassWord) {
        accountList.add(new Account(newPlayerID(), newUsername, newPassWord));
    }

    //添加新的玩家ID
    public int newPlayerID() {
        return accountList.size() + 1;
    }

    //通过用户名得到ID,用于验证
    public int getID(String username) {
        for (Account theAccount : Data.getTheData().getTheAccountListClass().accountList) {
            if (theAccount.getUsername().equals(username)) {
                return theAccount.getPlayerID();
            }
        }
        return -1;
    }
    
    //通过用户名和密码得到ID,用于验证
    public int getID(String username, String password) {
        for (Account theAccount : Data.getTheData().getTheAccountListClass().accountList) {
            if (theAccount.getUsername().equals(username) && theAccount.getPassword().equals(password)) {
                return theAccount.getPlayerID();
            }
        }
        return -1;
    }
}
