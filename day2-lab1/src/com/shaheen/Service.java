/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen;

import com.shaheen.entity.Buyer;
import com.shaheen.entity.BuyerBidProduct;
import com.shaheen.entity.BuyerBidProductId;
import com.shaheen.entity.BuyerBuyProduct;
import com.shaheen.entity.BuyerBuyProductId;
import com.shaheen.entity.Category;
import com.shaheen.entity.Product;
import com.shaheen.entity.Seller;
import com.shaheen.entity.User;
import com.shaheen.repository.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lts
 */
public class Service {

    public Service() {
        User user = createUser("ahmed");

        Buyer buyer = createBuyer(user);

        Seller seller = createSeller(new User("ahmedshaheen676@yahoo.com", "cairo", new Date(),
                "mohmaed", "123456"));
        
        Product product = createProduct(seller, getCategories());
        
        createBuyerBidProduct(buyer, product );
        
        createBuyerBuyProduct(buyer, product);

    }

    private User createUser(String name) {
        User user = new User("ahmedshaheen676@yahoo.com", "cairo", new Date(),
                name, "123456");
        Crud<User> crud = new CrudImpl();
        return crud.save(user);

    }

    private Buyer createBuyer(User user) {
        Buyer buyer = new Buyer(user, "buyer1");
        Crud<Buyer> crud = new CrudImpl();
        return crud.save(buyer);
    }

    private Seller createSeller(User user) {
        Seller seller = new Seller(user, "seller1");
        Crud<Seller> crud = new CrudImpl<>();
        return crud.save(seller);
    }

    private Product createProduct(Seller seller, Set<Category> categorys) {
        Product product = new Product("product1", "manufactur1", new Date(), 20, new Date(), new Date());
        product.setSeller(seller);
        product.setCategories(categorys);
        Crud<Product> crud = new CrudImpl<>();
        return crud.save(product);

    }

    private Set<Category> getCategories() {
        Set<Category> categorys = new HashSet<>();
        Category category1 = new Category("category1");
        Category category2 = new Category("category2");
        Crud<Category> crud = new CrudImpl<>();
        category1 = crud.save(category1);
        category2 = crud.save(category2);
        categorys.add(category1);
        categorys.add(category2);
        return categorys;
    }

    private BuyerBidProduct createBuyerBidProduct(Buyer buyer,Product product) {
        BuyerBidProduct buyerBidProduct = new BuyerBidProduct();
        buyerBidProduct.setId(new BuyerBidProductId(buyer.getId() ,product.getId()) );
        buyerBidProduct.setAmount(200);
        buyerBidProduct.setBuyer(buyer);
        buyerBidProduct.setDate(new Date());
        buyerBidProduct.setProduct(product);
        buyerBidProduct.setQuantity(20);
        Crud<BuyerBidProduct> crud = new CrudImpl<>();
        return crud.save(buyerBidProduct);
    }

    private BuyerBuyProduct createBuyerBuyProduct(Buyer buyer, Product product) {
        BuyerBuyProduct  buyerBuyProduct = new BuyerBuyProduct();
        buyerBuyProduct.setId(new BuyerBuyProductId(buyer.getId(), product.getId()));
        buyerBuyProduct.setAmount(200);
        buyerBuyProduct.setBuyer(buyer);
        buyerBuyProduct.setPaymentDate(new Date());
        buyerBuyProduct.setQuantity(20);
         Crud<BuyerBuyProduct> crud = new CrudImpl<>();
        return crud.save(buyerBuyProduct);
    }
}
