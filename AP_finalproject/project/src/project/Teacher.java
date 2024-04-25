/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
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
import org.hibernate.Transaction;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.hibernate.*;

/**
 *
 * @author Lujain_Alhebshi
 */
public class Teacher extends Application {
    //--------------------------------------------------------------------------
    //Main method
      public static void main(String[] args) {
    
        launch(args);
    }
    //global vars

    Color dark_blue = Color.rgb(33, 59, 105);
    Color light_blue = Color.rgb(144, 171, 220);
    Color orange = Color.rgb(233, 110, 68);
    String background = "file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp Image 2024-01-11 at 17.43.59.jpeg";
    String logo = "file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp_Image_2024-01-11_at_17.31.38-removebg-preview.png";
    Number vbehav1Slider,vbehav2Slider,vbehav3Slider,vbehav4Slider;
    int intValue1,intValue2,intValue3,intValue4;

    //--------------------------------------------------------------------------
    private String Fname;
    private String Lname;
    private String tID;
    private String DOE;
    private String cID;
    private String ClassName;
    private long phoneNum;
    
    // File path for teacher Teacher.txt file
    String filePath = "C:\\Users\\Lujain_Alhebshi\\Downloads\\Project Interfaces\\Teacher.txt";
    File Tfile = new File (filePath);
    // the children file to fill combobox
    String ChildFilePath = "C:\\Users\\Lujain_Alhebshi\\Downloads\\Project Interfaces\\Child.java";
    File Childfile = new File (ChildFilePath);

    public Teacher() {
    }
    
    
    public Teacher(String Fname, String Lname, String tID, String DOE, String ClassName, long phoneNum) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.tID = tID;
        this.DOE = DOE;
        this.ClassName = ClassName;
        this.phoneNum = phoneNum;
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

    public String gettID() {
        return tID;
    }

    public void settID(String tID) {
        this.tID = tID;
    }

    public String getDOE() {
        return DOE;
    }

