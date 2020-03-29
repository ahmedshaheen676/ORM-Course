/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen;

import com.shaheen.entity.Account;
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
        Account account = new Account();
        account.setAddress("cario");
        account.setBirthday(new Date());
        account.setFullName("ahmed shaheen");
        account.setPassword("123456");
        account.setPhone("01061510304");
        account.setUserName("ahmedshaheen");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(account);
        session.getTransaction().commit();

    }
}
