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
public class Account {

    private int playerID; //玩家ID
    private String username; //用户名
    private String password; //密码

    public Account(int playerID, String username, String password) {
        this.playerID = playerID;
        this.username = username;
        this.password = password;
    }

    public Account() {

    }
    
    // 更新账号
    public void update(Account newAccount){
        username = newAccount.username;
        password = newAccount.password;
    }

    /**
     * @return the playerID
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}
