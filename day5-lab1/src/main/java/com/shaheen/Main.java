/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen;

import com.shaheen.model.Comment;
import com.shaheen.model.Post;
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
//        Student student = new Student("ahmed", "ahmed@yahoo.com", new Date());
        Post post = new Post("hi , this is my first post", new Date());
        
        Comment comment1 = new Comment("welcom man", new Date());
        Comment comment2 = new Comment("hi , you r welcom too", new Date());
       
        comment1.setPost(post);
        comment2.setPost(post);
        
        post.getComments().add(comment1);
        post.getComments().add(comment2);


        entityManager.getTransaction().begin();
        entityManager.persist(post);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
                
    }
}
