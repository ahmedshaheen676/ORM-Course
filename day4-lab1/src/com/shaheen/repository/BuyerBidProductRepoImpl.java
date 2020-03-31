/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.repository;

import com.shaheen.entity.BuyerBidProduct;
import com.shaheen.entity.Product;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lts
 */
public class BuyerBidProductRepoImpl extends CrudImpl<BuyerBidProduct> implements BuyerBidProductRepo {

    @Override
    public List<BuyerBidProduct> getByProduct(Product product) {
        return getSession().createCriteria(BuyerBidProduct.class)
                .createAlias("product", "p")
                .add(Restrictions.eq("p.id", product.getId()))
                        .list();
    }

}
