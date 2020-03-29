/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.repository;

import com.shaheen.config.Config;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author lts
 */
public class CrudImpl<T> implements Crud<T> {

    Session session;

    public CrudImpl() {
        session = Config.getConfig().getSession();
    }

    @Override
    public Set<T> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T save(T t) {
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        return t;
    }

    @Override
    public void delete(T t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
