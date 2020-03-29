/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen;

import com.shaheen.entity.Student;
import com.shaheen.entity.Teacher;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author lts
 */
public class Main {

    public static void main(String[] args) {

        Teacher teacher = new Teacher("mohamed", "shaheen", new Date());
        Student student = new Student("yousef", "shaheen", "iti");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(teacher);
        session.persist(student);
        session.getTransaction().commit();
    }
}
