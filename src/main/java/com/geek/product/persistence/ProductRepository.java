package com.geek.product.persistence;

import com.geek.product.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {
}
