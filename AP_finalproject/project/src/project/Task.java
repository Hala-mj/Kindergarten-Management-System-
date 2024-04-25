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
@Table(name="`projectai`.`task`")
public class Task implements java.io.Serializable {

     @Id
     @Column(name="chid")
     private int chidid;
     @Column(name="title")
     private String title;
     @Column(name="sub")
     private String sub;
     @Column(name="target")
     private String target;
      @Column(name="tasks")
     private String tasks;

    public Task(int chid, String title, String sub, String target, String tasks) {
        this.chidid = chid;
        this.title = title;
        this.sub = sub;
        this.target = target;
        this.tasks = tasks;
    }

    public Task() {
    }

    public void setChid(int chid) {
        this.chidid = chid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public int getChid() {
        return chidid;
    }

    public String getTitle() {
        return title;
    }

    public String getSub() {
        return sub;
    }

    public String getTarget() {
        return target;
    }

    public String getTasks() {
        return tasks;
    }
      
      

    
}
