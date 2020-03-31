/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shaheen.repository;

import com.shaheen.entity.Category;
import com.shaheen.entity.Product;
import java.util.List;

/**
 *
 * @author lts
 */
public interface ProductRepo extends Crud<Product> {

    List<Product> getByCategory(Category category);
}
