/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.repository;

import com.shaheen.entity.BuyerBuyProduct;
import com.shaheen.entity.Product;

/**
 *
 * @author lts
 */
public interface BuyerBuyProductRepo extends Crud<BuyerBuyProduct> {

    Double getTotalAmountByProduct(Product product);
}
