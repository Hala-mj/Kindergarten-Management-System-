/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import javax.persistence.*;

/**
 *
 * @author Lujain_Alhebshi
 */
@Entity
@Table(name="`projectai`.`Behavior`")
public class Behavior implements java.io.Serializable {
    
    @Id
     @Column(name="chname")
     private String chname;
  @Column(name="subname")
     private String subname;
     @Column(name="day")
     private String day;
     @Column(name="date")
     private String date;
      @Column(name="respect")
     private int respect;
      @Column(name="active")
     private int active;
     @Column(name="focus")
     private int focus;
      @Column(name="collaboration")
     private int collaboration;

      
      public Behavior() {
    }
    

   
    public void setSubname(String subname) {
        this.subname = subname;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname;
    }

    

  

   

  
    

    

    public String getSubname() {
        return subname;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public int getRespect() {
        return respect;
    }

    public int getActive() {
        return active;
    }

    public int getFocus() {
        return focus;
    }

    public int getCollaboration() {
        return collaboration;
    }

    public void setRespect(int respect) {
        this.respect = respect;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public void setCollaboration(int collaboration) {
        this.collaboration = collaboration;
    }

  
      
}
