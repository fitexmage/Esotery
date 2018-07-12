/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esotery;

import esotery.controller.LoginCntl;
import esotery.model.Player;
import esotery.model.Data;
import javafx.application.Application;
import javafx.event.*;
import javafx.stage.*;

/**
 *
 * @author fitexmage
 */
public class Esotery extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //初始化数据
        Data.setTheData(new Data());
        
        //进入登录界面
        LoginCntl.getTheLoginCntl(stage).setUpScene();

        //关闭后保存
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (Player.getThePlayer() != null) {  //角色已登录
                    Data.getTheData().getTheAccountListClass().writeFile();
                    Data.getTheData().getTheAttributeListClass().writeFile();
                    Data.getTheData().getTheSkillListClass().writeFile();
                    Data.getTheData().getTheConditionListClass().writeFile();
                    System.out.println("保存成功!");
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
