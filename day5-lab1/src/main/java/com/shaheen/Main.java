/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen;

import com.shaheen.model.Student;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author lts
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory 
                = Persistence.createEntityManagerFactory("presistance");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = new Student("ahmed", "ahmed@yahoo.com", new Date());
       
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
                
    }
}
