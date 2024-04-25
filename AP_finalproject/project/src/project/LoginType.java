/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import project.LoginA;
import project.LoginS;
import project.LoginT;

/**
 *
 * @author Lujain_Alhebshi
 */
public class LoginType extends Application {

   //_______________________________________________________________
    //interface
    Color labels = Color.rgb(33, 59, 105);
    Color texts = Color.rgb(144, 171, 220);

    @Override
    public void start(Stage stage) {

        ///// background //////////////////////////////////////
        Image backgroundImage = new Image("file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp Image 2024-01-11 at 17.43.59.jpeg");
        ImageView backgroundimageView = new ImageView(backgroundImage);
        backgroundimageView.setFitWidth(350.0f);
        backgroundimageView.setFitHeight(600.0f);

        Image logo = new Image("file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp_Image_2024-01-11_at_17.31.38-removebg-preview.png");
        ImageView logoImageView = new ImageView(logo);
        logoImageView.setFitWidth(150.0f);
        logoImageView.setFitHeight(130.0f);

        Button logoButton = new Button();
        logoButton.setGraphic(logoImageView);
        logoButton.setPrefWidth(100);
        logoButton.setPrefHeight(100);
        logoButton.setBackground(Background.EMPTY);

        HBox logoBox = new HBox();
        logoBox.getChildren().add(logoButton);
        logoBox.setAlignment(Pos.TOP_LEFT);
        logoBox.setPadding(new Insets(0, 0, 0, 0));
        ////End background
        ///// UI Controls ////////////////////////////////////////////////

        /// Label
        Label LoginLB = new Label("Log in");
        LoginLB.setTextFill(labels);
        LoginLB.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");
        /// RadioButton
        ToggleGroup userTypeToggleGroup = new ToggleGroup();
        RadioButton adminRadioButton = new RadioButton("Admin");
        adminRadioButton.setTextFill(texts);
        adminRadioButton.setToggleGroup(userTypeToggleGroup);

        RadioButton teacherRadioButton = new RadioButton("Teacher");
        teacherRadioButton.setTextFill(texts);
        teacherRadioButton.setToggleGroup(userTypeToggleGroup);

        RadioButton studentRadioButton = new RadioButton("Student");
        studentRadioButton.setTextFill(texts);
        studentRadioButton.setToggleGroup(userTypeToggleGroup);
        ///// panes /////////////////////////////////////////////// 

        VBox Radiobutton = new VBox(20);
        Radiobutton.setAlignment(Pos.CENTER_LEFT);
        Radiobutton.getChildren().addAll(adminRadioButton, teacherRadioButton, studentRadioButton);

        VBox ButtonsVBox = new VBox(20);
        ButtonsVBox.getChildren().add(Radiobutton);
        ButtonsVBox.setPadding(new Insets(20, 20, 20, 20));
        ButtonsVBox.setAlignment(Pos.CENTER);

        VBox Loginlayout = new VBox(10);
        Loginlayout.setPadding(new Insets(20, 20, 20, 20));
        Loginlayout.getChildren().add(ButtonsVBox);

        VBox layout1 = new VBox(LoginLB, Loginlayout);
        layout1.setAlignment(Pos.CENTER);

        StackPane root = new StackPane(backgroundimageView, logoBox, layout1);

        ///// Actions ////////////////////////////////////////////////////////////////
        adminRadioButton.setOnAction(event1 ->{
            if (adminRadioButton.isSelected()){
                LoginA Logina=new LoginA();
                Logina.start(stage);
            }
        });
        teacherRadioButton.setOnAction(event1 ->{
            if (teacherRadioButton.isSelected()){
                LoginT loginT = new LoginT();
                loginT.start(stage);
            }
        });
        studentRadioButton.setOnAction(event1 ->{
            if (studentRadioButton.isSelected()){
                LoginS Logins=new LoginS();
                Logins.start(stage);
            }
        });
        
        
        
        Scene scene = new Scene(root, 350, 600);
        stage.setTitle("SCIENCE GARDEN");
        stage.setScene(scene);
        stage.show();
  
        ///// Actions ////////////////////////////////////////////////////////////////
    }
    
    private void handleLogin(String username, String password) {
        // For demonstration purposes, using a simple hardcoded username and password
        String correctUsername = "user";
        String correctPassword = "pass";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Login successful!");
            // You can navigate to another scene or perform other actions upon successful login
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }
}

