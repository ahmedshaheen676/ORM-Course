package com.shaheen.entity;
// Generated Mar 29, 2020 5:02:03 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Teacher generated by hbm2java
 */
public class Teacher  implements java.io.Serializable {


     private Integer id;
     private Date hireDate;

    public Teacher() {
    }

    public Teacher(Date hireDate) {
       this.hireDate = hireDate;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getHireDate() {
        return this.hireDate;
    }
    
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }




}

