/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
//imports
import project.LoginType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


//______________________________________________________________________________
public class ProjectAP extends Application {
  
           //global vars
    Color labels= Color.rgb(33,59,105);
    Color texts= Color.rgb(144,171,220);
    Color orange= Color.rgb(233, 110, 68);
    //--------------------------------------------------------------------------
//    Main method
      public static void main(String[] args) {
        launch(args);
    }
    //--------------------------------------------------------------------------
    @Override
    public void start(Stage stage)  {
         //background image
        ImageView iVBackground = new ImageView(new Image( "file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp Image 2024-01-11 at 17.43.59.jpeg"));
        iVBackground.setFitWidth(350.0f); 
        iVBackground.setFitHeight(600.0f);
    //logo image
        ImageView iVLogo= new ImageView(new Image("file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp_Image_2024-01-11_at_17.31.38-removebg-preview.png"));
        iVLogo.setFitWidth(300.0f); 
        iVLogo.setFitHeight(300.0f);
        iVLogo.setLayoutX(50);
        iVLogo.setLayoutY(30);
     //______________________________________________________________________________        
    //Text
      Text tVision= new Text( 
              "     At science garden Kindergarten,our vision is to\n"
            + "     create a dynamic and nurturing learning community\n"
            + "     where every child is encouraged to explore, discover\n"
            + "     and develop a love for lifelong learning. \n\n"
            + "     We strive to foster a sense of wonder, creativity,\n"
            + "     and resilience, empowering each child to reach their\n"
            + "     full potential and become confident, andengaged\n"
            + "     global citizens.\n\n");
        tVision.setFill(labels);
        tVision.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.ITALIC, 12));
        /*-----------------------------------------*/
        Text tLogIn= new Text("Click on the scens to go to log in page.");
        tLogIn.setFont(Font.font("Comic Sans MS", FontWeight.EXTRA_LIGHT, FontPosture.REGULAR, 10));
        tLogIn.setFill(orange);       
        tLogIn.setX(200);
        tLogIn.setY(390);
//______________________________________________________________________________    
    //Panes
       VBox vBHome= new VBox();
        vBHome.getChildren().addAll(tVision,tLogIn); //iVLogo
        vBHome.setAlignment(Pos.CENTER);
        vBHome.setSpacing(20);
        vBHome.setLayoutX(3);
        vBHome.setLayoutY(290);
        Pane pane = new Pane(iVLogo,vBHome);//tVision,tLogIn  
         
        StackPane root =new StackPane();
        root.getChildren().addAll(iVBackground,pane);
      
//______________________________________________________________________________        
    //Display
        Scene scene = new Scene(root, 350, 600);
         //Events & Actions
         LoginType loginType= new LoginType();

        scene.setOnMouseClicked(e ->{
       
                loginType.start(stage);
           
        });
       stage.setTitle("SCIENCE GARDEN");
       stage.setScene(scene);
       stage.show();
    }
}