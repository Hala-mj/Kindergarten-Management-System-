/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//imports
import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import org.hibernate.*;
//______________________________________________________________________________


/**
 *
 * @author Lujain_Alhebshi
 */
public class Child extends Application {
  
    //global vars
    Color dark_blue= Color.rgb(33,59,105);
    Color light_blue= Color.rgb(144,171,220);
    Color orange= Color.rgb(233, 110, 68);
    String background = "file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp Image 2024-01-11 at 17.43.59.jpeg";
    String logo = "file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp_Image_2024-01-11_at_17.31.38-removebg-preview.png";
//----------------------------------------------------------------------
    // File path for students Child.txt file
    String filePath = "C:\\Users\\Lujain_Alhebshi\\Downloads\\Project Interfaces\\Child (2).txt";
    File Sfile = new File (filePath);
    //--------------------------------------------------------------------------
    private String Fname;
    private String Lname;
    private String gender;
    private String chID;
    private String DOB;
    private String allergies;
    private String ClassID;
    private String ClassName;
    private String nameG;
    private String relation;
    
//    private int intchID=()chID;
//    private Long NoGuardian;
    private String NoGuardian;
    private String STreatment;

    public Child() {
    }

    public Child(String Fname, String Lname, String gender, String chID, String DOB, String allergies, String ClassID, String ClassName, String nameG, String relation, String NoGuardian, String STreatment) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.gender = gender;
        this.chID = chID;
        this.DOB = DOB;
        this.allergies = allergies;
        this.ClassID = ClassID;
        this.ClassName = ClassName;
        this.nameG = nameG;
        this.relation = relation;
        this.NoGuardian = NoGuardian;
        this.STreatment = STreatment;
    }

    
    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getChID() {
        return chID;
    }

    public void setChID(String chID) {
        this.chID = chID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String ClassID) {
        this.ClassID = ClassID;
    }

    public String getNameG() {
        return nameG;
    }

    public void setNameG(String nameG) {
        this.nameG = nameG;
    }

    public String getNoGuardian() {
        return NoGuardian;
    }

    public void setNoGuardian(String NoGuardian) {
        this.NoGuardian = NoGuardian;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getSTreatment() {
        return STreatment;
    }

    public void setSTreatment(String STreatment) {
        this.STreatment = STreatment;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public String getDOB() {
        return DOB;
    }

    public String getClassName() {
        return ClassName;
    }
    
    public boolean checkLogin(String enteredUsername, String enteredPassword) {
    
    try {
        Scanner scanner = new Scanner(Sfile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+"); // data is separated by spaces

            if (parts.length >= 2) {
                String username = parts[0]; // the first term
                String password = parts[1]; // the second term

                if (enteredUsername.trim().replaceAll("[^a-zA-Z0-9]", "").equals(username)
                        && enteredPassword.trim().replaceAll("[^a-zA-Z0-9]", "").equals(password)) {
                    Assign(parts);
                    scanner.close();
                    return true;
                }
            }
        }

        scanner.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    return false;
}
 /*
    TextField chnameField = new TextField(Fname+" "+Lname);
    TextField chidField = new TextField(chID);
    TextField chGenderField = new TextField(gender);
    TextField chclassIdField = new TextField(ClassName);
    TextField chphoneField = new TextField(NoGuardian.toString());
    TextField nameOfGuardianField = new TextField(nameG);
    TextField specialTreatmentField = new TextField(STreatment);
    TextField chAllergiesField = new TextField(allergies);
    TextField chRelationGuardianField = new TextField(relation);
    */
   
    public boolean Assign (String[] parts){
        this.Fname = parts[2];
        this.Lname = parts[3];
        this.gender = parts[4];
        this.chID =parts[5];
        this.DOB = parts[6];
        this.allergies = parts[7];
        this.ClassID = parts[8];
        this.ClassName = parts [9];
        this.nameG = parts[10];
        this.relation = parts[11];
        
//        this.NoGuardian = Long.parseLong(parts[12]);
        this.NoGuardian = parts[12];
        String s = "" ;
        for (int i = 13; i < parts.length; i++) {
            String item = parts[i];
            s = s+" " + item;
        }
        this.STreatment = s;
        //this.intchID= Integer.valueOf(this.chID);
        System.out.println("f: "+Fname+" L: "+ Lname+" g:" +gender+" ID: "+ chID+"   ");
        return true;
    }
   
    
    //--------------------------------------------------------------------------
    //Main method
      public static void main(String[] args) {
        launch(args);
    }
    //--------------------------------------------------------------------------
    @Override
    public void start(Stage stage) throws Exception {
    //background 
    Image chbackground = new Image(background);
    Image chlogo = new Image(logo);
        ImageView chbckgrndImageView = new ImageView(chbackground);
        chbckgrndImageView.setFitWidth(370.0f); 
        chbckgrndImageView.setFitHeight(600.0f); 
        /*-----------------------------------------*/
        ImageView chlogoImageView = new ImageView(chlogo);
        chlogoImageView.setFitWidth(150.0f); //100
        chlogoImageView.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button chlogoButton = new Button();
        chlogoButton.setGraphic(chlogoImageView);
        chlogoButton.setPrefWidth(100);
        chlogoButton.setPrefHeight(100);
        chlogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox chlogoBox= new HBox();
        chlogoBox.getChildren().add(chlogoButton);
        chlogoBox.setAlignment(Pos.TOP_LEFT);
        chlogoBox.setPadding(new Insets(0, 0, 0, 0)); //top,left,bottom,right
    //--------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////   
    //chikd Scene components
    //To whom does the interface belong (Text)
        Text lchild = new Text("student");
        lchild.setX(130);
        lchild.setY(200);
        lchild.setFill(dark_blue);
        lchild.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");
        //__________________________________________________________________________    
        //Buttons
        Button bChildInfoo = new Button("Information");
        bChildInfoo.setPrefWidth(200);
        bChildInfoo.setPrefHeight(30);
        bChildInfoo.setTextFill(light_blue);
        bChildInfoo.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
        /*-----------------------------------------*/
        Button bChildTasks = new Button("Child tasks");
        bChildTasks.setPrefWidth(200);
        bChildTasks.setPrefHeight(30);
        bChildTasks.setTextFill(light_blue);
        bChildTasks.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
        /*-----------------------------------------*/
        Button bChildBehavior = new Button("child Behavior");
        bChildBehavior.setPrefWidth(200);
        bChildBehavior.setPrefHeight(30);
        bChildBehavior.setTextFill(light_blue);
        bChildBehavior.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
        /*-----------------------------------------*/
//        Button bChildAttendance = new Button(" presence and absence");
//        bChildAttendance.setPrefWidth(200);
//        bChildAttendance.setPrefHeight(30);
//        bChildAttendance.setTextFill(light_blue);
//        bChildAttendance.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
//
//        /*-----------------------------------------*/
//        Button bChildActivities = new Button("The Child Activities");//
//        bChildActivities.setPrefWidth(200);
//        bChildActivities.setPrefHeight(30);
//        bChildActivities.setTextFill(light_blue);
//        bChildActivities.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");

//    employmentRecordBt.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
//--------------------------------------------------------------------------
//        Button bChildFees = new Button("The Child Fees");
//        bChildFees.setPrefWidth(200);
//        bChildFees.setPrefHeight(30);
//        bChildFees.setTextFill(light_blue);
//        bChildFees.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
//        //--------------------------------------------------------------------------
        //VBox to arrange the buttons in one column
        VBox BtnsInfo = new VBox();
        BtnsInfo.getChildren().addAll(bChildInfoo, bChildTasks, bChildBehavior); ///////////////////////////////////////////////,bChildAttendance, bChildActivities,bChildFees
        BtnsInfo.setAlignment(Pos.CENTER);
        BtnsInfo.setLayoutX(80);
        BtnsInfo.setLayoutY(230);
        BtnsInfo.setSpacing(7);
        //--------------------------------------------------------------------------  
    //Panes
         Pane pane1 = new Pane(lchild, BtnsInfo); //imageView
        StackPane a = new StackPane();
        a.getChildren().addAll(chbckgrndImageView, chlogoBox,pane1);
        //----------------------------------------------
    //Display
        Scene childScene = new Scene(a, 350, 600);
        stage.setScene(childScene);
        stage.setTitle("SCIENCE GARDEN");
        stage.show();
        
        //////////////////////////////////////////////////////////////////////////////
    //child personal info Scene components   
    //background
    Image chinfobackground = new Image(background);
    Image chinfologo = new Image(logo);
        ImageView chinfobckgrnd = new ImageView(chinfobackground);
        chinfobckgrnd.setFitWidth(370.0f); 
        chinfobckgrnd.setFitHeight(600.0f);
        /*-----------------------------------------*/
        ImageView chinfoLogo = new ImageView(chinfologo);
        chinfoLogo.setFitWidth(150.0f);
        chinfoLogo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button chinfoLogoButton = new Button();
        chinfoLogoButton.setGraphic(chinfoLogo);
        chinfoLogoButton.setPrefWidth(100);
        chinfoLogoButton.setPrefHeight(100);
        chinfoLogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox chinfoLogoBox= new HBox();
        chinfoLogoBox.getChildren().add(chinfoLogoButton);
        chinfoLogoBox.setAlignment(Pos.TOP_LEFT);
        chinfoLogoBox.setPadding(new Insets(0, 0, 0, 0));
    //-------------------------------------------------------------------------- 
           //Labels
    Label chInfo = new Label("Information");
    chInfo.setTextFill(dark_blue);
    chInfo.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");

    Label chnameLabel = new Label("Name:");
    chnameLabel.setFont(Font.font("Comic Sans MS", 14));
    chnameLabel.setTextFill(dark_blue);

    Label chidLabel = new Label("Child ID:");
    chidLabel.setFont(Font.font("Comic Sans MS", 14));
    chidLabel.setTextFill(dark_blue);

    Label chGender = new Label("Gender:");
    chGender.setFont(Font.font("Comic Sans MS", 14));
    chGender.setTextFill(dark_blue);

    Label chclassIdLabel = new Label("Class :");
    chclassIdLabel.setFont(Font.font("Comic Sans MS", 14));
    chclassIdLabel.setTextFill(dark_blue);

    Label chphoneLabel = new Label("Guardian Number:");
    chphoneLabel.setFont(Font.font("Comic Sans MS", 14));
    chphoneLabel.setTextFill(dark_blue);

    Label nameOfGuardianLabel = new Label("Name Of Guardian:");
    nameOfGuardianLabel.setFont(Font.font("Comic Sans MS", 14));
    nameOfGuardianLabel.setTextFill(dark_blue);

    Label specialTreatmentLabel = new Label("Special Treatment:");
    specialTreatmentLabel.setFont(Font.font("Comic Sans MS", 14));
    specialTreatmentLabel.setTextFill(dark_blue);

    Label chAllergiesLabel = new Label("Allergies:");
    chAllergiesLabel.setFont(Font.font("Comic Sans MS", 14));
    chAllergiesLabel.setTextFill(dark_blue);

    Label chRelationGuardianLabel = new Label("Relation:");
    chRelationGuardianLabel.setFont(Font.font("Comic Sans MS", 14));
    chRelationGuardianLabel.setTextFill(dark_blue);
   
    // TextFields
    TextField chnameField = new TextField(Fname+" "+Lname);
    chnameField.setEditable(false);
    TextField chidField = new TextField(chID);
    chidField.setEditable(false);
    TextField chGenderField = new TextField(gender);
    chGenderField.setEditable(false);
    TextField chclassIdField = new TextField(ClassName);
    chclassIdField.setEditable(false);
    TextField chphoneField = new TextField(NoGuardian.toString());
    chphoneField.setEditable(false);
    TextField nameOfGuardianField = new TextField(nameG);
    nameOfGuardianField.setEditable(false);
    TextField specialTreatmentField = new TextField(STreatment);
    specialTreatmentField.setEditable(false);
    TextField chAllergiesField = new TextField(allergies);
    chAllergiesField.setEditable(false);
    TextField chRelationGuardianField = new TextField(relation);
    chRelationGuardianField.setEditable(false);

    chnameField.setBackground(Background.EMPTY);
    chidField.setBackground(Background.EMPTY);
    chGenderField.setBackground(Background.EMPTY);
    chclassIdField.setBackground(Background.EMPTY);
    chphoneField.setBackground(Background.EMPTY);
    nameOfGuardianField.setBackground(Background.EMPTY);
    specialTreatmentField.setBackground(Background.EMPTY);
    chAllergiesField.setBackground(Background.EMPTY);
    chRelationGuardianField.setBackground(Background.EMPTY);

    // Add TextFields to the gridPane
    
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(20, 20, 20, 20));
    gridPane.setVgap(25);
    gridPane.setHgap(10);
    
    gridPane.add(chnameLabel, 0, 0);
    gridPane.add(chnameField, 1, 0);

    gridPane.add(chidLabel, 0, 1);
    gridPane.add(chidField, 1, 1);

    gridPane.add(chGender, 0, 2);
    gridPane.add(chGenderField, 1, 2);

    gridPane.add(chclassIdLabel, 0, 3);
    gridPane.add(chclassIdField, 1, 3);

    gridPane.add(nameOfGuardianLabel, 0, 4);
    gridPane.add(nameOfGuardianField, 1, 4);

    gridPane.add(chphoneLabel, 0, 5);
    gridPane.add(chphoneField, 1, 5);

    gridPane.add(chRelationGuardianLabel, 0, 6);
    gridPane.add(chRelationGuardianField, 1, 6);

    gridPane.add(chAllergiesLabel, 0, 7);
    gridPane.add(chAllergiesField, 1, 7);

    gridPane.add(specialTreatmentLabel, 0, 8);
    gridPane.add(specialTreatmentField, 1, 8);


    /*-----------------------------------------*/ 
    HBox TeacherInfoHBox = new HBox(chInfo);
    TeacherInfoHBox.setAlignment(Pos.CENTER);
    /*-----------------------------------------*/ 
    VBox layout1 = new VBox(20);
    layout1.getChildren().addAll(TeacherInfoHBox,gridPane);
    layout1.setAlignment(Pos.CENTER);
    layout1.setPadding(new Insets(50, 20, 20, 20));
    /*-----------------------------------------*/ 
    StackPane TinfoRoot = new StackPane(chinfobckgrnd,chinfoLogoBox,layout1);
    //--------------------------------------------------------------------------
    //Display
    Scene childInfoScene = new Scene(TinfoRoot, 370, 600);
    //////////////////////////////////////////////////////////////////////////////
//StudentTask Scene components
//background
    Image chtaskBackground = new Image(background);
    Image chtaskLogo = new Image(logo);
        ImageView chTaskBckgrnd = new ImageView(chtaskBackground);
        chTaskBckgrnd.setFitWidth(370.0f); 
        chTaskBckgrnd.setFitHeight(600.0f);
        /*-----------------------------------------*/
        ImageView chTaskLogo = new ImageView(chtaskLogo);
        chTaskLogo.setFitWidth(150.0f);
        chTaskLogo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button chTaskLogoButton = new Button();
        chTaskLogoButton.setGraphic(chTaskLogo);
        chTaskLogoButton.setPrefWidth(100);
        chTaskLogoButton.setPrefHeight(100);
        chTaskLogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox chTaskLogoBox= new HBox();
        chTaskLogoBox.getChildren().add(chTaskLogoButton);
        chTaskLogoBox.setAlignment(Pos.TOP_LEFT);
        chTaskLogoBox.setPadding(new Insets(0, 0, 0, 0));
        //Page Title
    Label chtaskPageTitle= new Label("Students tasks");
    chtaskPageTitle.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 30px;");
    chtaskPageTitle.setTextFill(dark_blue);
    /********/
    HBox chtitleBox= new HBox();
    chtitleBox.getChildren().add(chtaskPageTitle);
    chtitleBox.setAlignment(Pos.BOTTOM_CENTER);
    chtitleBox.setPadding(new Insets(120, 0, 0, 0)); //top,right,bottom,left
    /*-----------------------------------------*/
    //1st row: Task title
    Label chtaskTitleLabel= new Label("Title: ");
    chtaskTitleLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
    chtaskTitleLabel.setTextFill(dark_blue);
    /********/
    Label fillTaskTitleLabel= new Label("");
    fillTaskTitleLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
    fillTaskTitleLabel.setTextFill(orange);
    //pane for the whole row
    HBox chtaskTitleUIs= new HBox(30);
    chtaskTitleUIs.getChildren().addAll(chtaskTitleLabel,fillTaskTitleLabel);
    chtaskTitleUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
    /*-----------------------------------------*/
    //2nd row: The task is for which subject
    Label chsubjectLabel= new Label("Subject: ");
    chsubjectLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
    chsubjectLabel.setTextFill(dark_blue);
    /********/
    Label fillchsubjectLabel= new Label("");
    fillchsubjectLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
    fillchsubjectLabel.setTextFill(orange);
    //pane for the whole row
    HBox chsubjectUIs= new HBox(10);
    chsubjectUIs.getChildren().addAll(chsubjectLabel,fillchsubjectLabel);
    chsubjectUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
    /*-----------------------------------------*/
    //3d row: The type of the task/ Targetted skill
    Label chtaskTypeLabel= new Label("Target\nskill: ");
    chtaskTypeLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
    chtaskTypeLabel.setTextFill(dark_blue);
    /********/
   Label fillchtaskTypeLabel= new Label("");
    fillchtaskTypeLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
    fillchtaskTypeLabel.setTextFill(orange);
     //pane for the whole row
    HBox chtaskTypetUIs= new HBox(27);
    chtaskTypetUIs.getChildren().addAll(chtaskTypeLabel,fillchtaskTypeLabel);
    chtaskTypetUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
    /*-----------------------------------------*/
    //4th row: The task itself
    Label chtaskLabel= new Label("Task: ");
    chtaskLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
    chtaskLabel.setTextFill(dark_blue);
    /********/
     //4th row: The task itself
    Label fillchtaskLabel= new Label("");
    fillchtaskLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
    fillchtaskLabel.setTextFill(orange);
    /********/
//pane for the whole row
    HBox chtaskUIs= new HBox(27);
    chtaskUIs.getChildren().addAll(chtaskLabel,fillchtaskLabel);
    chtaskUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
    /*-----------------------------------------*/
    ///////disblay /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Session session = HibernateUtil.getSessionFactory().openSession();
    
    String cleanedChID = chID.replaceAll("\\P{Print}", ""); // Remove non-printable characters
    
    int studentId;
    try {
        studentId = Integer.parseInt(cleanedChID); // Convert chID to int
    } catch (NumberFormatException e) {
        System.out.println("Invalid student ID: " + cleanedChID);
        return;
    }
    
    Task result = (Task)session.get(Task.class, studentId);

    session.close();

    if (result != null) {
        System.out.println("Student found: " + result.getSub() + " " + result.getTarget());
        fillchsubjectLabel.setText(result.getSub());
        fillchtaskTypeLabel.setText(result.getTarget());
        fillchtaskLabel.setText(result.getTasks());
        fillTaskTitleLabel.setText(result.getTitle());
    } else {
        System.out.println("No student found with ID: " + studentId);
    }

     
    //--------------------------------------------------------------------------       
    //panes
    VBox chtasksVBox= new VBox(5);
    chtasksVBox.getChildren().addAll(chtaskTitleUIs,chsubjectUIs,chtaskTypetUIs,chtaskUIs);
    chtasksVBox.setAlignment(Pos.CENTER);
    chtasksVBox.setPadding(new Insets(0, 0, 0, 45)); //top,right,bottom,left
    /********/
    BorderPane chpane= new BorderPane();
    chpane.setCenter(chtasksVBox);
    
    chpane.setTop(chtitleBox);
    //Pane pane = new Pane(tasksVBox);
    /********/
    StackPane root= new StackPane();
    root.getChildren().addAll(chTaskBckgrnd, chTaskLogoBox,chpane);
    //--------------------------------------------------------------------------
    //Display
    Scene chTaskScene = new Scene(root, 370, 600);
    
    ////////////////////////////////////////////////////////////////////////////////
    //Students behavior Scene components
    //background 
    Image chBebahvBackground = new Image(background);
    Image chBebahvLogo = new Image(logo);
        ImageView chBehavBckgrnd= new ImageView(chBebahvBackground);
        chBehavBckgrnd.setFitWidth(370.0f); 
        chBehavBckgrnd.setFitHeight(600.0f); 
        /*-----------------------------------------*/
        ImageView chBehavBckLogo = new ImageView(chBebahvLogo);
        chBehavBckLogo.setFitWidth(150.0f); //100
        chBehavBckLogo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button chBehavLogoButton = new Button();
        chBehavLogoButton.setGraphic(chBehavBckLogo);
        chBehavLogoButton.setPrefWidth(100);
        chBehavLogoButton.setPrefHeight(100);
        chBehavLogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox chBehavLogoBox= new HBox();
        chBehavLogoBox.getChildren().add(chBehavLogoButton);
        chBehavLogoBox.setAlignment(Pos.TOP_LEFT);
        chBehavLogoBox.setPadding(new Insets(0, 0, 0, 0)); //top,right,bottom,left    
    //--------------------------------------------------------------------------
    //Page Title
        Label chbehavPageTitle= new Label("Student behavior");
        chbehavPageTitle.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 30px;");
        chbehavPageTitle.setTextFill(dark_blue);
        /********/
        HBox chbehavTitleBox= new HBox();
        chbehavTitleBox.getChildren().add(chbehavPageTitle);
        chbehavTitleBox.setAlignment(Pos.BOTTOM_CENTER);
        chbehavTitleBox.setPadding(new Insets(120, 0, 0, 0)); //top,right,bottom,left
    //--------------------------------------------------------------------------
   
    //1nd row: Day
        Label chdayLabel= new Label("Day: ");
        chdayLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        chdayLabel.setTextFill(dark_blue);
        /********/
        Label fillchdayLabel= new Label("");
        fillchdayLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        fillchdayLabel.setTextFill(orange);
        //pane for the whole row
        HBox chdayUIs= new HBox(45);
        chdayUIs.getChildren().addAll(chdayLabel,fillchdayLabel);
        chdayUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
        //2d row: Date
        Label chdateLabel= new Label("Date: ");
        chdateLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        chdateLabel.setTextFill(dark_blue);
        /********/
        Label fillchdateLabel= new Label("");
        fillchdateLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        fillchdateLabel.setTextFill(orange);
        //pane for the whole row
        HBox chdateUIs= new HBox(37);
        chdateUIs.getChildren().addAll(chdateLabel,fillchdateLabel);
        chdateUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
    //3th row: Behavior
    Label chBehavLabel= new Label("Student behavior: ");
        chBehavLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        chBehavLabel.setTextFill(dark_blue);
        /****BEHAVIORS****/
        Label chbehav1= new Label("Respect\nothers");
        chbehav1.setTextFill(light_blue);
        //_____
        Label fillchbehav1= new Label("");
        fillchbehav1.setTextFill(orange);
         /********/
        Label chbehav2= new Label("Active");
        chbehav2.setTextFill(light_blue);
         //_____
        Label fillchbehav2= new Label("");
        fillchbehav2.setTextFill(orange);
        /********/
        Label chbehav3= new Label("Focus");
        chbehav3.setTextFill(light_blue);
        //_____
        Label fillchbehav3= new Label("");
        fillchbehav3.setTextFill(orange);
        /********/
        Label chbehav4= new Label("Collaborate\nwith classmates");
        chbehav4.setTextFill(light_blue);
        //_____
        Label fillchbehav4= new Label("");
        fillchbehav4.setTextFill(orange);
          session = HibernateUtil.getSessionFactory().openSession();

String studentName = this.Fname;//////////////////////////////////////////////////////////////////
Behavior result1=(Behavior)session.get(Behavior.class, studentName);
session.close();
        if (result1 != null) {
    System.out.println("Student found: " + result1.getDay() + " " + result1.getDate());
    fillchdayLabel.setText( result1.getDay());
    fillchdateLabel.setText( result1.getDate());
    fillchbehav1.setText( ""+result1.getRespect());
    fillchbehav2.setText( ""+result1.getActive());
    fillchbehav3.setText( ""+result1.getFocus());
    fillchbehav4.setText( ""+result1.getCollaboration());
    
    
} else {
    System.out.println("No student found with ID: " + studentName);
}
        //GridPane for behaviors & checkboxes
        GridPane lblsANDchk= new GridPane();
        lblsANDchk.setVgap(15);
        lblsANDchk.setHgap(10);
        lblsANDchk.setMaxSize(310, 200);
        //1st column
        lblsANDchk.add(chbehav1, 0, 0); //node,column,row
        lblsANDchk.add(chbehav2, 0, 1);
        lblsANDchk.add(chbehav3, 0, 2);
        lblsANDchk.add(chbehav4, 0, 3);
        //2nd column
        lblsANDchk.add(fillchbehav1, 1, 0); //node,column,row
        lblsANDchk.add(fillchbehav2, 1, 1);
        lblsANDchk.add(fillchbehav3, 1, 2);
        lblsANDchk.add(fillchbehav4, 1, 3);
        //pane for the whole row
        HBox chbehavUIs= new HBox(13);
        chbehavUIs.getChildren().addAll(chBehavLabel,lblsANDchk);
        //panes
        /*VBox for all the rows (all "pane for the whole row")*/
        VBox studentBehavVBox= new VBox(5);
        studentBehavVBox.getChildren().addAll(chdayUIs,chdateUIs,chbehavUIs);
        studentBehavVBox.setAlignment(Pos.CENTER);
        studentBehavVBox.setPadding(new Insets(0, 0, 0, 30)); //top,right,bottom,left
        /********/
        BorderPane stBehavPane= new BorderPane();
        stBehavPane.setCenter(studentBehavVBox);
        stBehavPane.setTop(chbehavTitleBox);
       
        //pane.setBottom(publishBtnBox);
        StackPane stTaskRoot= new StackPane();
        stTaskRoot.getChildren().addAll(chBehavBckgrnd,chBehavLogoBox,stBehavPane);
    //--------------------------------------------------------------------------
    //Display
    Scene chBeahvScene = new Scene(stTaskRoot, 370, 600);
////////////////////////////////////////////////////////////////////////////////
//    Actions  
     bChildInfoo.setOnAction(e -> {
        stage.setScene(childInfoScene);
        stage.setTitle("Teacher Information");
    });
    
    bChildTasks.setOnAction(e -> {
           stage.setScene(chTaskScene);
           stage.setTitle("Students Tasks");
    });    
    
     bChildBehavior.setOnAction(e -> {
        stage.setScene(chBeahvScene);
        stage.setTitle("Students Tasks");
    });

     /*-----------------------------------------*/
    childInfoScene.setOnKeyPressed(e->{
        if(e.getCode()== KeyCode.LEFT){
            stage.setScene(childScene);
        }
    });
    
    chTaskScene.setOnKeyPressed(e->{
        if(e.getCode()== KeyCode.LEFT){
            stage.setScene(childScene);
        }
    }); 
    
    chBeahvScene.setOnKeyPressed(e->{
        if(e.getCode()== KeyCode.LEFT){
            stage.setScene(childScene);
        }
    });
                
    

////////////////////////////////////////////////////////////////////////////////


    //______________________________________________________________________________        
        // Display
   
    }
}//EndOfClass