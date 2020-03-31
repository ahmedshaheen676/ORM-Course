/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.shaheen.config.Config;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author lts
 */
public abstract class CrudImpl<T> implements Crud<T> {

    private final Session session = Config.getConfig().getSession();
    private final String typeName = getTypeName();

    @Override
    public List<T> findAll() {
        return session.createQuery("from " + typeName).list();
    }

    @Override
    public T findById(int id) {
        return (T) session.load(typeName, id);
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
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
    }

    private String getTypeName() {
        try {
            Type sooper = getClass().getGenericSuperclass();
            Type t = ((ParameterizedType) sooper).getActualTypeArguments()[0];
            return t.getTypeName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Session getSession() {
        return session;
    }

}
