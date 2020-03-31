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
import java.util.List;
import java.util.Set;

/**
 *
 * @author lts
 */
public class Service {

    UserRepo userRepo = new UserRepoImpl();
    BuyerRepo buyerRepo = new BuyerRepoImpl();
    SellerRepo sellerRepo = new SellerRepoImpl();
    ProductRepo productRepo = new ProductRepoImpl();
    CategoryRepo categoryRepo = new CategoryRepoImpl();
    BuyerBidProductRepo buyerBidProductRepo = new BuyerBidProductRepoImpl();
    BuyerBuyProductRepo buyerBuyProductRepo = new BuyerBuyProductRepoImpl();
    
    //todo impl search by example 
    public Service() {
        // test new Repos
        User user = createUser("ahmed");

        Buyer buyer = createBuyer(user);

        Seller seller = createSeller(new User("ahmedshaheen676@yahoo.com", "cairo", new Date(),
                "mohmaed", "123456"));

        Product product = createProduct(seller, getCategories());

        createBuyerBidProduct(buyer, product);

        createBuyerBuyProduct(buyer, product);

        // test criteria
        Category category = new Category();
        category.setId(3);
        List<Product> byCategory = productRepo.getByCategory(category);

        System.out.println("find by category ");
        byCategory.forEach(System.out::println);

        List<BuyerBidProduct> byProduct = buyerBidProductRepo.getByProduct(product);
        byProduct.forEach(System.out::println);

    }

    private User createUser(String name) {
        User user = new User("ahmedshaheen676@yahoo.com", "cairo", new Date(),
                name, "123456");
        return userRepo.save(user);

    }

    private Buyer createBuyer(User user) {
        Buyer buyer = new Buyer(user, "buyer1");
        return buyerRepo.save(buyer);
    }

    private Seller createSeller(User user) {
        Seller seller = new Seller(user, "seller1");
        return sellerRepo.save(seller);
    }

    private Product createProduct(Seller seller, Set<Category> categorys) {
        Product product = new Product("product1", "manufactur1", new Date(), 20, new Date(), new Date());
        product.setSeller(seller);
        product.setCategories(categorys);
        return productRepo.save(product);

    }

    private Set<Category> getCategories() {
        Set<Category> categorys = new HashSet<>();
        Category category1 = new Category("category1");
        Category category2 = new Category("category2");
        category1 = categoryRepo.save(category1);
        category2 = categoryRepo.save(category2);
        categorys.add(category1);
        categorys.add(category2);
        return categorys;
    }

    private BuyerBidProduct createBuyerBidProduct(Buyer buyer, Product product) {
        BuyerBidProduct buyerBidProduct = new BuyerBidProduct();
        buyerBidProduct.setId(new BuyerBidProductId(buyer.getId(), product.getId()));
        buyerBidProduct.setAmount(200);
        buyerBidProduct.setBuyer(buyer);
        buyerBidProduct.setDate(new Date());
        buyerBidProduct.setProduct(product);
        buyerBidProduct.setQuantity(20);
        return buyerBidProductRepo.save(buyerBidProduct);
    }

    private BuyerBuyProduct createBuyerBuyProduct(Buyer buyer, Product product) {
        BuyerBuyProduct buyerBuyProduct = new BuyerBuyProduct();
        buyerBuyProduct.setId(new BuyerBuyProductId(buyer.getId(), product.getId()));
        buyerBuyProduct.setAmount(200);
        buyerBuyProduct.setBuyer(buyer);
        buyerBuyProduct.setPaymentDate(new Date());
        buyerBuyProduct.setQuantity(20);
        return buyerBuyProductRepo.save(buyerBuyProduct);
    }
}
