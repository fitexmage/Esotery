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
        this.username = newAccount.username;
        this.password = newAccount.password;
    }

    /**
     * @return the playerID
     */
    public int getPlayerID() {
        return playerID;
    }

    /**
     * @param playerID the playerID to set
     */
    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
