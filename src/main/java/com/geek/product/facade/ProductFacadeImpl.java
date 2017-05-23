package com.geek.product.facade;

import com.geek.product.domain.Product;
import com.geek.product.persistence.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
@Service
public class ProductFacadeImpl implements ProductFacade {
    @Resource
    private ProductRepository productRepository;

    public Iterable<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findOne(id);
    }
}
