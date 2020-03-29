/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen;

import com.shaheen.entity.BuyerBidProduct;
import com.shaheen.entity.Category;
import com.shaheen.entity.Product;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author lts
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("hi");

        SessionFactory sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Category c = (Category) session.load(Category.class, 49);
        List<Product> list = session.createQuery("from Product p where  "
                + ":givenCategory"
                + " in elements(p.categories)").setEntity("givenCategory", c).list();
        
        System.out.println("number of Product =" + list.size());

        List<BuyerBidProduct> list1 = 
                session.createQuery("from BuyerBidProduct b where b.product = :givenProduct")
                .setEntity("givenProduct", list.get(0)).list();
        System.out.println("number of BuyerBidProduct for " + list.get(0).getName() +" = " + list1.size() );
        
        List list2 = session.createQuery("select sum(b.amount * b.quantity)"
                + " from BuyerBuyProduct b where "
                + " b.product = :givenProduct ").setEntity("givenProduct", list.get(0)).list();
        System.out.println(list2.get(0));
        
        
    }

}