    public void setDOE(String DOE) {
        this.DOE = DOE;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String ClassName) {
        this.ClassName = ClassName;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    /**
     *
     * @param enteredUsername
     * @param enteredPassword
     * @return
     */
    public boolean TcheckLogin(String enteredUsername, String enteredPassword) {

    try {
        Scanner scan = new Scanner(Tfile);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split("\\s+"); // data is separated by spaces

            if (parts.length >= 2) {
                String username = parts[0]; // the first term
                String password = parts[1]; // the second term
                
                if (enteredUsername.trim().replaceAll("[^a-zA-Z0-9]", "").equals(username)
                        && enteredPassword.trim().replaceAll("[^a-zA-Z0-9]", "").equals(password)) {
                    Assign(parts);
                    scan.close();
                    return true;
                }
            }
        }

        scan.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    return false;
    }
    
    public boolean Assign (String[] parts){
        this.Fname = parts[2];
        this.Lname = parts[3];
        this.tID = parts[4];
        this.DOE = parts[5];
        this.cID = parts[6];
        this.ClassName = parts[7];
        this.phoneNum = Long.valueOf(parts[8]);        

//        System.out.println("f: "+Fname+" L: "+ Lname+" I:"+tID+" n:" +phoneNum+" c:"+ ClassName);
        return true;
    }
    
    public ArrayList <String> getClassStudents (int tClassID){
        ArrayList<String> students = new ArrayList<String>(10) ;
        try {
            Scanner in = new Scanner (Childfile);
            for (int i = 0; in.hasNextLine(); i++){
                String ln = in.nextLine();
                String[] parts = ln.split("\\s+"); // because data separated by spaces
                 if (parts.length >2){
                     String ClassID = parts[8]; 
                     if(ClassID.equals(this.cID)){
                        students.add(parts[2]);
                     }       
                 }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return students;
    }
    
    public ArrayList <String> getClassIDs (int tClassID){
        ArrayList<String> students = new ArrayList<String>(10) ;
        try {
            Scanner in = new Scanner (Childfile);
            for (int i = 0; in.hasNextLine(); i++){
                String ln = in.nextLine();
                String[] parts = ln.split("\\s+"); // because data separated by spaces
                 if (parts.length >2){
                     String ClassID = parts[8]; 
                     if(ClassID.equals(this.cID)){
                         students.add(parts[5]);
                     }       
                 }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return students;
    }
    //--------------------------------------------------------------------------
    @Override
    public void start(Stage stage) throws Exception {
        //background 
        Image Tbackground = new Image(background);
        Image Tlogo = new Image(logo);
        ImageView TbckgrndImageView = new ImageView(Tbackground);
        TbckgrndImageView.setFitWidth(370.0f);
        TbckgrndImageView.setFitHeight(600.0f);
        /*-----------------------------------------*/
        ImageView TlogoImageView = new ImageView(Tlogo);
        TlogoImageView.setFitWidth(150.0f); //100
        TlogoImageView.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button TlogoButton = new Button();
        TlogoButton.setGraphic(TlogoImageView);
        TlogoButton.setPrefWidth(100);
        TlogoButton.setPrefHeight(100);
        TlogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox TlogoBox = new HBox();
        TlogoBox.getChildren().add(TlogoButton);
        TlogoBox.setAlignment(Pos.TOP_LEFT);
        TlogoBox.setPadding(new Insets(0, 0, 0, 0)); //top,left,bottom,right
        //--------------------------------------------------------------------------
////////////////////////////////////////////////////////////////////////////////   
        //Teacher Scene components
        //To whom does the interface belong (Text)
        Text teacher = new Text("Teacher");
        teacher.setX(100);
        teacher.setY(200);
        teacher.setFill(dark_blue);
        teacher.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");
        //--------------------------------------------------------------------------    
        //Buttons
        Button personalInfoBt = new Button("Personal information");
        personalInfoBt.setPrefWidth(200);
        personalInfoBt.setPrefHeight(30);
        personalInfoBt.setTextFill(light_blue);
        personalInfoBt.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
        /*-----------------------------------------*/
        Button studentTasksBt = new Button("Student tasks");
        studentTasksBt.setPrefWidth(200);
        studentTasksBt.setPrefHeight(30);
        studentTasksBt.setTextFill(light_blue);
        studentTasksBt.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
        /*-----------------------------------------*/
        Button studentBehaviorBt = new Button("Student behavior");
        studentBehaviorBt.setPrefWidth(200);
        studentBehaviorBt.setPrefHeight(30);
        studentBehaviorBt.setTextFill(light_blue);
        studentBehaviorBt.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
        //--------------------------------------------------------------------------
        //VBox to arrange the buttons in one column
        VBox teacherBtns = new VBox();
        teacherBtns.getChildren().addAll(personalInfoBt, studentTasksBt, studentBehaviorBt);
        teacherBtns.setAlignment(Pos.CENTER);
        teacherBtns.setLayoutX(80);
        teacherBtns.setLayoutY(250);
        teacherBtns.setSpacing(7);
        //--------------------------------------------------------------------------  
        //Panes
        Pane teacherPane = new Pane(teacher, teacherBtns); //imageView
        StackPane teacherStackPane = new StackPane();
        teacherStackPane.getChildren().addAll(TbckgrndImageView, TlogoBox, teacherPane);
        //----------------------------------------------
        //Display
        Scene teacherScene = new Scene(teacherStackPane, 370, 600);
        stage.setScene(teacherScene);
        stage.setTitle("SCIENCE GARDEN");
////////////////////////////////////////////////////////////////////////////////
        //Teacher personal info Scene components   
        //background
        Image PIbackground = new Image(background);
        Image PIlogo = new Image(logo);
        ImageView teacherInfobckgrnd = new ImageView(PIbackground);
        teacherInfobckgrnd.setFitWidth(370.0f);
        teacherInfobckgrnd.setFitHeight(600.0f);
        /*-----------------------------------------*/
        ImageView teacherInfoLogo = new ImageView(PIlogo);
        teacherInfoLogo.setFitWidth(150.0f);
        teacherInfoLogo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button TinfoLogoButton = new Button();
        TinfoLogoButton.setGraphic(teacherInfoLogo);
        TinfoLogoButton.setPrefWidth(100);
        TinfoLogoButton.setPrefHeight(100);
        TinfoLogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox TinfoLogoBox = new HBox();
        TinfoLogoBox.getChildren().add(TinfoLogoButton);
        TinfoLogoBox.setAlignment(Pos.TOP_LEFT);
        TinfoLogoBox.setPadding(new Insets(0, 0, 0, 0));
        //-------------------------------------------------------------------------- 
        //Labels
        Label TeacherInfo = new Label("Information");
        TeacherInfo.setTextFill(dark_blue);
        TeacherInfo.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");
        /*-----------------------------------------*/
        Label nameLabel = new Label("Name:");
        nameLabel.setFont(Font.font("Comic Sans MS", 14));
        nameLabel.setTextFill(dark_blue);
        /*-----------------------------------------*/
        Label idLabel = new Label("Teacher ID:");
        idLabel.setFont(Font.font("Comic Sans MS", 14));
        idLabel.setTextFill(dark_blue);
        /*-----------------------------------------*/
        Label employmentDateLabel = new Label("Employment Date:");
        employmentDateLabel.setFont(Font.font("Comic Sans MS", 14));
        employmentDateLabel.setTextFill(dark_blue);
        /*-----------------------------------------*/
        Label classIdLabel = new Label("Class ID:");
        classIdLabel.setFont(Font.font("Comic Sans MS", 14));
        classIdLabel.setTextFill(dark_blue);
        /*-----------------------------------------*/
        Label phoneLabel = new Label("Phone Number:");
        phoneLabel.setFont(Font.font("Comic Sans MS", 14));
        phoneLabel.setTextFill(dark_blue);
        /*-----------------------------------------*/
        Label AdminLabel = new Label("Admin ID:");
        AdminLabel.setFont(Font.font("Comic Sans MS", 14));
        AdminLabel.setTextFill(dark_blue);
        //--------------------------------------------------------------------------   
        TextField nameField = new TextField(this.Fname + " " +this.Lname);
    nameField.setBackground(Background.EMPTY);
    nameField.setEditable(false);

    TextField idField = new TextField(tID);
    idField.setBackground(Background.EMPTY);

    TextField employmentDateField = new TextField(DOE);
    employmentDateField.setBackground(Background.EMPTY);

    TextField classIdField = new TextField(ClassName);
    classIdField.setBackground(Background.EMPTY);

    TextField phoneField = new TextField("0"+phoneNum);
    phoneField.setBackground(Background.EMPTY);

//    TextField adminField = new TextField(aID);
//    adminField.setBackground(Background.EMPTY);

    // GridPane for Teacher Information
    GridPane teacherGridPane = new GridPane();
    teacherGridPane.setPadding(new Insets(20, 20, 20, 20));
    teacherGridPane.setVgap(25);
    teacherGridPane.setHgap(10);

    teacherGridPane.add(nameLabel, 0, 0);
    teacherGridPane.add(nameField, 1, 0);

    teacherGridPane.add(idLabel, 0, 1);
    teacherGridPane.add(idField, 1, 1);

    teacherGridPane.add(employmentDateLabel, 0, 2);
    teacherGridPane.add(employmentDateField, 1, 2);

    teacherGridPane.add(classIdLabel, 0, 3);
    teacherGridPane.add(classIdField, 1, 3);

    teacherGridPane.add(phoneLabel, 0, 4);
    teacherGridPane.add(phoneField, 1, 4);

        /*-----------------------------------------*/
        HBox TeacherInfoHBox = new HBox(TeacherInfo);
        TeacherInfoHBox.setAlignment(Pos.CENTER);
        /*-----------------------------------------*/
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(TeacherInfoHBox, teacherGridPane);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(50, 20, 20, 20));
        /*-----------------------------------------*/
        StackPane TinfoRoot = new StackPane(teacherInfobckgrnd, TinfoLogoBox, layout1);
        //--------------------------------------------------------------------------
        //Display
        Scene teacherInfoScene = new Scene(TinfoRoot, 370, 600);
////////////////////////////////////////////////////////////////////////////////
//StudentTask Scene components
//background
        Image taskBackground = new Image(background);
        Image taskLogo = new Image(logo);
        ImageView stTaskBckgrnd = new ImageView(taskBackground);
        stTaskBckgrnd.setFitWidth(370.0f);
        stTaskBckgrnd.setFitHeight(600.0f);
        /*-----------------------------------------*/
        ImageView stTaskLogo = new ImageView(taskLogo);
        stTaskLogo.setFitWidth(150.0f);
        stTaskLogo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button stTaskLogoButton = new Button();
        stTaskLogoButton.setGraphic(stTaskLogo);
        stTaskLogoButton.setPrefWidth(100);
        stTaskLogoButton.setPrefHeight(100);
        stTaskLogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox stTaskLogoBox = new HBox();
        stTaskLogoBox.getChildren().add(stTaskLogoButton);
        stTaskLogoBox.setAlignment(Pos.TOP_LEFT);
        stTaskLogoBox.setPadding(new Insets(0, 0, 0, 0));
//Page Title
        Label taskPageTitle = new Label("Students tasks");
        taskPageTitle.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 30px;");
        taskPageTitle.setTextFill(dark_blue);
        /**
         * *****
         */
        HBox titleBox = new HBox();
        titleBox.getChildren().add(taskPageTitle);
        titleBox.setAlignment(Pos.BOTTOM_CENTER);
        titleBox.setPadding(new Insets(120, 0, 0, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
        //ID
        Label teacherChID = new Label("Student ID: ");
        teacherChID.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        teacherChID.setTextFill(dark_blue);
        /** * ******/
        ComboBox teacherChIDChoiceBox = new ComboBox();
        
        
        teacherChIDChoiceBox.getItems().addAll("101", "102", "103", "104", "105"
        ,"106", "107", "108", "109", "110");
        teacherChIDChoiceBox.setValue("101");
        
           
        //pane for the whole row
        HBox chIdHBox = new HBox(30);
        chIdHBox.getChildren().addAll(teacherChID, teacherChIDChoiceBox);
        chIdHBox.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
        //1st row: Task title
        Label taskTitleLabel = new Label("Title: ");
        taskTitleLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        taskTitleLabel.setTextFill(dark_blue);
        /**
         * *****
         */
        TextField taskTitleField = new TextField();
        //pane for the whole row
        HBox taskTitleUIs = new HBox(30);
        taskTitleUIs.getChildren().addAll(taskTitleLabel, taskTitleField);
        taskTitleUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
        //2nd row: The task is for which subject
        Label subjectLabel = new Label("Subject: ");
        subjectLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        subjectLabel.setTextFill(dark_blue);
        /**
         * *****
         */
        String[] subjects = {"Quraan", "Maths", "English", "Arabic"};
        ComboBox<String> subjectsCbo = new ComboBox<>();
        subjectsCbo.getItems().addAll(subjects);
        subjectsCbo.setPrefWidth(150);
        subjectsCbo.setVisibleRowCount(4);
        subjectsCbo.setValue("Choose subject");
        subjectsCbo.setStyle("-fx-text-fill: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 12px;");
        //pane for the whole row
        HBox subjectUIs = new HBox(10);
        subjectUIs.getChildren().addAll(subjectLabel, subjectsCbo);
        subjectUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
        //3d row: The type of the task/ Targetted skill
        Label taskTypeLabel = new Label("Target\nskill: ");
        taskTypeLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        taskTypeLabel.setTextFill(dark_blue);
        /**
         * *****
         */
        RadioButton readingBtn = new RadioButton("Reading");
        readingBtn.setTextFill(light_blue);
        readingBtn.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 12px;");
        /**
         * *****
         */
        RadioButton listeningBtn = new RadioButton("Listining");
        listeningBtn.setTextFill(light_blue);
        listeningBtn.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 12px;");
        /**
         * *****
         */
        RadioButton memorizingBtn = new RadioButton("Memorizing");
        memorizingBtn.setTextFill(light_blue);
        memorizingBtn.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 12px;");
        /**
         * *****
         */
        RadioButton solvingBtn = new RadioButton("Solving problems");
        solvingBtn.setTextFill(light_blue);
        solvingBtn.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 12px;");
        //Only 1 to be selected
        ToggleGroup group = new ToggleGroup();
        readingBtn.setToggleGroup(group);
        listeningBtn.setToggleGroup(group);
        memorizingBtn.setToggleGroup(group);
        solvingBtn.setToggleGroup(group);
        //VBoxes to set 2 columns to the HBox
        VBox skillRbtns1c = new VBox(5);
        skillRbtns1c.getChildren().addAll(readingBtn, listeningBtn);
        /**
         * *****
         */
        VBox skillRbtns2c = new VBox(5);
        skillRbtns2c.getChildren().addAll(memorizingBtn, solvingBtn);
        //HBox with 2 columns
        HBox skillRbtnsColumns = new HBox(10);
        skillRbtnsColumns.getChildren().addAll(skillRbtns1c, skillRbtns2c);
        //pane for the whole row
        HBox taskTypetUIs = new HBox(27);
        taskTypetUIs.getChildren().addAll(taskTypeLabel, skillRbtnsColumns);
        taskTypetUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
        //4th row: The task itself
        Label taskLabel = new Label("Task: ");
        taskLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        taskLabel.setTextFill(dark_blue);
        /**
         * *****
         */
        TextArea taskField = new TextArea();
        taskField.setPrefWidth(200);
        taskField.setPrefHeight(100);
        //pane for the whole row
        HBox taskUIs = new HBox(27);
        taskUIs.getChildren().addAll(taskLabel, taskField);
        taskUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
        //Last row: in the bottom of the pane
        Button publishTaskBtn = new Button("Publish");
        publishTaskBtn.setTextFill(light_blue);
        publishTaskBtn.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 12px;");
        //pane for the whole row
        HBox publishBtnBox = new HBox(90);
        publishBtnBox.getChildren().addAll(publishTaskBtn);
        publishBtnBox.setAlignment(Pos.TOP_LEFT);
        publishBtnBox.setPadding(new Insets(0, 0, 50, 120)); //top,right,bottom,left
        
        publishTaskBtn.setOnAction(e ->{
            if (e.getSource() == publishTaskBtn) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Task Supdate = null;
        String steacherChIDChoiceBox=(String) teacherChIDChoiceBox.getValue();
        int idch = Integer.parseInt(steacherChIDChoiceBox);
        int chid=idch;
//int chid=105;

        Supdate = (Task)session.get(Task.class, chid);
        
        Supdate.setTitle(taskTitleField.getText());
        
        Supdate.setSub(subjectsCbo.getValue());
        
        if(readingBtn.isSelected()){
        Supdate.setTarget("Reading");
        }else if(listeningBtn.isSelected()){
           Supdate.setTarget("Listining"); 
        }else if(memorizingBtn.isSelected()){
           Supdate.setTarget("memorizing"); 
        }else if(solvingBtn.isSelected()){
           Supdate.setTarget("Solving problems"); 
        }
        
        Supdate.setTasks(taskField.getText());
        session.update(Supdate);
        
        tx.commit();
        session.close();
        System.out.println("Student "+ chid +" was updated by: "+Supdate.getTitle()+Supdate.getSub()+Supdate.getTarget()+Supdate.getTasks());
       
            }
        });
        
        
        
        //--------------------------------------------------------------------------       
        //panes
        VBox tasksVBox = new VBox(5);
        tasksVBox.getChildren().addAll(chIdHBox,taskTitleUIs, subjectUIs, taskTypetUIs, taskUIs);
        tasksVBox.setAlignment(Pos.CENTER);
        tasksVBox.setPadding(new Insets(0, 0, 0, 45)); //top,right,bottom,left
        /**
         * *****
         */
        BorderPane pane = new BorderPane();
        pane.setCenter(tasksVBox);
        pane.setBottom(publishBtnBox);
        pane.setTop(titleBox);
        //Pane pane = new Pane(tasksVBox);
        /**
         * *****
         */
        StackPane root = new StackPane();
        root.getChildren().addAll(stTaskBckgrnd, stTaskLogoBox, pane);
        //--------------------------------------------------------------------------
        //Display
        Scene StudentTaskScene = new Scene(root, 370, 600);

////////////////////////////////////////////////////////////////////////////////
        //Students behavior Scene components
        //background 
        Image BebahvBackground = new Image(background);
        Image BebahvLogo = new Image(logo);
        ImageView stBehavBckgrnd = new ImageView(BebahvBackground);
        stBehavBckgrnd.setFitWidth(370.0f);
        stBehavBckgrnd.setFitHeight(600.0f);
        /*-----------------------------------------*/
        ImageView stBehavBckLogo = new ImageView(BebahvLogo);
        stBehavBckLogo.setFitWidth(150.0f); //100
        stBehavBckLogo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button stBehavLogoButton = new Button();
        stBehavLogoButton.setGraphic(stBehavBckLogo);
        stBehavLogoButton.setPrefWidth(100);
        stBehavLogoButton.setPrefHeight(100);
        stBehavLogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox stBehavLogoBox = new HBox();
        stBehavLogoBox.getChildren().add(stBehavLogoButton);
        stBehavLogoBox.setAlignment(Pos.TOP_LEFT);
        stBehavLogoBox.setPadding(new Insets(0, 0, 0, 0)); //top,right,bottom,left    
        //--------------------------------------------------------------------------
        //Page Title
        Label behavPageTitle = new Label("Student behavior");
        behavPageTitle.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 30px;");
        behavPageTitle.setTextFill(dark_blue);
        /**
         * *****
         */
        HBox behavTitleBox = new HBox();
        behavTitleBox.getChildren().add(behavPageTitle);
        behavTitleBox.setAlignment(Pos.BOTTOM_CENTER);
        behavTitleBox.setPadding(new Insets(120, 0, 0, 0)); //top,right,bottom,left
        //--------------------------------------------------------------------------
        //1st row: Student name
         Label teacherChbName = new Label("Student Name: ");
        teacherChbName.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        teacherChbName.setTextFill(dark_blue);
        /** * ******/
        ComboBox teacherChBChoiceBox = new ComboBox();
        
        
        teacherChBChoiceBox.getItems().addAll("Khalid", "Maya", "Mohamed", "Rana", "Rawan"
        ,"Reem", "Renad", "Sami", "Wisam", "Yazan");
        teacherChBChoiceBox.setValue("Khalid");
       
        //pane for the whole row
        HBox chIdBHBox = new HBox(30);
        chIdBHBox.getChildren().addAll(teacherChbName, teacherChBChoiceBox);
        chIdBHBox.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
     
        /*-----------------------------------------*/
        //2nd row: Day
        Label dayLabel = new Label("Day: ");
        dayLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        dayLabel.setTextFill(dark_blue);
        /**
         * *****
         */
        String[] weekDayes = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        ComboBox<String> daysCbo = new ComboBox<>();
        daysCbo.getItems().addAll(weekDayes);
        daysCbo.setPrefWidth(150);
        daysCbo.setVisibleRowCount(4);
        daysCbo.setValue("Choose a day");
        daysCbo.setStyle("-fx-text-fill: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 12px;");
        //pane for the whole row
        HBox dayUIs = new HBox(45);
        dayUIs.getChildren().addAll(dayLabel, daysCbo);
        dayUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
        //3d row: Date
        Label dateLabel = new Label("Date: ");
        dateLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        dateLabel.setTextFill(dark_blue);
        /**
         * *****
         */
        DatePicker datePicker = new DatePicker();
        datePicker.setMaxWidth(152);
        //pane for the whole row
        HBox dateUIs = new HBox(37);
        dateUIs.getChildren().addAll(dateLabel, datePicker);
        dateUIs.setPadding(new Insets(0, 0, 20, 0)); //top,right,bottom,left
        /*-----------------------------------------*/
        //4th row: Behavior
        Label stBehavLabel = new Label("Student\nbehavior: ");
        stBehavLabel.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        stBehavLabel.setTextFill(dark_blue);
        /**
         * **BEHAVIORS***
         */
        Label behav1 = new Label("Respect\nothers");
        behav1.setTextFill(light_blue);
        Slider behav1Slider = new Slider();
        behav1Slider.setMin(0);
        behav1Slider.setMax(100);
        behav1Slider.setValue(0);
        behav1Slider.setPrefWidth(10);
        behav1Slider.setShowTickLabels(true);
        behav1Slider.setShowTickMarks(true);
        behav1Slider.setMajorTickUnit(50);
        behav1Slider.setMinorTickCount(1);
        behav1Slider.setBlockIncrement(25);
        behav1Slider.valueProperty().addListener(
         new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            intValue1 = newValue.intValue(); // Convert the Number value to int
//            vbehav1Slider =intValue1;
//            System.out.println(vbehav1Slider);
        }
    }
);
        
        /**
         * *****
         */
        Label behav2 = new Label("Active");
        behav2.setTextFill(light_blue);
        Slider behav2Slider = new Slider();
        behav2Slider.setMin(0);
        behav2Slider.setMax(100);
        behav2Slider.setValue(0);
        behav2Slider.setShowTickLabels(true);
        behav2Slider.setShowTickMarks(true);
        behav2Slider.setMajorTickUnit(50);
        behav2Slider.setMinorTickCount(1);
        behav2Slider.setBlockIncrement(25);
        behav2Slider.valueProperty().addListener(
         new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            intValue2 = newValue.intValue(); // Convert the Number value to int
//            vbehav2Slider =intValue2;
//            System.out.println(vbehav2Slider);
        }
    }
);
        /**
         * *****
         */
        Label behav3 = new Label("Focus");
        behav3.setTextFill(light_blue);
        Slider behav3Slider = new Slider();
        behav3Slider.setMin(0);
        behav3Slider.setMax(100);
        behav3Slider.setValue(0);
        behav3Slider.setShowTickLabels(true);
        behav3Slider.setShowTickMarks(true);
        behav3Slider.setMajorTickUnit(50);
        behav3Slider.setMinorTickCount(1);
        behav3Slider.setBlockIncrement(25);
        behav3Slider.valueProperty().addListener(
         new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            intValue3 = newValue.intValue(); // Convert the Number value to int
//            vbehav3Slider =intValue3;
//            System.out.println(vbehav3Slider);
        }
    }
);
        /**
         * *****
         */
        Label behav4 = new Label("Collaborate\nwith classmates");
        behav4.setTextFill(light_blue);
        Slider behav4Slider = new Slider();
        behav4Slider.setMin(0);
        behav4Slider.setMax(100);
        behav4Slider.setValue(0);
        behav4Slider.setShowTickLabels(true);
        behav4Slider.setShowTickMarks(true);
        behav4Slider.setMajorTickUnit(50);
        behav4Slider.setMinorTickCount(1);
        behav4Slider.setBlockIncrement(25);
        behav4Slider.valueProperty().addListener(
         new ChangeListener<Number>() {
        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            intValue4 = newValue.intValue(); // Convert the Number value to int
//            vbehav4Slider =intValue4;
//            System.out.println(vbehav4Slider);
        }
    }
);
        //GridPane for behaviors & checkboxes
        GridPane lblsANDchk = new GridPane();
        lblsANDchk.setVgap(15);
        lblsANDchk.setHgap(10);
        lblsANDchk.setMaxSize(310, 200);
        //1st column
        lblsANDchk.add(behav1, 0, 0); //node,column,row
        lblsANDchk.add(behav2, 0, 1);
        lblsANDchk.add(behav3, 0, 2);
        lblsANDchk.add(behav4, 0, 3);
        //2nd column
        lblsANDchk.add(behav1Slider, 1, 0); //node,column,row
        lblsANDchk.add(behav2Slider, 1, 1);
        lblsANDchk.add(behav3Slider, 1, 2);
        lblsANDchk.add(behav4Slider, 1, 3);
        //pane for the whole row
        HBox behavUIs = new HBox(13);
        behavUIs.getChildren().addAll(stBehavLabel, lblsANDchk);
        /*-----------------------------------------*/
        //last row: in the bottom of the BorderPane
        Button publishBehavBtn = new Button("Publish");
        publishBehavBtn.setTextFill(light_blue);
        publishBehavBtn.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 12px;");
        publishBehavBtn.setOnAction(e->{
//            System.out.println(vbehav3Slider);
            Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();

Behavior behavior = null;
String sid = (String) teacherChBChoiceBox.getValue(); // Change the type of sid to String

// Retrieve the Behavior entity using the correct ID type
behavior = (Behavior) session.get(Behavior.class, sid);

if (behavior != null) {
    behavior.setDay(daysCbo.getValue());
    String t =datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
     behavior.setDate(t);
     behavior.setRespect(intValue1);
     behavior.setActive(intValue2);
     behavior.setFocus(intValue3);
     behavior.setCollaboration(intValue4);

    session.update(behavior);
    tx.commit();
    System.out.println("Behavior " + sid + " was updated by: " + behavior.getDay());
} else {
    // Handle the case when the Behavior entity with the given ID is not found
    System.out.println("Behavior with ID " + sid + " not found.");
}

session.close();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        });
        /**
         * *****
         */
        HBox publishBehavBox = new HBox(90);
        publishBehavBox.getChildren().addAll(publishBehavBtn);
        publishBehavBox.setAlignment(Pos.TOP_LEFT);
        publishBehavBox.setPadding(new Insets(0, 0, 50, 45)); //top,right,bottom,left
        //--------------------------------------------------------------------------
        //panes
        /*VBox for all the rows (all "pane for the whole row")*/
        VBox studentBehavVBox = new VBox(5);
        studentBehavVBox.getChildren().addAll(chIdBHBox, dayUIs, dateUIs, behavUIs);
        studentBehavVBox.setAlignment(Pos.CENTER);
        studentBehavVBox.setPadding(new Insets(0, 0, 0, 30)); //top,right,bottom,left
        /**
         * *****
         */
        BorderPane stBehavPane = new BorderPane();
        stBehavPane.setCenter(studentBehavVBox);
        stBehavPane.setTop(behavTitleBox);
        stBehavPane.setBottom(publishBehavBox);
        //pane.setBottom(publishBtnBox);
        StackPane stTaskRoot = new StackPane();
        stTaskRoot.getChildren().addAll(stBehavBckgrnd, stBehavLogoBox, stBehavPane);
        //--------------------------------------------------------------------------
        //Display
        Scene stBeahvScene = new Scene(stTaskRoot, 370, 600);
////////////////////////////////////////////////////////////////////////////////
        //Actions   
        personalInfoBt.setOnAction(e -> {
            stage.setScene(teacherInfoScene);
            stage.setTitle("Teacher Information");
        });

        studentTasksBt.setOnAction(e -> {
            stage.setScene(StudentTaskScene);
            stage.setTitle("Students Tasks");
        });

        studentBehaviorBt.setOnAction(e -> {
            stage.setScene(stBeahvScene);
            stage.setTitle("Students Tasks");
        });
        /*-----------------------------------------*/
        teacherInfoScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                stage.setScene(teacherScene);
            }
        });

        StudentTaskScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                stage.setScene(teacherScene);
            }
        });

        stBeahvScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.LEFT) {
                stage.setScene(teacherScene);
            }
        });

        stage.show();
    }//EndOfStartMethos

//______________________________________________________________________________     
}//EndOfClass
