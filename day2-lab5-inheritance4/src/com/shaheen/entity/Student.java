package com.shaheen.entity;
// Generated Mar 29, 2020 5:02:03 PM by Hibernate Tools 4.3.1



/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private Integer id;
     private String department;

    public Student() {
    }

    public Student(String department) {
       this.department = department;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }




}

