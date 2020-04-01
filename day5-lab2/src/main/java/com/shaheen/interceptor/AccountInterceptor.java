package com.shaheen.interceptor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.shaheen.entity.Account;
import java.io.Serializable;
import java.util.Iterator;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

/**
 *
 * @author lts
 */
public class AccountInterceptor extends EmptyInterceptor{

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("on Save method");
        
        if(entity instanceof Account){
            Account account = (Account) entity;
            account.setPhone("+2"+account.getPhone());
            entity = account;
        }
        return super.onSave(entity, id, state, propertyNames, types); //To change body of generated methods, choose Tools | Templates.
    }
    
}
