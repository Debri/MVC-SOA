package com.geek.product.facade;

import com.geek.product.domain.Product;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
public interface ProductFacade {
    public Iterable<Product> findAllProduct();

    public Product findProductById(Long id);

}
