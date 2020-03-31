/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.repository;

import com.shaheen.entity.Category;
import com.shaheen.entity.Product;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lts
 */
public class ProductRepoImpl extends CrudImpl<Product> implements ProductRepo {

    @Override
    public List<Product> getByCategory(Category category) {
        return getSession().createCriteria(Product.class)
                .createAlias("categories", "c")
                .add(Restrictions.eq("c.id", category.getId()))
                .list();
    }

}
