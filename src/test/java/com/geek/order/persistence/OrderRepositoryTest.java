package com.geek.order.persistence;

import com.geek.order.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Iterator;

/**
 * Created by Liuqi
 * Date: 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath*:SpringData-jpa.xml")
public class OrderRepositoryTest {
    @Resource
    OrderRepository orderRepository;

    @Test
    public void testUpdateOrderByTrade() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setProductId(1L);
        order.setUserId(2L);
        order.setPrice(123);
        order.setDeleted(0);
        order.setTradeId(1L);
        order.setTradeStatus(0);
        Order order1 = orderRepository.save(order);
        System.out.println("====================" + order1);
    }

    @Test
    public void TestFind() {
        /*Order order = orderRepository.findOne(1L);
        System.out.println(order);*/
        Iterable<Order> iterable = orderRepository.find();
        Iterator ite = iterable.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
    }
}