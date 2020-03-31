/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.repository;

import com.shaheen.entity.BuyerBuyProduct;
import com.shaheen.entity.Product;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author lts
 */
public class BuyerBuyProductRepoImpl extends CrudImpl<BuyerBuyProduct> implements BuyerBuyProductRepo {

    // todo impl this method 
    @Override
    public Double getTotalAmountByProduct(Product product) {
//        return getSession().createCriteria(BuyerBuyProduct.class)
//                .createAlias("product", "p")
//                .add(Restrictions.eq("p.id", product.getId()))
//                .
        throw new UnsupportedOperationException("not impl yet");
    }

}
