package project;
//imports

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.scene.input.KeyCode;

public class Admin extends Application {
    //Admin attributes
    private String Fname;
    private String Lname;
    private String ID;
    private String DOE ;
    private String phoneNum;
    private String task;
           
    // File path for Admin Admin.txt file
    String filePath = "C:\\Users\\Lujain_Alhebshi\\Downloads\\Project Interfaces\\Admin.txt";
    File file = new File (filePath);
    
    //constrctors
        public Admin() {
    }

    public Admin(String Fname, String Lname,String ID, String phoneNum, String task) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.ID = ID;
        this.phoneNum = phoneNum;
        this.task = task;
    }

    //setters and getters
    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

//    public void setDOE(LocalDate DOE) {
//        this.DOE = DOE;
//    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getFname() {
        return Fname;
    }

    public String getLname() {
        return Lname;
    }

//    public LocalDate getDOE() {
//        return DOE;
//    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getTask() {
        return task;
    }


    public boolean checkLogin(String enteredUsername, String enteredPassword) {
    
    try {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+"); // data is separated by spaces

            if (parts.length >= 7) {
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
    public boolean Assign (String[] parts){
        this.Fname = parts[2];
        this.Lname = parts[3];
        this.ID = parts[4];
        this.DOE = parts[5];
        this.phoneNum = parts[6];
        String s = "" ;
        for (int i = 7; i < parts.length; i++) {
            String item = parts[i];
            s = s+" " + item;
        }
        this.task = s;
        System.out.println("f: "+Fname+" L: "+ Lname+" n:" +phoneNum+" t: "+ task);
        return true;
    }
    //----------------------------------------
    // The Scenec
//    Scene AdminScene;
//    Scene AdminInfoScene;
//    Scene TripScene;
//    Scene TeacherRecordScene;

    
    //global vars
    Color labels = Color.rgb(33, 59, 105);
    Color texts = Color.rgb(144, 171, 220);
    Color orange = Color.rgb(233, 110, 68);
    double button_width = 200;
    double button_height = 30;
    //--------------------------------------------------------------------------
    //images
   String background = "file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp Image 2024-01-11 at 17.43.59.jpeg";
    String logo = "file:C:\\Users\\Lujain_Alhebshi\\Desktop\\WhatsApp_Image_2024-01-11_at_17.31.38-removebg-preview.png";
   
    //--------------------------------------------------------------------------
    //interface 
    @Override
    public void start(Stage stage) throws Exception {
        System.out.print("hhhhhhhh");
        //////////////Background and logo for all Scenes///////////////
        //background image home
        ImageView adminbckgrnd = new ImageView(background);
        adminbckgrnd.setFitWidth(370.0f);
        adminbckgrnd.setFitHeight(600.0f);
        /*-----------------------------------------*/
        //logo image
        ImageView adminlogo = new ImageView(logo);
        adminlogo.setFitWidth(150.0f); //100
        adminlogo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button adminlogoButton = new Button();
        adminlogoButton.setGraphic(adminlogo);
        adminlogoButton.setPrefWidth(100);
        adminlogoButton.setPrefHeight(100);
        adminlogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox adminlogoBox= new HBox();
        adminlogoBox.getChildren().add(adminlogoButton);
        adminlogoBox.setAlignment(Pos.TOP_LEFT);
        adminlogoBox.setPadding(new Insets(0, 0, 0, 0)); //top,left,bottom,right
        
        //background image info
        ImageView adminInfobckgrnd = new ImageView(background);
        adminInfobckgrnd.setFitWidth(370.0f);
        adminInfobckgrnd.setFitHeight(600.0f);
        /*-----------------------------------------*/
        //logo image
        ImageView adminInfologo = new ImageView(logo);
        adminInfologo.setFitWidth(150.0f); //100
        adminInfologo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button adminInfologoButton = new Button();
        adminInfologoButton.setGraphic(adminInfologo);
        adminInfologoButton.setPrefWidth(100);
        adminInfologoButton.setPrefHeight(100);
        adminInfologoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox adminInfologoBox= new HBox();
        adminInfologoBox.getChildren().add(adminInfologoButton);
        adminInfologoBox.setAlignment(Pos.TOP_LEFT);
        adminInfologoBox.setPadding(new Insets(0, 0, 0, 0)); //top,left,bottom,right
        
        //background image home
        ImageView tripbckgrnd = new ImageView(background);
        tripbckgrnd.setFitWidth(370.0f);
        tripbckgrnd.setFitHeight(600.0f);
        /*-----------------------------------------*/
        //logo image
        ImageView triplogo = new ImageView(logo);
        triplogo.setFitWidth(150.0f); //100
        triplogo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        Button triplogoButton = new Button();
        triplogoButton.setGraphic(triplogo);
        triplogoButton.setPrefWidth(100);
        triplogoButton.setPrefHeight(100);
        triplogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox triplogoBox= new HBox();
        triplogoBox.getChildren().add(triplogoButton);
        triplogoBox.setAlignment(Pos.TOP_LEFT);
        triplogoBox.setPadding(new Insets(0, 0, 0, 0)); //top,left,bottom,right
        
        //background image teacher record
        ImageView teacherRecordbckgrnd = new ImageView(background);
        teacherRecordbckgrnd.setFitWidth(370.0f);
        teacherRecordbckgrnd.setFitHeight(600.0f);
        /*-----------------------------------------*/
        //logo image
        ImageView teacherRecordlogo = new ImageView(logo);
        teacherRecordlogo.setFitWidth(150.0f); //100
        teacherRecordlogo.setFitHeight(130.0f);
        /*-----------------------------------------*/
        
        Button trecordlogoButton = new Button();
        trecordlogoButton.setGraphic(teacherRecordlogo);
        trecordlogoButton.setPrefWidth(100);
        trecordlogoButton.setPrefHeight(100);
        trecordlogoButton.setBackground(Background.EMPTY);
        /*-----------------------------------------*/
        HBox trecordlogoBox= new HBox();
        trecordlogoBox.getChildren().add(trecordlogoButton);
        trecordlogoBox.setAlignment(Pos.TOP_LEFT);
        trecordlogoBox.setPadding(new Insets(0, 0, 0, 0)); //top,left,bottom,right
//__________________________________________________________________________  
    //////// the First scene "Admin options" ///////////////   
        /////// "Admin" Interface  ///////
        Text admin = new Text("Admin");
        admin.setX(120);
        admin.setY(200);
        admin.setFill(labels);
        admin.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");
//______________________________________________________________________________    
        //Buttons
        Button b_a_personal_info = new Button("Personal information");     
        b_a_personal_info.setPrefWidth(button_width);
        b_a_personal_info.setPrefHeight(button_height);
        b_a_personal_info.setTextFill(texts);
        b_a_personal_info.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
        
        Button b_a_teacher_record = new Button("Teacher Record");
        b_a_teacher_record.setPrefWidth(button_width);
        b_a_teacher_record.setPrefHeight(button_height);
        b_a_teacher_record.setTextFill(texts);       
        b_a_teacher_record.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
        
      
        Button b_a_trip_management = new Button("Trip Management");
        b_a_trip_management.setPrefWidth(button_width);
        b_a_trip_management.setPrefHeight(button_height);
        b_a_trip_management.setTextFill(texts);
        b_a_trip_management.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
         //--------------------------------------------------------------------------
        //VBox to arrange the buttons in one column
        VBox BtnsA = new VBox(17);
        BtnsA.getChildren().addAll(b_a_personal_info,b_a_teacher_record,b_a_trip_management);
        BtnsA.setAlignment(Pos.CENTER);
        BtnsA.setLayoutX(80);
        BtnsA.setLayoutY(250);
        BtnsA.setSpacing(7);
        //______________________________________________________________________________       
        //Panes 
        Pane paneA = new Pane(admin,BtnsA); //
        StackPane Aroot = new StackPane (adminbckgrnd, paneA,adminlogoBox);
//______________________________________________________________________________        
        //Display
        Scene AdminScene = new Scene(Aroot, 370, 600);
        stage.setScene(AdminScene);
    //////// the Second scene "Admin information" ///////////////
            ///// UI Controls /////
        
        Label AdminInfo = new Label("Information");
        AdminInfo.setTextFill(labels);
        AdminInfo.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");
        
        
        Label adminNameLabel = new Label("Name:");
        adminNameLabel.setFont(Font.font("Comic Sans MS", 14));
        adminNameLabel.setTextFill(labels);

        Label adminIdLabel = new Label("Admin ID:");
        adminIdLabel.setFont(Font.font("Comic Sans MS", 14));
        adminIdLabel.setTextFill(labels);

        Label EmploymentDateLabel = new Label("Employment Date:");
        EmploymentDateLabel.setFont(Font.font("Comic Sans MS", 14));
        EmploymentDateLabel.setTextFill(labels);

        Label adminPhoneLabel = new Label("Phone Number:");
        adminPhoneLabel.setFont(Font.font("Comic Sans MS", 14));
        adminPhoneLabel.setTextFill(labels);
        
        Label taskLabel = new Label("Task:");
        taskLabel.setFont(Font.font("Comic Sans MS", 14));
        taskLabel.setTextFill(labels);
        
        
        /// TextFields
        TextField adminNameField = new TextField(this.Fname + " " +this.Lname);
//        adminNameField.setTextFill(orange0); 
        adminNameField.setBackground(Background.EMPTY);
        adminNameField.setEditable(false);
        
        TextField adminIdField = new TextField(ID);
        adminIdField.setBackground(Background.EMPTY);
                
        TextField adminEmploymentDateField = new TextField(DOE);
        adminEmploymentDateField.setBackground(Background.EMPTY);
                
        TextField adminPhoneField = new TextField(phoneNum);
        adminPhoneField.setBackground(Background.EMPTY);
        
        TextField TaskField = new TextField(task);
        TaskField.setBackground(Background.EMPTY);
              
        ///// Panes ////////////////////////////////////////////////////////
        
        //// Grid pane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setVgap(25);
        gridPane.setHgap(10);

        gridPane.add(adminNameLabel, 0, 0);
        gridPane.add(adminNameField, 1, 0);

        gridPane.add(adminIdLabel, 0, 1);
        gridPane.add(adminIdField, 1, 1);

        gridPane.add(EmploymentDateLabel, 0, 2);
        gridPane.add(adminEmploymentDateField, 1, 2);

        gridPane.add(adminPhoneLabel, 0, 3);
        gridPane.add(adminPhoneField, 1, 3);

        //Task
        gridPane.add(taskLabel, 0, 4);
        gridPane.add(TaskField, 1, 4);
        
        //// End Grid Pans 
        
        
        HBox AdminInfoHBox = new HBox(AdminInfo);
        AdminInfoHBox.setAlignment(Pos.CENTER);
        
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(AdminInfoHBox, gridPane);
        layout1.setAlignment(Pos.CENTER);
        layout1.setPadding(new Insets(50, 20, 20, 20));
        
    StackPane Iroot = new StackPane(adminInfobckgrnd, adminInfologoBox,layout1);
        
    Scene AdminInfoScene = new Scene(Iroot, 370, 600);
    
    //////// the Third scene "Teachers Records"///////////////
    //Text to explane the page contant
        Text lTeacherRecord = new Text("Teacher Record ");
        lTeacherRecord.setFill(labels);
        lTeacherRecord.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");
        HBox hh= new HBox();
        hh.getChildren().add(lTeacherRecord);
        hh.setPadding(new Insets(10,10,10,-15));

//teacer names in check box
        CheckBox muna = new CheckBox("Muna AlHebshi");
        CheckBox anmar = new CheckBox("Anmar Jalal");
        CheckBox maha = new CheckBox("Maha AlMutaani");
        CheckBox hasna = new CheckBox("Hasna AlHarthi");
        CheckBox dalal = new CheckBox("Dakak AlOufi");

        DatePicker date = new DatePicker();
        Button Extract = new Button("Extract->file");
        Extract.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");


        Label msg1 = new Label("");
        msg1.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
        msg1.setTextFill(orange);
        msg1.setMaxWidth(200);
        msg1.setMaxHeight(100);     
//______________________________________________________________________________    
        //Panes 
        VBox paneT = new VBox(15);
        paneT.getChildren().addAll(hh, muna, anmar, maha, hasna, dalal, date, Extract, msg1);
        paneT.setAlignment(Pos.CENTER_LEFT);

        paneT.setPadding(new Insets(100, 100, 100, 150));
        StackPane troot = new StackPane(tripbckgrnd, triplogoBox, paneT);
//______________________________________________________________________________
        //Action
        Extract.setOnAction(eh -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
                writer.write("The Preparation for teachers \n\n Date: "+(date.getValue())+"\n\n");
                writer.write("Muna AlHebshi state: " + (muna.isSelected() ? "Adttended" : "Absent"));
                writer.write("\nAnmar Jalal state: " + (anmar.isSelected() ? "Adttended" : "Absent"));
                writer.write("\nMaha AlMutaani state: " + (maha.isSelected() ? "Adttended" : "Absent"));
                writer.write("\nHasna AlHarthi state: " + (hasna.isSelected() ? "Adttended" : "Absent"));
                writer.write("\nDakak AlOufi state: " + (dalal.isSelected() ? "Adttended" : "Absent"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
//______________________________________________________________________________        
        //Display
         Scene TeacherRecordScene = new Scene(troot, 370, 600);
    //////// the Fourth scene "Trip Management" ///////////////

    //text sub
        Text tTripManagement = new Text("Trip Management ");
        tTripManagement.setX(100);
        tTripManagement.setY(200);
        tTripManagement.setFill(labels);
        tTripManagement.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 40px;");
        
        /*-----------------------------------------*/
        //TextArea
        TextArea tAActivity = new TextArea();
        tAActivity.setFont(new Font("Serif", 14));
        tAActivity.setWrapText(true);
        tAActivity.setEditable(true);
        tAActivity.setPrefHeight(100);
        tAActivity.setPrefWidth(50);
        
        //tAActivity.setPrefHeight(200); // Set preferred height
        //__________________________________________________________________________    
        //Buttons
        Button bSens = new Button("Send");
        bSens.setPrefWidth(200);
        bSens.setPrefHeight(30);
        bSens.setTextFill(texts);
        bSens.setStyle("-fx-background-color: white; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 15px;");
        
        Label lExplan = new Label("Please enter the trip description");
         lExplan.setStyle("-fx-font-family: 'Comic Sans MS';  -fx-font-size: 14px;");
         lExplan.setTextFill(texts);

        Label msg2 = new Label("");
        msg2.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-weight: bold; -fx-font-size: 14px;");
//        msg.setTextFill(orange);
        msg2.setMaxWidth(200);
        msg2.setMaxHeight(100);
//__________________________________________________________________________    

        //VBox to arrange the buttons in one column
        VBox Btns = new VBox(20);
        Btns.setPadding(new Insets(10,10,10,10));
        Btns.getChildren().addAll(tTripManagement, tAActivity,lExplan ,bSens,msg2);
        Btns.setAlignment(Pos.CENTER);
        Btns.setLayoutX(80);
        Btns.setLayoutY(250);
        Btns.setSpacing(7);

        StackPane print = new StackPane();
        print.getChildren().addAll(teacherRecordbckgrnd, trecordlogoBox, Btns);
        Scene TripScene = new Scene(print, 370, 600);
//__________________________________________________________________________
    //Events & Actions
    adminlogoButton.setOnAction(e -> {

    });
    b_a_personal_info.setOnAction(ew -> {
       stage.setScene(AdminInfoScene);
    });
    b_a_teacher_record.setOnAction(ee -> {
       stage.setScene(TeacherRecordScene);
    });  
    b_a_trip_management.setOnAction(ed -> {
      stage.setScene(TripScene);
    });
    
    //back to home
    AdminInfoScene.setOnKeyPressed(ea -> {
        if (ea.getCode() == KeyCode.LEFT) {
            stage.setScene(AdminScene);
        }
    }); 
    TeacherRecordScene.setOnKeyPressed(ex -> {
        if (ex.getCode() == KeyCode.LEFT) {
            stage.setScene(AdminScene);
        }
    }); 
    TripScene.setOnKeyPressed(es -> {
        if (es.getCode() == KeyCode.LEFT) {
            stage.setScene(AdminScene);
        }
    }); 

    adminInfologoButton.setOnAction(e -> {
        stage.setScene(AdminScene);
    });
    triplogoButton.setOnAction(e -> {
        stage.setScene(AdminScene);
    });
    trecordlogoButton.setOnAction(e -> {
            stage.setScene(AdminScene);
    });
//______________________________________________________________________________        
        // Display
        stage.setScene(AdminScene);
        stage.setTitle("SCIENCE GARDEN");
        stage.show();
    }//EndOfStart
}//EndOfClass