package com.geek.product.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:SpringData-jpa.xml")
public class ProductRepositoryTest {
    @Resource
    ProductRepository productRepository;

    @Test
    public void TestFind() {
        System.out.println("----------" + productRepository.findOne(1L));
    }
}