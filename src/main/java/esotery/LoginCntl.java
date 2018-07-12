/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

/**
 *
 * @author fitexmage
 */
public class LoginCntl {

    private static LoginCntl theLoginCntl;
    private Stage theStage;

    public LoginCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/LoginUI.fxml"));
            Scene scene = new Scene(root);

            theStage.setTitle("埃索泰尔传奇");
            theStage.setScene(scene);
            theStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //验证
    public void authenticate(TextField username, TextField password, Text usernameAlert, Text passwordAlert, Text matchAlert) {

        boolean empty = false;
        usernameAlert.setText("");
        passwordAlert.setText("");
        matchAlert.setText("");

        //用户名为空
        if (username.getText().isEmpty()) {
            usernameAlert.setText("请输入用户名!");
            empty = true;
        }

        //密码为空
        if (password.getText().isEmpty()) {
            passwordAlert.setText("请输入密码!");
            empty = true;
        }

        if (empty == false) {
            int playerID = Data.getTheData().getTheAccountListClass().getID(username.getText(), password.getText()); //获取玩家ID
            if (playerID != -1) { //玩家已注册
                if (Data.getTheData().getTheAttributeListClass().getTheAttribute(playerID) == null) { //玩家还没有创建过角色
                    CreateCntl.getTheCreateCntl(theStage, playerID).setUpScene(); //进入创建角色界面
                } else { //玩家已经创建过角色
                    Player.setThePlayer(new Player(playerID)); //初始化个人信息
                    NavCntl.getTheNavCntl(theStage).setUpScene(); //进入导航界面
                }
            } else { //玩家未注册或用户名密码不匹配
                matchAlert.setText("用户名和密码不匹配,请再次尝试或注册!");
            }
        }
    }

    //进入注册界面
    public void getRegisterCntl() {
        RegisterCntl.getTheRegisterCntl(theStage).setUpScene();
    }

    /**
     * @return the theLoginCntl
     */
    public static LoginCntl getTheLoginCntl() {
        return theLoginCntl;
    }

    public static LoginCntl getTheLoginCntl(Stage theStage) {
        theLoginCntl = new LoginCntl(theStage);
        return theLoginCntl;
    }

    /**
     * @param aTheLoginCntl the theLoginCntl to set
     */
    public static void setTheLoginCntl(LoginCntl aTheLoginCntl) {
        theLoginCntl = aTheLoginCntl;
    }

    /**
     * @return the theStage
     */
    public Stage getTheStage() {
        return theStage;
    }

    /**
     * @param theStage the theStage to set
     */
    public void setTheStage(Stage theStage) {
        this.theStage = theStage;
    }
}
