package com.shaheen.entity;
// Generated Mar 29, 2020 4:46:30 PM by Hibernate Tools 4.3.1

/**
 * Student generated by hbm2java
 */
public class Student extends Person implements java.io.Serializable {

    private String department;

    public Student() {
    }

    public Student(String firstName, String lastName, String department) {
        super(firstName, lastName);
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
