/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author lts
 */
public class Config {

    private static Config config;
    private Session session;

    private Config() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public Session getSession() {
        return session;
    }

    public static Config getConfig() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }
}
