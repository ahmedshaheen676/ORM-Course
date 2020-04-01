/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.operationlistner;

import com.shaheen.entity.Account;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.EventSource;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.event.spi.SaveOrUpdateEventListener;

/**
 *
 * @author lts
 */
public class AccountOnSaveOrUpdate implements SaveOrUpdateEventListener {

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) throws HibernateException {
        System.out.println("On save or update");
        if (event.getObject() instanceof Account) {
            Account account = (Account) event.getObject();
            EventSource session = event.getSession();
            List<Account> list = session.createQuery("from Account ac where ac.userName =" + account.getUserName()).list();
            if (!list.isEmpty()) {
                throw new HibernateException("Account founded on db");
            }
            System.out.println("saved on db");
        }
    }

}
