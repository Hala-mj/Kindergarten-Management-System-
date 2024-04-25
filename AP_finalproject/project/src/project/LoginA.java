/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 *
 * @author Lujain_Alhebshi, yasmeen
 */
public class LoginA extends Application {
    //Main method
      public static void main(String[] args) {
        launch(args);
    }
    //_______________________________________________________________
    //interface
    Color labels = Color.rgb(33, 59, 105);
    Color texts = Color.rgb(144, 171, 220);

    String Name;
    String Password;
    
    @Override
    public void start(Stage stage) {

        ///// background //////////////////////////////////////
        Image backgroundImage = new Image( "file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp Image 2024-01-11 at 17.43.59.jpeg");
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

        
        Image b = new Image ("file:C:\\Users\\yasom\\OneDrive\\المستندات\\AP\\project\\back.png");
        ImageView backiv = new ImageView (b);
        backiv.setFitWidth(40);
        backiv.setFitHeight(40);
        
        Button back = new Button ();
        back.setGraphic(backiv);
        back.setAlignment(Pos.TOP_RIGHT);
        back.setBackground(Background.EMPTY);
        back.setPadding(new Insets(20,0,0,20));
        
        HBox logoBox = new HBox(130);
        logoBox.getChildren().addAll(back,logoButton);
        logoBox.setAlignment(Pos.TOP_LEFT);
        logoBox.setPadding(new Insets(0, 0, 0, 0));
        ////End background
         ///// UI Controls ////////////////////////////////////////////////

        
        /// Label
        Label LoginT = new Label("Admin Log In");
        LoginT.setTextFill(labels);
        LoginT.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");
      
        Label usernameLabel = new Label("Username:");
        usernameLabel.setTextFill(Color.rgb(33, 59, 105));
        usernameLabel.setFont(Font.font("Comic Sans MS", 14));

        TextField usernameField = new TextField();

        Label passwordLabel = new Label("Password:");
        passwordLabel.setTextFill(Color.rgb(33, 59, 105));
        passwordLabel.setFont(Font.font("Comic Sans MS", 14));

        PasswordField passwordField = new PasswordField();

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");

        Label msg = new Label();
        msg.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        msg.setTextFill(Color.rgb(233, 110, 68));
    // Create layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll( LoginT,usernameLabel, usernameField, passwordLabel, passwordField,msg, loginButton);

        StackPane root = new StackPane(backgroundimageView, logoBox,layout);

        ////// Action/////// 
        LoginType l = new LoginType();
        back.setOnAction(e->{
            l.start(stage);
        });
        loginButton.setOnAction(eh->{
            msg.setText("");
            if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()){
                msg.setText("Plese fill the fields..");
            }
            else{
                Admin a = new Admin();
                if (a.checkLogin(usernameField.getText(),passwordField.getText())){
                    try {
                        a.start(stage);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                else {
                    msg.setText("username OR password is wrong!");
                }
            }
            /*
            if (file.exists())
            {
                 String Fname;
                 String Lname;
                long phoneNum ;
                 String task;
               while(in.hasNext()) {
                    if (in.next().equals(usernameField.getText())) {
                        in.next();
                        if (in.next().equals(passwordField.getText())) {
                            in.next();
                            Fname = in.next(); in.next();
                            Lname = in.next(); in.next();
//                            DOE = scanToLocalDate(in.next()); in.next();
//                            phoneNum = in.nextLong(); in.next();
                            task = in.nextLine();
                            Admin admin = new Admin (Fname, Lname, phoneNum, task);
                            System.out.println("admin: "+ admin.toString());
                        }
                        else{
                            msg.setText("username OR password is wrong!");
                        }
                    }
                }
            }
            else
            {
                System.out.println("Worning: the file is not exist!!");
                //  You can create your new file
            }*/
        });
        Scene scene = new Scene(root, 350, 600);
        stage.setTitle("SCIENCE GARDEN");
        stage.setScene(scene);
        stage.show();

    }
    LocalDate scanToLocalDate(String input) {
    try (Scanner scanner = new Scanner(input)) {
        String dateString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);
    }
}
}
