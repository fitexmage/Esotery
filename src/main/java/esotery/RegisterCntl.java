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
public class RegisterCntl {

    private Stage theStage;
    private static RegisterCntl theRegisterCntl;

    public RegisterCntl(Stage theExistingStage) {
        theStage = theExistingStage;
    }

    public void setUpScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/RegisterUI.fxml"));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUpRegisteredScene() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/RegisteredUI.fxml"));
            Scene scene = new Scene(root);
            theStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //添加玩家
    public void addPlayer(TextField username, TextField password, Text usernameAlert, Text passwordAlert, Text matchAlert) {
        //初始化
        boolean empty = false;
        usernameAlert.setText("");
        passwordAlert.setText("");
        matchAlert.setText("");

        if (username.getText().isEmpty()) { //用户名为空
            usernameAlert.setText("请输入用户名!");
            empty = true;
        }
        if (password.getText().isEmpty()) { //密码为空
            passwordAlert.setText("请输入密码!");
            empty = true;
        }
        if (empty == false) {
            int playerID = Data.getTheData().getTheAccountListClass().getID(username.getText()); //获取当前玩家ID
            if (playerID == -1) { //用户名不存在,用户未曾注册过
                Data.getTheData().getTheAccountListClass().addNewPlayer(username.getText(), password.getText()); //添加新的账号
                Data.getTheData().getTheAccountListClass().writeFile(); //写入数据库
                setUpRegisteredScene(); //进入注册成功界面
            } else { //用户名存在,用户已注册
                matchAlert.setText("用户名已存在,请尝试其他用户名!");
            }
        }

    }

    //进入登录界面
    public void back() {
        LoginCntl.getTheLoginCntl(theStage).setUpScene();
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

    /**
     * @return the theRegisterCntl
     */
    public static RegisterCntl getTheRegisterCntl() {
        return theRegisterCntl;
    }

    public static RegisterCntl getTheRegisterCntl(Stage theStage) {
        theRegisterCntl = new RegisterCntl(theStage);
        return theRegisterCntl;
    }

    /**
     * @param aTheRegisterCntl the theRegisterCntl to set
     */
    public static void setTheRegisterCntl(RegisterCntl aTheRegisterCntl) {
        theRegisterCntl = aTheRegisterCntl;
    }
}
